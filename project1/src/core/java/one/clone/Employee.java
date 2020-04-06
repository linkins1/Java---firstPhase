package core.java.one.clone;

import java.util.Date;
import java.util.GregorianCalendar;

public class Employee implements Cloneable {
    private String name;
    private double salary;
    private int[] a = new int[]{1};
    private Date hireday;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
        hireday = new Date();
    }
    public void setName(){
        this.name=this.name.toUpperCase();
        //name指向另一块存储着大写的字符串，原小写字符串没有改变
    }

    public void setA(int ba){
        this.a[0] = ba;
    }
    public int getA(){
        return a[0];
    }
    protected Employee clone() throws CloneNotSupportedException {
        //call Object clone
        Employee cloned = (Employee) super.clone();
        //clone mutable fields
        cloned.hireday = (Date) hireday.clone();
        return cloned;
    }

    public void setHireday(int year, int month, int day) {
        Date newHireDay = new GregorianCalendar(year, month - 1, day).getTime();
        hireday.setTime(newHireDay.getTime());
    }

    public void raiseSalary(double percent) {
        double raise = salary * percent / 100;
        salary += raise;
    }

    public String toString() {
        return "Employee[name=" + name + ", salary=" + salary + ", hireday=" + hireday + "]"+"plus"+a[0];
    }

    public String getName(){
        return name;
    }
    public double getSalary(){
        return salary;
    }
    public Date getHireday(){
        return hireday;
    }

}
class Manager extends Employee{
    public Manager(String name, double salary){
        super(name,salary);
    }
}

