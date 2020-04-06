package core.java.two.textFile;

public class Manager extends Employee {
    private Employee sec;
    public Manager(String name, double salary, int year, int month, int day) {
        super(name, salary, year, month, day);
    }
    public void setSec(Employee sec1){
        sec = sec1;
    }
    public Employee getSec(){
        return sec;
    }
}
