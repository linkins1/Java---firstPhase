package javaclass.E03_2019110006;

import java.time.LocalDate;

import java.util.Scanner;

public class E03_01_2019110006 {
    private static int yearDivide = 100;

    enum WEEK {MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY}

    ;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("please input day, month, year: ");
        int qDay, mMonth, jCent, kCent;
        qDay = scanner.nextInt();
        mMonth = scanner.nextInt();
        jCent = scanner.nextInt();
        LocalDate.of(jCent,mMonth,qDay);
        //LocalDate.of可以检查日期的正确性，如果输入日期有误，会throw DateTimeException
        //DateTimeException extends RuntimeException，属于非受查异常
        System.out.println();
        System.out.print("the " + qDay + "'s day in " + jCent + "-" + mMonth + " is ");
        if (mMonth == 1 || mMonth == 2){
            mMonth = mMonth + 12;
            jCent = jCent -1;
        }

        kCent = jCent % yearDivide;
        jCent = jCent / yearDivide;
        int dayNum;
        dayNum = (qDay + (26 * (mMonth + 1)) / 10 + kCent + kCent / 4 + jCent / 4 + 5 * jCent) % 7;
        switch (dayNum) {
            case 0:
                System.out.println(WEEK.SATURDAY);
                break;
            case 1:
                System.out.println(WEEK.SUNDAY);
                break;
            case 2:
                System.out.println(WEEK.MONDAY);
                break;
            case 3:
                System.out.println(WEEK.TUESDAY);
                break;
            case 4:
                System.out.println(WEEK.WEDNESDAY);
                break;
            case 5:
                System.out.println(WEEK.THURSDAY);
                break;
            case 6:
                System.out.println(WEEK.FRIDAY);
                break;
            default:
                System.out.println("wrong output");
        }
    }
}
