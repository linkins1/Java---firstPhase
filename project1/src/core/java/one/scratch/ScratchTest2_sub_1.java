package core.java.one.scratch;

/**
 * 验证了数值的传递方式以及instanceof的判断
 */
public class ScratchTest2_sub_1 extends ScratchTest2 {
    public ScratchTest2_sub_1() {
        System.out.println("value = " + super.getvalue());
    }

    public void test() {
        System.out.println("this is from ScratchTest2_sub_1");
    }

    public static void main(String[] args) {
        ScratchTest2 scratchTest2_sub_1 = new ScratchTest2_sub_1();
        System.out.println(scratchTest2_sub_1.getClass());
        if (scratchTest2_sub_1 instanceof ScratchTest2_sub_1) {
            System.out.println(scratchTest2_sub_1 instanceof ScratchTest2_sub_1);
            ScratchTest2_sub_1 scratchTest2_sub_11 = (ScratchTest2_sub_1) scratchTest2_sub_1;
            scratchTest2_sub_11.test();
            System.out.println(scratchTest2_sub_11.getClass());

        }
        System.out.println();
        if (scratchTest2_sub_1 instanceof ScratchTest2) {
            System.out.println(scratchTest2_sub_1 instanceof ScratchTest2);
            ScratchTest2_sub_1 scratchTest2_sub_11 = (ScratchTest2_sub_1) scratchTest2_sub_1;
            scratchTest2_sub_11.test();
            System.out.println(scratchTest2_sub_11.getClass());
        }
    }
}