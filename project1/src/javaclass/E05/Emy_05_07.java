package javaclass.E05;

public class Emy_05_07 {
    private static double feeBase = 10000;
    private final static double percent = 0.05;

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            feeBase = feeBase * (1 + percent);
        }
        System.out.println("after 10 years' the fee = " + feeBase);
        double sum = 0;
        for (int i = 0; i < 4; i++) {
            sum += feeBase * (1 + percent);
        }
        System.out.println("after 10 years and 4 years sum = "+sum);
    }
}
