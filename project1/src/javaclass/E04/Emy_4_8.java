package javaclass.E04;

import java.util.Scanner;

public class Emy_4_8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("please enter a ascii code: ");
        int a = scanner.nextInt();
        char a1 = (char)a;
        System.out.print("please enter a char: ");
        char b = scanner.next().charAt(0);
        int b1 =b;
        System.out.println("the ascii is :"+a1+" , and the ascii of "+b+" is: "+b1);
        System.out.printf("%x",16);
        System.out.println();
        System.out.print(Integer.toBinaryString(0x10));
    }
}
