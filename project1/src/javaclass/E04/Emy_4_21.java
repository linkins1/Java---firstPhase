package javaclass.E04;

import java.util.Scanner;

public class Emy_4_21 {
    public static void main(String[] args) {
        System.out.println("please input your id: ");
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] strings = s.split("\\-");
        if (strings.length == 3) {
            if (strings[0].length() == 3 && strings[1].length() == 2 && strings[2].length() == 3)
                System.out.println(s + " is a valid social number");
            else
                System.out.println(s + " is invalid");
        } else
            System.out.println(s+"is invalid");
    }
}
