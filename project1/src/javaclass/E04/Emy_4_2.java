package javaclass.E04;

import java.util.Scanner;

public class Emy_4_2 {
    private static double radius = 6371.01;

    public static void main(String[] args) {
        float x1, x2, y1, y2;
        Scanner scanner = new Scanner(System.in);
        System.out.print("please input the first coordinate: ");
        x1 = scanner.nextFloat();
        y1 = scanner.nextFloat();
        System.out.print("please input the second coordinate: ");
        x2 = scanner.nextFloat();
        y2 = scanner.nextFloat();
        double d = radius * Math.acos((Math.sin(Math.toRadians(x1))) * (Math.sin(Math.toRadians(x2))) + (Math.cos(Math.toRadians(x1))) * (Math.cos(Math.toRadians(x2))) * (Math.cos(Math.toRadians(y1) - Math.toRadians(y2))));
        System.out.println("the distance between two points is: " + d + "km");
    }
}

