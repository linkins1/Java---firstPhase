package core.java.one.anonymousInnerClass;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.Timer;

/**
 * The type Anonymous inner class test.
 * 本类中给出的匿名内部类的示例
 * 其中start方法中的actionlistener可以采用lamda表达式来代替
 * Timer timer = new Timer(1000, events ->
 * {
 *       System.out.println("At the tone, the time is :"+new Date());
 *       if(beep){
 *         Toolkit.getDefaultToolkit().beep();
 *       }
 *
 * });
 */
public class AnonymousInnerClassTest {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        TalkingClock talkingClock = new TalkingClock();
        talkingClock.start(1000,true);
        JOptionPane.showMessageDialog(null,"QUIT?");
        System.exit(0);
    }
}

/**
 * The type Talking clock.
 */
class TalkingClock{
    /**
     * Start.
     *
     * @param interval the interval
     * @param beep     the beep
     */
    public void start(int interval, boolean beep){
        ActionListener actionListener = new ActionListener() {
            public void actionPerformed(ActionEvent event){
                System.out.println("At the tone, the time is :"+new Date());
                if(beep){
                    Toolkit.getDefaultToolkit().beep();
                }
            }
        };
        Timer timer = new Timer(interval, actionListener);
        timer.start();
    }
}
