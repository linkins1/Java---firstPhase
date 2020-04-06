package core.java.one.equals;

public class Equaltest {
    public static void main(String[] args) {
        Employee alice1 = new Employee("Alice admas", 75000, 1987, 12, 15);
        Employee alice2 = alice1;
        Employee alice3 = new Employee("Alice admas", 75000, 1987, 12, 15);
        Employee bob = new Employee("Bob brandson", 50000, 1989, 10, 1);
        System.out.println("alice1 == alice2:" + (alice1 == alice2));
        System.out.println("alice1 == alice3:" + (alice1 == alice3));
        System.out.println("alice1.equals(alice3):" + alice1.equals(alice3));
        System.out.println("alice1.equals(bob):" + alice1.equals(bob));
        Manager carl = new Manager("Carl cracker", 80000, 1987, 12, 15);
        Manager boss = new Manager("Carl cracker", 80000, 1987, 12, 15);
        boss.setBonus(1);
        System.out.println("boss.toString:" + boss);
        System.out.println("carl.equals(boss):" + carl.equals(boss));
        System.out.println("alice1.hashCode():" + alice1.hashCode());
        System.out.println("alice3.hashCode():" + alice3.hashCode());
        System.out.println("Carl.hashCode():" + carl.hashCode());
        System.out.println("bob.hashCode():" + bob.hashCode());
        System.out.println("boss.hashCode():" + boss.hashCode());
        if (alice1.getClass().getName() == Employee.class.getName())//or alice1.getClass() == Employee.class
            System.out.println("classes match");
        System.out.println(carl.getClass().getName());


        carl.copy(bob);
        System.out.println(carl);
    }
}
