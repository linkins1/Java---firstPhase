package core.java.one.asserts;

import java.util.Scanner;

public class AssertTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] x1 =new String[1];
        for (int i = 0; i < 1; i++) {
            System.out.println("input");
            x1[i]=scanner.next();
        }
        String[] x = {"s"};
        System.out.println(x[0].hashCode());
        System.out.println(x1[0].hashCode());

        if(x[0]=="s"){//池中有"s"，会自动引用向同一个字符串
            //x1[0]!=s,因为对象引用不同
            System.out.println(x[0]+"aaa");
        }
        assert x1[0].equals("s"):x;
       // assert x1[0]=="s":x;
        System.out.println("pass the assert");
    }
}
