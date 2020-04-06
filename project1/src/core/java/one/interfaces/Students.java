package core.java.one.interfaces;

interface Named {
    default String getName() {
        return getClass().getName();
    }
}

interface Person {
    default String getName() {
        return getClass().getName() + " " + hashCode();
    }
}


public class Students extends Persoon implements Named, Person {
    private String name;

    public Students(String name) {
        this.name = name;
    }

    public String getName() {
        return Person.super.getName();
    }

    public static void main(String[] args) {
        Persoon students = new Students("name");
        Persoon persoon = new Persoon("name");
        System.out.println(students.getName());
        System.out.println(persoon.getName());
    }
}
