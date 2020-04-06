package javaclass.E02;

import java.util.Scanner;

public class Emy_2_7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("please input the number: ");
        int a = scanner.nextInt();
        int sum = 0;
        while (a != 0) {
            sum = sum + a % 10;
            a = a / 10;
        }
        System.out.println("the result is: " + sum);
    }
}
