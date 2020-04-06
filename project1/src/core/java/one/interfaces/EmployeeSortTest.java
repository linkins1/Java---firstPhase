package core.java.one.interfaces;

import java.util.Arrays;

/**
 * The type Employee sort test.
 * 这个类用于测试接口，本例中要想使用Arrays.sort方法就必须实现Comparable接口中的compareTo方法
 * 在调用的时候，会按照本类中对应接口中方法的具体实现来完成方法的调用
 */
public class EmployeeSortTest {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        Employee[] staff = new Employee[3];
        staff[0] = new Employee("Harry Hacker", 35000);
        staff[1] = new Employee("Carl Cracker", 75000);
        staff[2] = new Employee("Tony Tester", 38000);
        Arrays.sort(staff);
        //针对此类中的情况，由于Employee中实现了Comparable接口中的compareTo方法，比较的是此类中两个雇员的薪水
        // 因而在调用sort时，比较的是两者的薪水

        for (Employee e : staff)
            System.out.println("name" + e.getName() + ", salary" + e.getSalary());

    }
}
