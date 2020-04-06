package core.java.one.scratch;

public class ScratchTest3 {
    private static int a =1;
    public static boolean check(){
        for (int i = 0; i <3 ; i++) {
            if(i==1)
                return true;
        }
        return false;
    }
    public static void main(String[] args) {
        if(check())
            System.out.println("1");
        for (int i = 0; i <4 ; i++) {
            if(i==1)
                continue;
                a++;
             //   return;
        }
        System.out.println(a);
        Class cl = int.class;
        //int.class代表Class类型的对象，int不是类
        System.out.println(cl.getClass());

    }
}
