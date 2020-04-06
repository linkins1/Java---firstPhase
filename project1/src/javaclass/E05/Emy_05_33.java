package javaclass.E05;

import java.util.Scanner;

public class Emy_05_33 {
    public static void main(String[] args) {

        for (long a = 2; a <= 10000; a++) {
            int sum = 0;
            for (int i = 1; i < a; i++) {
                if (a % i == 0)
                    sum += i;
            }
            if (sum == a)
                System.out.printf("%d ", a);
        }
    }
}
