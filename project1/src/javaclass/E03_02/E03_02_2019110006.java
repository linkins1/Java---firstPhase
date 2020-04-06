package javaclass.E03_02;

import java.util.Scanner;

public class E03_02_2019110006 {
    private static int[] parseString(String s) {
        int a[] = new int[s.length() + 1];
        for (int i = 0; i < s.length(); i++) {
            a[i] = Integer.parseInt(String.valueOf(s.charAt(i)));
        }
        return a;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the first 9 digits of an ISBN as Integer: ");
        int[] d = new int[10];
        String s = scanner.nextLine();
        d = parseString(s);
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            sum += d[i] * (i + 1);
        }
        d[9] = sum % 11;
        System.out.println();
        System.out.print("The ISBN number is :");
        if (d[9] == 10) {
            for (int i = 0; i < 9; i++) {
                System.out.print(d[i]);
            }
            System.out.print("X");
        } else {
            for (int i = 0; i < 10; i++) {
                System.out.print(d[i]);
            }
        }
    }
}
