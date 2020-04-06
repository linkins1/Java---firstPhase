package javaclass.E05;

import java.util.Scanner;

public class Emy_05_01 {
    private static int countPositive = 0;
    private static int countNegative = 0;
    private static int count = 0;
    private static double sum = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int temp;
        System.out.print("enter the integer: ");
        while ((temp = scanner.nextInt()) != 0) {
            count++;
            if (temp > 0)
                countPositive++;
            else if (temp < 0)
                countNegative++;
            sum += temp;
        }
        System.out.println("positive = "+countPositive);
        System.out.println("negative = "+countNegative);
        System.out.println("sum = "+sum);
        System.out.println("average = "+sum/count);
    }
}
