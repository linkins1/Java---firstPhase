package javaclass.E0201;

import java.util.Scanner;

public class E0201_2019110006 {
    private static int rightPosition = 0;
    private static int rightNumber = 0;
    private static int count = 0;
    private static String compare = "";

    public static void random() {
        while (true) {
            int round = 0;
            compare = Integer.toString((int) ((Math.random() * 9 + 1) * 1000));
            for (int i = 0; i < 3; i++) {
                for (int j = i + 1; j < 4; j++) {
                    if (compare.charAt(i) == compare.charAt(j))
                        round++;
                }
            }
            if (round == 0)
                break;
        }

    }

    public static boolean check(String s) {
        if (s.length() != 4) {
            System.out.println("Wrong length, please input four digit integer");
            return false;
        }

        for (int i = 0; i < 4; i++) {
            if (!Character.isDigit(s.charAt(i))) {
                System.out.println("Wrong format, please input four digit integer");
                return false;
            }
        }
        return true;
    }

    public static void reflection(String compare, String s) {
        String s1 = compare;
        System.out.println(s1);
        for (int i = 0; i < s1.length(); i++) {
            for (int j = 0; j < s1.length(); j++) {
                if (s1.charAt(i) == s.charAt(j)) {
                    if (i == j)
                        rightPosition++;
                    else
                        rightNumber++;
                }
            }
        }
        count++;
        System.out.print(count + ":");
        System.out.println(rightPosition + "A" + rightNumber + "B");


    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        random();
        while (true) {
            rightPosition = 0;
            rightNumber = 0;
            String s = scanner.nextLine();
            if (check(s)) {
                System.out.println("请输入你猜的数字: " + s);
                reflection(compare, s);
            }
            if (rightPosition == 4) {
                System.out.println("你很厉害啊！");
                break;
            }
        }


    }
}
