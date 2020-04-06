package core.java.two.textFile;


import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.GregorianCalendar;

public class Employee implements Cloneable, Serializable{
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
}

