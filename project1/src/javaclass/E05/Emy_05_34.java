package javaclass.E05;

import java.util.Scanner;

public class Emy_05_34 {
    public static int judge(int a, int b){
        if(a-b==1)
            return 1;
        else if(b-a==1)
            return -1;
        else if(b-a==2)
            return 1;
        else if(a-b==2)
            return -1;
        return 0;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int countRoundsP = 0;
        int countRoundsB = 0;

        while(countRoundsP<2&&countRoundsB<2){
            System.out.println("aha, please show your move: ");
            int playerM = scanner.nextInt();
            if(playerM>=0&&playerM<=2){
                int botM = (int)(Math.random()*3);
                int result = judge(playerM,botM);
                if(result>0){
                    System.out.println("player wins!");
                    countRoundsP++;
                }

                else if(result<0){
                    System.out.println("bot wins!");
                    countRoundsB++;
                }

                else
                    System.out.println("it's a draw, match again!");
            }
            else
                System.out.println("wrong move! do it again");

        }

    }
}
