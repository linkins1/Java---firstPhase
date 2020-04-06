package javaclass.E04_2019110006;

import java.util.Scanner;

public class E04_01_02_2019110006 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter an uppercase letter: ");
        String s = input.nextLine();
        String out = "";

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if ((int) ch >= 48 && (int) ch <= 57) {
                out += ch;
            } else if ((int) ch == 32) {
                out += "00";
            } else {
                ch = Character.toUpperCase(ch);
                int num_print = -1;
                int num_num = 0;
                if ((int) ch >= 65 && (int) ch <= 79) {
                    num_print = (int) (((int) ch - 65) / 3) + 2;
                    num_num = ((int) ch - 65) % 3 + 2;
                } else if ((int) ch >= 80 && (int) ch <= 83) {
                    num_print = 7;
                    num_num = ((int) ch - 80) + 2;
                } else if ((int) ch >= 84 && (int) ch <= 86) {
                    num_print = 8;
                    num_num = ((int) ch - 84) + 2;
                } else if ((int) ch >= 87 && (int) ch <= 90) {
                    num_num = ((int) ch - 87) + 2;
                }
                for (int j = 0; j < num_num; j++) {
                    out += num_print;
                }
            }
//            System.out.println((int) ch);
        }
        System.out.println("The corresponding number is " + out);
    }
}
