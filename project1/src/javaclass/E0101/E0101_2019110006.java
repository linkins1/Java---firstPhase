package javaclass.E0101;

import java.util.Scanner;

public class E0101_2019110006 {
    final static float eps = 1.0e-10F;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        float[] a = new float[6];
        System.out.println("please input parameters : ");
        for (int i = 0; i < 6; i++) {
            a[i] = sc.nextFloat();
        }
        float div = a[0] * a[3] - a[1] * a[2];
        if (Math.abs(div - 0) < eps)
            System.out.println("div can't be zero");
        else {
            float x = a[4] * a[3] - a[1] * a[5];
            float y = a[0] * a[5] - a[2] * a[4];
            System.out.println("the equations are : ");
            System.out.println(a[0] + "x" + " + " + a[1] + "y" + " = " + a[4]);
            System.out.println(a[2] + "x" + " + " + a[3] + "y" + " = " + a[5]);
            System.out.println("the results are :");
            System.out.println("x = " + x);
            System.out.println("y = " + y);
        }
    }


}
