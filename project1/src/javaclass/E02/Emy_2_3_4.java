package javaclass.E02;

import java.util.Scanner;

public class Emy_2_3_4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("please input the inches = ");
        float inch = scanner.nextFloat();
        float meter = inch * 0.305f;
        System.out.println("the equal meter = " + meter);

        System.out.print("please input the pound = ");
        float pound = scanner.nextFloat();
        float kilogram = pound * 0.454f;
        System.out.println("the equal k = " + kilogram);


    }
}
