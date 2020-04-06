package javaclass.E05;

import java.util.Scanner;

public class Emy_05_41 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int max = Integer.MIN_VALUE;
        int temp;
        int maxCount = 0;
        System.out.print("input a stream of integer: ");
        while ((temp = scanner.nextInt()) != 0) {
            if (max < temp) {
                maxCount = 0;
                max = temp;
            }
            if (max == temp)
                maxCount++;
        }
        System.out.println("the max = " + max + ", and the times of max = " + maxCount);
    }
}
