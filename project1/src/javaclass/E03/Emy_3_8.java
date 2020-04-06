package javaclass.E03;

import java.util.Arrays;

public class Emy_3_8 {
    public static void main(String[] args) {
        Integer[] i = {26,12,88,10,6,46};
        Arrays.sort(i,(a1,a2)->a1-a2);
        for (int j = 0; j < i.length; j++) {
            System.out.println(i[j]);
        }
    }
}
