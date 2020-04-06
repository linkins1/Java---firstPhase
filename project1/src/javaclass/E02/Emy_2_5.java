package javaclass.E02;

import java.util.Scanner;

public class Emy_2_5 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("please input the fee & percent = ");
        double fee = scanner.nextDouble();
        double percent = scanner.nextDouble();
        double gratuity = fee * percent;
        System.out.println("the gratuity = $" + gratuity);
        System.out.println("the total payment = $" + (fee+gratuity));
    }

}
