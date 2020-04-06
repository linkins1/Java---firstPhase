package core.java.one.equals;

import java.time.LocalDate;
import java.util.Objects;

public class Employee {
    private String name;
    private double salary;
    protected LocalDate hireday;

    public Employee(String name, double salary, int year, int month, int day) {
        this.name = name;
        this.salary = salary;
        hireday = LocalDate.of(year, month, day);
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public LocalDate getHireday() {
        return hireday;
    }

    public void raisesalary(double bypercent) {
        double raise = salary * bypercent / 100;
        salary += raise;
    }

    public boolean equals(Object aObject) {
        if (this == aObject)
            return true;
        if (aObject == null)
            return false;
        if (this.getClass() != aObject.getClass())
            return false;
        Employee t = (Employee) aObject;
        return (Objects.equals(name, t.name)) && (Objects.equals(hireday, t.hireday)) && (salary == t.salary);
    }

    public int hashCode() {
        return Objects.hash(name, salary, hireday);
    }

    public String toString() {
        return getClass().getName() + "[name=" + name + ",salary=" + salary + ",hireday=" + hireday + "]";
    }

}
