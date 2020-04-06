package javaclass.E02;

import java.util.Scanner;

public class Emy_2_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("please input the radius and height: ");
        float radius = scanner.nextFloat();
        float height = scanner.nextFloat();
        float area = radius * radius * (float) Math.PI;
        float volume = area * height;
        System.out.println("the bottom area = " + area);
        System.out.println("the volume = " + volume);
    }
}
