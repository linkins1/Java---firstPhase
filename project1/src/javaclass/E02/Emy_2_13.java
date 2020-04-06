package javaclass.E02;

import java.util.Scanner;

public class Emy_2_13 {
    private static float yearProfit = 0.05f;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("please input your base money = $");
        float base = scanner.nextFloat();
        float[] months = new float[6];
        float finalbase = 0f;
        for (int i = 0; i < 6; i++) {
            months[i]=(base+finalbase)*(1+yearProfit/12);
            finalbase=months[i];
        }
        for (int i = 0; i < 6; i++) {
            System.out.println("the "+(i+1)+"month's profits = "+months[i]);
        }
    }
}
