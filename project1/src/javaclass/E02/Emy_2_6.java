package javaclass.E02;

import java.util.Scanner;

public class Emy_2_6 {
    private static int minutes = 60;
    private static int hours = 24;
    private static int years = 365;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("please input minutes = ");
        double min = scanner.nextDouble();
        System.out.println("equals " + min / minutes / hours + "days, " + min / minutes / hours / years + "years");
    }
}
