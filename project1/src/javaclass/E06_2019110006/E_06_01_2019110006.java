package javaclass.E06_2019110006;

import java.util.Scanner;

import static java.lang.Long.toUnsignedString;

public class E_06_01_2019110006 {
    /**
     * Return true if the card number is valid V
     */
    public static boolean isVa1id(long number) {
        if (number > 0) {
            int digits = getSize(number);
            if (digits >= 13 && digits <= 16)
                if (prefixMatched(number, 4) || prefixMatched(number, 5) ||
                        prefixMatched(number, 6) || prefixMatched(number, 37))
                    return true;
        }
        return false;
    }

    /**
     * Get the result from Step 2
     */
    public static int sumOfDoubleEvenPlace(long number) {
        int length = getSize(number);
        int sumEven = 0;
        int[] numEven = new int[length];
        String tempString = String.valueOf(number);
        String empty = "";
        for (int i = 0; i < length; i++) {
            char temp = tempString.charAt(i);
            numEven[i] = Integer.parseInt("" + temp);
        }
        for (int i = 0; i < length; i = i + 2) {
            int numMulti = getDigit(2 * numEven[i]);
            sumEven += numMulti;
        }
        return sumEven;
    }

    /**
     * Return this number if it is a single digit, otherwise,return the sum of the two digits
     */
    public static int getDigit(int number) {
        if (number >= 10) {
            int num1 = number / 10;
            int num2 = number % 10;
            return (num1 + num2);
        }
        return number;
    }

    /**
     * Return sum of odd-place digits in number V
     */
    public static int sumOfOddPlace(long number) {
        int length = getSize(number);
        int sumOdd = 0;
        int[] numOdd = new int[length];
        String tempString = String.valueOf(number);
        String empty = "";
        for (int i = 0; i < length; i++) {
            char temp = tempString.charAt(i);
            numOdd[i] = Integer.parseInt("" + temp);
        }
        for (int i = 1; i < length; i = i + 2) {
            sumOdd += numOdd[i];
        }
        return sumOdd;
    }

    /**
     * Return true if the digit d is a prefix for number V
     */
    public static boolean prefixMatched(long number, int d) {
        int size = getSize(number);
        long prefix;
        if (d == 5 || d == 4 || d == 6) {
            prefix = number / (long) Math.pow(10, (size - 1));
            return prefix == d;
        } else if (d == 37) {
            prefix = number / (long) Math.pow(10, (size - 2));
            return prefix == d;
        }
        return false;
    }


    /**
     * Return the number of digits in d
     */
    public static int getSize(long d) {
        int bits = String.valueOf(d).length();
        return bits;
    }

    /**
     * Return the first k number of digits from number. If the
     * number of digits in number is less than k , return number.
     */
    public static long getPrefix(long number, int k) {
        int size = getSize(number);
        long preNum;
        if (size >= k) {
            preNum = number / (long) Math.pow(10, k);
            return preNum;
        }
        return number;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a credit card as long integer: ");
        String s = scanner.nextLine();
        long number = Long.parseLong(s);
        int sum = 1;
        if (isVa1id(number)) {
            sum = sumOfDoubleEvenPlace(number) + sumOfOddPlace(number);
        }
        if (sum % 10 == 0)
            System.out.println(s + " is valid");
        else
            System.out.println(s + " is invalid");
    }
}
