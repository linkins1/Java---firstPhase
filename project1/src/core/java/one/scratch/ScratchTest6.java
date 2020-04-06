package core.java.one.scratch;

import java.time.LocalDate;
import java.util.Scanner;

public class ScratchTest6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int day = scanner.nextInt();
        int mon = scanner.nextInt();
        int year = scanner.nextInt();
        LocalDate localDate = LocalDate.of(year,mon,day);
    }
}
