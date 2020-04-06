package javaclass.E04_2019110006;

import java.util.*;
import java.util.concurrent.ExecutionException;

public class E04_01_2019110006 {
    public static void main(String[] args) {
        Character[][] strings = new Character[10][4];
        char a = 'a' - 1;
        for (int i = 2; i < strings.length; i++) {
            if (i == 7 || i == 9) {
                for (int j = 0; j < strings[i].length; j++) {
                    strings[i][j] = (++a);
                }
                continue;
            }
            for (int j = 0; j < strings[i].length - 1; j++) {
                strings[i][j] = (++a);
            }
        }
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please input the message: ");
        String s = scanner.nextLine();
        for (int i = 0; i < s.length(); i++) {
            int indexLine = -1;
            int indexChar = 0;
            if (s.charAt(i) == 32)
                System.out.print("00");
            if (Character.isDigit(s.charAt(i)))
                System.out.print(String.valueOf(s.charAt(i)).toString());
            for (int k = 2; (k < 9) && (indexLine == -1); k++) {
                Character[] chars = strings[k];
                try {
                    indexChar = Arrays.binarySearch(chars, s.charAt(i));
                    indexLine = k;
                } catch (Exception e) {

                }
            }
            if (indexChar != -1)
                for (int k = 0; k < indexChar + 2; k++) {
                    System.out.print(indexLine);
                }
        }
    }
}




