package core.java.one.lamda;

import java.util.Arrays;
import java.util.Date;
import javax.swing.*;

public class LamdaTest {
    public static void main(String[] args) {
        String[] planets = {"Mercu","Venus","Earth","Mars","Jupiter","Saturn","Uranus","Neptune"};
        System.out.println(Arrays.toString(planets));
        Arrays.sort(planets);
        System.out.println("sorted in dictionary order: " + Arrays.toString(planets));
        Arrays.sort(planets,(first,second) -> first.length()-second.length());
        //lamda表达式转换为接口，此处为(first,second) -> first.length()-second.length()转换为
        //Comparator接口，并用方法体替换掉其中的compare方法
        //在具体的执行过程中为，Arrays.sort调用Comparator中的compare方法，这时会执行lamda表达式的体
        System.out.println("sorted in length: " + Arrays.toString(planets));
        Timer t = new Timer(1000, event ->
                System.out.println("the time is :" + new Date()));
        t.start();
        Timer timer = new Timer(1000, events -> System.out.println(events));
        timer.start();
        JOptionPane.showMessageDialog(null, "Quit?");
        System.exit(0);
    }
}
