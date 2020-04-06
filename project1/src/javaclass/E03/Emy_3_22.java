package javaclass.E03;

import java.util.Scanner;

public class Emy_3_22 {
    private static int radius = 10;
    private static int length = 6;
    private static int width = 4;
    private static int side1 = 100;
    private static int side2 = 200;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("please input a point's coordinate(x,y): ");
        double x = scanner.nextDouble();
        double y = scanner.nextDouble();
        if (Math.pow(x, 2) + Math.pow(y, 2) <= Math.pow(radius, 2))
            System.out.println("the input point is in the circle!");
        else
            System.out.println("the input point is outside the circle!");
        if ((Math.abs(x) <= length / 2) && (Math.abs(y) <= width / 2))
            System.out.println("and, the point is in the rectangle!");
        else
            System.out.println("and, the point is outside the rectangle!");
        double yMax = x * (-0.5) + 100;
        if (x >= 0 && x <= 200 && y <= yMax)
            System.out.println("and, the point is in the triad!");
        else
            System.out.println("and, the point is outside the triad!");
    }
}
