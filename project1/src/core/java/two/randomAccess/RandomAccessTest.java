package core.java.two.randomAccess;


import core.java.two.textFile.Employee;

import java.io.*;
import java.time.LocalDate;
import java.util.EnumMap;

public class RandomAccessTest {
    public static void main(String[] args) throws IOException {
        Employee[] staff = new Employee[3];
        staff[0] = new Employee("CARL", 75000, 1987, 12, 15);
        staff[1] = new Employee("HARRY", 50000, 1989, 10, 5);
        staff[2] = new Employee("TONY", 40000, 1990, 2, 1);

        try(DataOutputStream out = new DataOutputStream(new FileOutputStream("employee1.dat"))){
            //
            for(Employee e : staff)
                writeData(out, e);
        }
        try(RandomAccessFile in = new RandomAccessFile("employee1.dat", "r")){
            int n = (int)(in.length()/Employee.RECORD_SIZE);
            Employee[] newStaff = new Employee[n];
            for (int i = n-1; i >= 0; i--) {
                in.seek(i* Employee.RECORD_SIZE);
                newStaff[n-1-i] = readData(in);
            }
            for (Employee e : newStaff){
                System.out.printf("%-5s",e.getName());
                System.out.println("|" + e.getSalary() + "|" + e.getHireDay());
            }
        }
    }
    public static void writeData(DataOutput out, Employee e) throws IOException{
        DataIO.writeFixedString(e.getName(), Employee.NAME_SIZE, out);
        out.writeDouble(e.getSalary());

        LocalDate hireDay = e.getHireDay();
        out.writeInt(hireDay.getYear());
        out.writeInt(hireDay.getMonthValue());
        out.writeInt(hireDay.getDayOfMonth());
    }
    public static Employee readData(DataInput in)throws IOException{
        String name = DataIO.readFixedString(Employee.NAME_SIZE, in);
        double salary = in.readDouble();
        int y = in.readInt();
        int m = in.readInt();
        int d = in.readInt();
        return new Employee(name, salary, y ,m-1, d);
    }
}
