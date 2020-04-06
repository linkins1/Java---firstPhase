package javaclass.E06_2019110006;

import java.util.Scanner;

public class E_06_02_2019110006 {
    public static boolean isBack(long n) {
        String s = String.valueOf(n);
        boolean flag = true;
        int length = s.length();
        int count = 0;
        if (n < 10)
            return flag;
        for (int i = 0; i < length / 2; i++) {
            if (s.charAt(i) == s.charAt(length - 1 - i))
                count++;
            if(count==length/2)
                flag=false;
        }
        return !flag;
    }

    public static boolean isPrime(long n) {
        if (n < 2) return false;

        if (n == 2) return true;

        if (n % 2 == 0) return false;

        for (int i = 3; i < n; i += 2)

            if (n % i == 0) return false;

        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = 1;
        int num = 0;
        int line = 0;
        while (count <= 100) {
            if (isBack(num) && isPrime(num)) {
                System.out.printf("%-10d", num);
                count++;
                line++;
            }
            if (line == 10) {
                line = 0;
                System.out.println();
            }
            num++;
        }
    }
}
