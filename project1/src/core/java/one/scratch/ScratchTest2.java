
package core.java.one.scratch;

/**
 * The type Scratch test 2.
 * 此部分为关于Java中数值的传递的验证
 * Java中的参数的传递的方法都是值的传递,对象的引用也是按值传递的
 */
public class ScratchTest2 {
    private int test = 1;
    private String value = "father's value";

    /**
     * Instantiates a new Scratch test 2.
     *
     */
    public ScratchTest2(){

    }

    /**
     * Instantiates a new Scratch test 2.
     *
     * @param a the a
     */
    public ScratchTest2(int a) {
        a = a * 10;
        System.out.println("constructor's value = " + a);
    }

    /**
     * Double it.
     *
     * @param scratchTest2 the scratch test 2
     * @param a            the a
     */
    public static void doubleIt(ScratchTest2 scratchTest2, int a) {
        a = scratchTest2.doubleiT(a);
        System.out.println("doubleIt's a = " + a);
    }

    /**
     * Doublei t int.
     *
     * @param a the a
     * @return the int
     */
    public int doubleiT(int a) {
        return a * 2;
    }

    /**
     * Double t.
     */
    public void doubleT() {
        test = test * 2;
    }

    /**
     * Swap.
     *
     * @param scratchTest2_1 the scratch test 2 1
     * @param scratchTest2_2 the scratch test 2 2
     */
    public static void swap(ScratchTest2 scratchTest2_1, ScratchTest2 scratchTest2_2) {
        ScratchTest2 temp;
        temp = scratchTest2_1;
        scratchTest2_1 = scratchTest2_2;
        scratchTest2_2 = temp;
        System.out.println("scratchTest2_1's test = " + scratchTest2_1.test);
        System.out.println("scratchTest2_2's test = " + scratchTest2_2.test);

    }

    /**
     * Double test.
     *
     * @param scratchTest2 the scratch test 2
     */
    public static void doubleTest(ScratchTest2 scratchTest2) {
        scratchTest2.doubleT();
    }

    /**
     * Getvalue string.
     *
     * @return the string
     *
     * protected 保证只有子类可以访问此方法来访问私有域，保证了安全性
     */
    protected String getvalue(){
        return value;
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        int a = 1;
        ScratchTest2 scratchTest2_1 = new ScratchTest2(a);//基本类型进行的是值的传递
        System.out.println("main's a = " + a);
        System.out.println();

        doubleIt(scratchTest2_1, a);
        System.out.println("main's a = " + a);
        doubleTest(scratchTest2_1);

        System.out.println();
        System.out.println("scratchTest2_1.test = " + scratchTest2_1.test);//类内部的变量

        int b = 2;
        System.out.println();
        ScratchTest2 scratchTest2_2 = new ScratchTest2(b);
        System.out.println();
        swap(scratchTest2_2, scratchTest2_1);
        System.out.println();
        if (scratchTest2_1.test == 2)
            System.out.println("swap failure");
    }
}
