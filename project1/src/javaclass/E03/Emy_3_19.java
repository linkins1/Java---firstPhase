package javaclass.E03;

import java.util.Scanner;

public class Emy_3_19 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("please input triad's side length: ");
        double[] a = new double[3];
        for (int i = 0; i < 3; i++) {
            a[i]=scanner.nextDouble();
        }
        if((a[0]+a[1])>a[2]&&(a[2]+a[1])>a[0]&&(a[0]+a[2])>a[1]) {
            System.out.println("this is a right triad, the perimeter is: "+(a[0]+a[1]+a[2]));
        }
        else
            System.out.println("this is not a triad");
    }
}
