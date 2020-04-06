package javaclass.E02;

import java.util.Scanner;

public class Emy_2_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("摄氏度 = ");
        double temp1 = scanner.nextDouble();
        double temp2 = temp1*(9.0/5)+32;
        System.out.println("华氏度 = "+temp2);
    }
}
