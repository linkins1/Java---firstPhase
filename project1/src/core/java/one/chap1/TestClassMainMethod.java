package core.java.one.chap1;

public class TestClassMainMethod {
    public static void main(String[] args) {
        System.out.println("this is a test");
        innertest t1 = new innertest("carl");
        innertest t2 = new innertest("lucy");
        t1.setid();
        t2.setid();
        System.out.println(t1.getname() + " " + t1.getid());
        System.out.println(t2.getname() + " " + t2.getid());
        System.out.println(innertest.getNextid());
    }

}

class innertest {
    private String name;
    private int id;
    private static int nextid = 0;

    public innertest(String n) {
        name = n;
    }

    public String getname() {
        return name;
    }

    public void setid() {
        id = nextid;
        nextid++;
    }

    public int getid() {
        return id;
    }

    public static int getNextid() {
        return nextid;
    }

    public static void main(String[] args) {
        innertest in1 = new innertest("sj");
        in1.setid();
        System.out.println(in1.getname() + " " + in1.getid());
    }
}