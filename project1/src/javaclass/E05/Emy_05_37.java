package javaclass.E05;

import java.util.Scanner;

public class Emy_05_37 {
    public static String toBinary(int n) {
        StringBuilder sb = new StringBuilder();
        while (n != 0) {
            sb.append(n % 2);
            n = n / 2;
        }
        return sb.reverse().toString();
    }

    public static String toOctal(int n) {
        StringBuilder sb = new StringBuilder();
        while (n != 0) {
            sb.append(n % 8);
            n = n / 8;
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.print("enter a decimal: ");
        Scanner scanner = new Scanner(System.in);
        int Decimal = scanner.nextInt();
        System.out.println("to binary string is: " + toBinary(Decimal));
        System.out.println("to Octal  string is: " + toOctal(Decimal));
    }
}
