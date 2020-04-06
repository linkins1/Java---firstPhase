package javaclass.E0101;

public class Emy_1_3 {
    public static void printA(int i){
        for (int j = 0; j < 2 * (i + 1) - 1; j++) {
            System.out.print("A");
            if ((i + 1) % 2 == 0) {
                for (int k = 0; k < 2 * i - 1; k++) {
                    System.out.print(" ");
                }
                System.out.print("A");
                break;
            }
        }
    }
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.printf(" ");
            }
            System.out.print("J");
            System.out.print("   ");
            for (int j = 0; j < 4 - i; j++) {
                System.out.printf(" ");
            }
            printA(i);
            for (int j = 0; j <5; j++) {
                System.out.printf(" ");
            }

            System.out.print("V");
            for(int j=0;j<7-2*i;j++)
                System.out.printf(" ");
            if(i!=4)
            System.out.print("V");
            for (int j = 0; j <5; j++) {
                System.out.printf(" ");
            }
            printA(i);
            System.out.println();

        }
    }
}
