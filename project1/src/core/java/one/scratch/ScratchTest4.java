package core.java.one.scratch;

class parent111{
    public parent111() {
        System.out.println("i am parent");
        meth1();
    }
    int a=1111;
    public void meth1() {
        System.out.println(a);
    }
}
public class ScratchTest4 extends parent111 {
//    public ScratchTest4() {
//        System.out.println("i am son");
//        meth2();
//    }
    int b=2222;
    public void meth2() {
        System.out.println(b);
    }
    public static void main(String[] args) {
        parent111 p1 = new parent111();
        ScratchTest4 p2 = new ScratchTest4();
        p2.meth1();
        parent111 p3 = new ScratchTest4();
        p3.meth1();
        ((ScratchTest4)p3).meth2();

    }
}
