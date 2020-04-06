package core.java.one.map;

import core.java.one.interfaces.Employee;

import java.util.HashMap;
import java.util.Map;

/**
 * The type Map test.
 * 本类验证了HashMap的增删改查,给出了两种遍历方式；HashMap为随机存储对象，所以遍历时对象出现是按随机顺序
 * 但是这个顺序不会因为遍历次数而改变
 */
public class MapTest {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        Map<String, Employee> staff = new HashMap<>();
        staff.put("100-100-001", new Employee("Sarah", 100));
        staff.put("100-100-002", new Employee("Jack", 200));
        staff.put("100-100-003", new Employee("Laney", 300));
        staff.put("100-100-004", new Employee("Trevor", 400));
        System.out.println("100-100-002's salary = " + staff.get("100-100-002").getSalary());
        staff.remove("100-100-002");
        staff.put("100-100-121", new Employee("sj", 500));
        for (String s : staff.keySet()) {
            System.out.println(staff.get(s).getName());
        }
        //两种遍历方法
        staff.forEach((k, v) -> System.out.println("key = " + k + ", name = " + v.getName() + ", salary =" + v.getSalary()));
    }
}
