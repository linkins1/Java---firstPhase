package core.java.one.scratch;

import java.io.ObjectInputStream;

public class test {
    public static void swap(String a, String b){
        String t = a;
        a.trim();
    }
    public static void main(String[] args) {
        String a = new String();
        String b = new String();
        a="1 2 3";
        b="456";
        swap(a,b);
        System.out.println(a+b);

        Object[] oArray = new Object[3];
        oArray[0]= new Object();
        oArray[1]= new Object();
        oArray[2]= new Object();

        Object oo = oArray;
        System.out.println();

    }
}
