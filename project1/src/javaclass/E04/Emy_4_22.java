package javaclass.E04;

import java.util.Scanner;

public class Emy_4_22 {
    public static void main(String[] args) {
        System.out.print("Enter String s1: ");
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.next();
        System.out.print("Enter String s2: ");
        String s2 = scanner.next();
        if (s1.contains(s2))
            System.out.println(s2 + " is a substring of " + s1);
        else
            System.out.println(s2 + " is not a substring of" + s1);
    }
}
