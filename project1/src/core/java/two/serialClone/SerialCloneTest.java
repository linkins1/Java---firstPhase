package core.java.two.serialClone;

import java.io.*;
import java.time.LocalDate;

public class SerialCloneTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        Employee harry = new Employee("Harry", 3500, 1919, 12, 1);
        Employee harry2 = (Employee) harry.clone();

        harry.raiseSalary(10);

        System.out.println(harry);
        System.out.println(harry2);

    }
}

class SerialCloneable implements Cloneable, Serializable {
    public Object clone() throws CloneNotSupportedException {
        try {
            ByteArrayOutputStream bout = new ByteArrayOutputStream();
            try (ObjectOutputStream out = new ObjectOutputStream(bout)) {
                out.writeObject(this);//本例中this指向harry
            }
            try (InputStream bin = new ByteArrayInputStream(bout.toByteArray())) {
                ObjectInputStream in = new ObjectInputStream(bin);
                return in.readObject();
            }
        } catch (IOException | ClassNotFoundException e) {
            CloneNotSupportedException e2 = new CloneNotSupportedException();
            e2.initCause(e);
            throw e2;
        }
    }
}

class Employee extends SerialCloneable {
    private String name;
    private double salary;
    private LocalDate hireDay;
    public static final int NAME_SIZE = 40;
    public static final int RECORD_SIZE = 100;


    public Employee() {

    }

    public Employee(String name, double salary, int year, int month, int day) {
        this.name = name;
        this.salary = salary;
        hireDay = LocalDate.of(year, month, day);
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public LocalDate getHireDay() {
        return hireDay;
    }

    public void raiseSalary(int bonus) {
        this.salary += bonus;
    }

    public String toString() {
        return this.name + " " + this.salary + " " + this.hireDay;
    }
}