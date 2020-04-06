package core.java.one.scratch;

import core.java.one.interfaces.Employee;

import java.util.*;

public class ScratchView {
    public static void main(String[] args) {
        Employee[] employee = new Employee[3];
        employee[0] = new Employee("sj1", 1);
        employee[1] = new Employee("sj2", 2);
        employee[2] = new Employee("sj3", 3);
        List<Employee> list = Arrays.asList(employee);
        list.forEach(v-> System.out.println("Name="+v.getName()+",Salary="+v.getSalary()));
        List<String> list1 = Collections.nCopies(5,"hahaha");
        list1.forEach(v-> System.out.println(v.toString()));
        List<String> list2 = new LinkedList<>();

        list2.add("1");
        list2.add("2");
        list2.add("3");
        list2.add("4");

        List<String> list3 = list2.subList(0,2);
        list3.clear();
        list2.forEach(v-> System.out.println(v));

        List<String> list4 = list1.subList(0,2);
        list4.forEach(v-> System.out.println(v));
//      list4.clear();
//      此处由于list1为一个视图，尽管list4是子范围视图，
//      由于list1只能进行get和set，因而不能执行list4.clear，这会对list1产生影响
    }
}
