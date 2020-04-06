package javaclass.E05;

import java.util.Scanner;

public class Emy_05_21 {
    private static double percent = 0.05;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("enter the base and years: ");
        double amount = scanner.nextDouble();
        double years = scanner.nextDouble();
        System.out.printf("%-30s%-30s%-30s", "Interest Rate", "Monthly Payment", "Total Payment");
        System.out.println();
        for (double i = percent; i <= 0.6; i = i + 0.25) {
            double sum = amount;
            for (int j = 0; j < years; j++) {
                sum = sum * (1 + percent);
            }
            double monPay = sum / (5 * 12);
            System.out.printf("%-30f%-30f%-30f", i, monPay, sum);
            System.out.println();
        }
    }
}
