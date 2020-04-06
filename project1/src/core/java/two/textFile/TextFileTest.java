package core.java.two.textFile;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.Locale;
import java.util.Scanner;

public class TextFileTest {
    public static void main(String[] args) throws IOException {
        Employee[] staff = new Employee[3];
        staff[0] = new Employee("CARL", 75000, 1987, 12, 15);
        staff[1] = new Employee("HARRY", 50000, 1989, 1, 5);
        staff[2] = new Employee("TONY", 40000, 1990, 2, 1);

        try (PrintWriter out = new PrintWriter("employee.dat", "UTF-8")) {
            writeData(staff, out);
        }

        try (Scanner in = new Scanner(
                new FileInputStream("employee.dat"), "UTF-8")) {
            Employee[] newStaff = readData(in);
            for (Employee e : newStaff) {
                System.out.printf("%-5s",e.getName());
                System.out.println("|" + e.getSalary() + "|" + e.getHireDay());
            }
        }
    }

    public static void writeData(Employee[] employees, PrintWriter out) throws IOException {
        out.println(employees.length);

        for (Employee e : employees) {
            writeEmployee(out, e);
        }
    }

    private static Employee[] readData(Scanner in) {
        int n = in.nextInt();//读入employee.dat中Employee的数组长度
        in.nextLine();
        Employee[] employees = new Employee[n];
        for (int i = 0; i < n; i++) {
            employees[i] = readEmployee(in);
        }
        return employees;
    }

    public static void writeEmployee(PrintWriter out, Employee e) {
        out.println(e.getName() + "|" + e.getSalary() + "|" + e.getHireDay());
    }

    public static Employee readEmployee(Scanner in) {
        String line = in.nextLine();
        String[] tokens = line.split("\\|");
        String name = tokens[0];
        double salary = Double.parseDouble(tokens[1]);
        LocalDate hireDate = LocalDate.parse(tokens[2]);
        int year = hireDate.getYear();
        int month = hireDate.getMonthValue();
        int day = hireDate.getDayOfMonth();
        return new Employee(name, salary, year, month, day);
    }
}
