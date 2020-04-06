package javaclass.E03;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.Scanner;

public class Emy_3_5 {
    private static final int week = 7;
    public static void days(int i){
        switch (i){
            case 0:
                System.out.println(" is SUN");
                break;
            case 1:
                System.out.println(" is MON");
                break;
            case 2:
                System.out.println(" is TUE");
                break;
            case 3:
                System.out.println(" is WED");
                break;
            case 4:
                System.out.println(" is THU");
                break;
            case 5:
                System.out.println(" is FRI");
                break;
            case 6:
                System.out.println(" is SAT");
                break;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("input today's day: ");
        int day = scanner.nextInt();
        days(day);
        System.out.print("input the offset's days: ");
        int offset = scanner.nextInt();
        int present = (offset+day)%week;
        System.out.print("the future day");
        days(present);

    }
}
