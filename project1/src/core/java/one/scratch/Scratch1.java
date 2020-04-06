package core.java.one.scratch;

import java.util.Scanner;

public class Scratch1 {
    private static int a = 1;

    public static void get1(){
        System.out.println("public static");
    }
    private static void get2(){
        System.out.println("can't!!!");
    }
    protected void get3(){
        System.out.println("protected not static");
    }
    public static void main(String[] args) {
        // int a = 3;
        Scratch1 scratch1 = new Scratch1();

        Integer b;
        b = Integer.valueOf(1);
        int c = 1;
        int a = Math.abs(1);

        if (b == c)
            System.out.println("c=b");
        Scanner scanner = new Scanner(System.in);
        int e = a + 1;
        System.out.println(e);
        int d = scanner.nextInt();
        switch (d) {
            case 4:
                System.out.println(4);
            case 3:
                System.out.println(3);
                break;
            case 2:
                System.out.println(2);
            case 1:
                System.out.println(1);
                break;
            default:
                System.out.println("wrong starting number");

        }
    }
}
