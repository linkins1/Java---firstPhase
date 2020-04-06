package javaclass.E04_2019110006;

import java.util.Scanner;

public class E05_01_2019110006 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lineNumber = scanner.nextInt();
        int position = 10 * lineNumber;//(int)Math.pow(2,lineNumber);
        for (int i = 0; i < lineNumber; i++) {
            long out = (long) Math.pow(2, i-1);
            for (int j = 0; j < 2 * (i + 1) - 1; j++) {
                if (j < i + 1) {
                    long out1 = (long) Math.pow(2, j);
                    if (j == 0)
                        System.out.printf("%" + position + "d", out1);
                    else {
                        System.out.printf("%10d", out1);
                    }
                }
                else {
                    System.out.printf("%10d", out);
                    out = out / 2;
                }
            }
            System.out.println();
            position = position - 10;
        }
    }
}
