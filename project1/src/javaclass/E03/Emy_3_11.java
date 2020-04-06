package javaclass.E03;

import java.time.LocalDate;
import java.util.Scanner;

public class Emy_3_11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("input year & month: ");
        int year = scanner.nextInt();
        int month = scanner.nextInt();
        LocalDate localDate = LocalDate.of(year, month, 1);
        int days = localDate.lengthOfMonth();
        System.out.println(year+" year's "+month + " month has " + days + "days");
    }
}
