package javaclass.E05;

public class Emy_05_15 {
    public static void main(String[] args) {
        char ascii = '!';
        int count = 0;
        while (ascii <= '~') {
            System.out.printf("%2s", ascii);
            ascii++;
            count++;
            if (count == 10) {
                System.out.println();
                count = 0;
            }

        }
    }
}
