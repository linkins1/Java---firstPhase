package core.java.one.set.Enum;

import core.java.one.interfaces.Employee;

import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Map;

public class EnumTest {
    enum WEEK {MON, TUE, WED, THU, FRI, SAT, SUN}

    ;

    public static void main(String[] args) {
        EnumSet<WEEK> enumSet = EnumSet.allOf(WEEK.class);
        System.out.println(enumSet);
        enumSet.remove(WEEK.SUN);
        System.out.println(enumSet);
        Map<WEEK, Employee> map = new EnumMap<>(WEEK.class);
        map.put(WEEK.MON, new Employee("sj1", 100));
        map.put(WEEK.FRI, new Employee("sj2", 200));
        map.put(WEEK.SAT, new Employee("sj3", 300));
        map.forEach((k, v) -> System.out.println(k.name() + v.getName() + v.getSalary()));
    }
}
