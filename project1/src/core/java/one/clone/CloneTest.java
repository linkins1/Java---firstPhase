package core.java.one.clone;

/**
 * The type Clone test.
 * 此类实现了一个深拷贝
 */
public class CloneTest {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        try {
            Employee original = new Employee("john Q", 50000);
            original.setHireday(2000, 1, 1);
            Employee copy = original.clone();

            copy.raiseSalary(100);
            copy.setHireday(2002, 12, 31);
            System.out.println(copy.getA()==original.getA());
            System.out.println(original.getName().hashCode());
            System.out.println(copy.getName().hashCode());
            original.setName();
            //original.getName().replace('o','s');

            copy.setA(2);
            System.out.println("original= " + original);
            System.out.println("copy= " + copy);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
