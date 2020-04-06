package javaclass.E05;

import java.util.Scanner;

public class Emy_05_14 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("input two numbers = ");
        int a1 = scanner.nextInt();
        int a2 = scanner.nextInt();
        int min = Math.min(a1, a2);
        while (min > 0) {
            if (a1 % min == 0 && a2 % min == 0) {
                System.out.println("the num is = " + min);
                return;
            }
            min--;
        }
    }
}
