package core.java.one.FindNumMaxOnly;

import java.util.Arrays;
import java.util.Scanner;

public class FindNum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] s1 = s.split(" ");
        int[] a = new int[s1.length];
        for (int i = 0; i < s1.length; i++) {
            a[i] = Integer.parseInt(s1[i]);
        }


        int lableindex = 0;
        int[] lable = new int[a.length];
        int index = 0;
        int length = 1;
        while (true) {
            int count = 0;
            if (length == (a.length))
                break;
            for (int i = 0; i < length; i++) {
                if (a[length] < a[i]) {
                    count++;
                    index = length;
                }

            }
            if (count == 1) {
                lable[lableindex] = index;
                lableindex++;
            }

            length++;

        }
        for (int i = 0; i < lableindex; i++) {
            System.out.print(lable[i] + 1);
            if (i != lableindex - 1)
                System.out.print(", ");
        }

    }

}
