package core.java.one.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Scanner;

/**
 * The type Reflection test.
 * 此文件分析了如何利用反射机制来分析类的能力（域以及方法）
 * 1.对象.getModifiers()获取该类的修饰符（public static final等）
 * 2.cl.getDeclaredConstructors()//cl.getDeclaredMethods//cl.getDeclaredFields()
 * 3.
 * -->3.1构造器
 * 3.1.1 getModifiers()
 * 3.1.2 getParameterTypes()
 * -->3.2方法
 *  3.2.1 getModifiers()
 *  3.2.2 getParameterTypes()
 *  3.2.3 getReturnType()
 * -->3.3域
 * 3.3.1 getType()获取数据类型 int String等
 * 3.3.2 getName()获取域(变量)的名字
 */
public class ReflectionTest {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        String name;
        if (args.length > 0)
            //从java xxx 命令行中读入
            name = args[0];
        else {
            Scanner in = new Scanner(System.in);
           // 从console读入
            System.out.println("please input the class name(e.g. jav.util.Date): ");
            name = in.next();
        }
        try {
            Class cl = Class.forName(name);
            //创建一个name对象所属类型的对象cl
            Class supercl = cl.getSuperclass();
            String modifiers = Modifier.toString(cl.getModifiers());//获得类的修饰符以字符串形式返回
            if (modifiers.length() > 0)
                System.out.println(modifiers + " ");
            System.out.println("class: " + name);
            if (supercl != null && supercl != Object.class)//父类不为空且不是Object类
                System.out.println("extends" + supercl.getName());
            System.out.print("\n{\n");
            printConstructors(cl);
            //打印构造器
            System.out.println();
            printMethods(cl);
            //打印方法表
            System.out.println();
            printFields(cl);
            //打印域
            System.out.println("}");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.exit(0);
    }

    /**
     * Print constructors.
     *
     * @param cl the cl
     */
    public static void printConstructors(Class cl) {
        Constructor[] constructors = cl.getDeclaredConstructors();//获取声明的构造器

        for (Constructor c : constructors) {
            String name = c.getName();
            System.out.print(" ");
            String modifiers = Modifier.toString(c.getModifiers());//获得构造器的修饰符
            if (modifiers.length() > 0)
                System.out.print(modifiers + " ");
            System.out.print(name + " (");

            Class[] paramTypes = c.getParameterTypes();//获取构造其中的参数类型
            for (int i = 0; i < paramTypes.length; i++) {
                if (i > 0) System.out.print(", ");
                System.out.print(paramTypes[i].getName());
            }
            System.out.println(");");
        }
    }

    /**
     * Print methods.
     *
     * @param cl the cl
     */
    public static void printMethods(Class cl) {
        Method[] methods = cl.getDeclaredMethods();//获取声明的方法
        for (Method m : methods) {
            Class retType = m.getReturnType();//获取返回类型
            String name = m.getName();//获取方法名

            System.out.print(" ");
            String modifiers = Modifier.toString(m.getModifiers());//获取方法的修饰符 m.getModifiers()得到的是该修饰符的整型值
            if (modifiers.length() > 0) System.out.print(modifiers + " ");
            System.out.print(retType.getName() + " " + name + "(");
            Class[] paramTypes = m.getParameterTypes();//获取方法中的参数类型
            for (int i = 0; i < paramTypes.length; i++) {
                if (i > 0) System.out.print(", ");
                System.out.print(paramTypes[i].getName());
            }
            System.out.println(");");
        }
    }

    /**
     * Print fields.
     *
     * @param cl the cl
     */
    public static void printFields(Class cl) {
        Field[] fields = cl.getDeclaredFields();//获取声明的域private static final

        for (Field f : fields) {
            Class Type = f.getType();//获取域的类型 int等
            String name = f.getName();//获取变量名
            System.out.print(" ");
            String modifiers = Modifier.toString(f.getModifiers());//获取变量修饰符
            if (modifiers.length() > 0) System.out.print(modifiers + "          ");
            System.out.println(Type.getName() + " " + name + ";");
        }
    }


}
