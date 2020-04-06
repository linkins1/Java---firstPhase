package core.java.one.enums;

import java.util.Scanner;

public class EnumTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a size: ");
        String input = scanner.next().toUpperCase();
        Size size = Enum.valueOf(Size.class,input);
        System.out.println("size="+size);
        System.out.println("abbreviation="+size.getAbb());
        if(size == Size.EXTRALARGE){
            System.out.println("so big");
        }
    }

}
enum Size{
    SMALL("S"),MEDIUM("M"),LARGE("L"),EXTRALARGE("LARGE");
    private String abb;
    private Size(String abb){//重定义构造器，对于多出来的abb参数，需要调用public接口进行访问
        this.abb = abb;
    }
    public String getAbb(){
        return abb;
    }

}