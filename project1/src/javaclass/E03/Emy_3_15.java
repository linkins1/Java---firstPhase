package javaclass.E03;

import java.util.Scanner;

public class Emy_3_15 {
    public static void main(String[] args) {
        int lotter = (int) ((Math.random() * 9 + 1) * 100);
        System.out.println("lotter is :" + lotter);
        Scanner scanner = new Scanner(System.in);
        System.out.print("now guess: ");
        int guess = scanner.nextInt();
        int[] guessArr = new int[3];
        for (int i = 0; i < 3; i++) {
            guessArr[2 - i] = guess % 10;
            guess = guess / 10;
        }
        int[] lotterArr = new int[3];
        for (int i = 0; i < 3; i++) {
            lotterArr[2 - i] = lotter % 10;
            lotter = lotter / 10;
        }
        if (guessArr[0] == lotterArr[0] && guessArr[1] == lotterArr[1] && guessArr[2] == lotterArr[2])
            System.out.println("u win 30000$");
        else if ((guessArr[0] == lotterArr[1] && guessArr[1] == lotterArr[2] && guessArr[2] == lotterArr[0])
                || (guessArr[0] == lotterArr[1] && guessArr[1] == lotterArr[0] && guessArr[2] == lotterArr[2])
                || (guessArr[0] == lotterArr[2] && guessArr[1] == lotterArr[0] && guessArr[2] == lotterArr[1])
                || (guessArr[0] == lotterArr[0] && guessArr[1] == lotterArr[2] && guessArr[2] == lotterArr[1])
                || (guessArr[0] == lotterArr[2] && guessArr[1] == lotterArr[1] && guessArr[2] == lotterArr[0])) {
            System.out.println("u win 20000$");
        } else if (guessArr[0] == lotterArr[0] || guessArr[0] == lotterArr[1] || guessArr[0] == lotterArr[2] ||
                guessArr[1] == lotterArr[0] || guessArr[1] == lotterArr[1] || guessArr[1] == lotterArr[2] ||
                guessArr[2] == lotterArr[0] || guessArr[2] == lotterArr[1] || guessArr[2] == lotterArr[2])
            System.out.println("u win 10000$");
        else
            System.out.println("sorry, u win nothing");

    }
}
