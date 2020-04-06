package core.java.one.equals;

import static java.lang.Double.valueOf;

public class Manager extends Employee {
    private double bonus;

    public Manager(String name, double salary, int year, int month, int day) {
        super(name, salary, year, month, day);
        bonus = 0;
    }

    public double getSalary() {
        double baseS = super.getSalary();
        return baseS + bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public boolean equals(Object bObject) {
        if (!super.equals(bObject))
            return false;
        Manager m = (Manager) bObject;
        return bonus == m.bonus;
    }

    public int hashCode() {
        return super.hashCode() + 17 * valueOf(bonus).hashCode();
    }

    public String toString() {
        return super.toString() + "[bonus=" + bonus + "]";
    }

    public void copy(Employee em){
         this.hireday=em.hireday;
    }

}
