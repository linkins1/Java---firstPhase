package core.java.one.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.Random;

public class ProxyTest {
    public static void main(String[] args) {
        Object[] elements = new Object[1000];
        for (int i = 0; i < elements.length; i++) {
            //生成1-1000的代理对象数组
            Integer value = i + 1;
            InvocationHandler handler = new TraceHandler(value);
            Object proxy = Proxy.newProxyInstance(null, new Class[]{Comparable.class}, handler);
            //创建代理类对象，需要给出类加载器、要代理的接口（new Class[]{Comparable.class}）、调用处理器
            elements[i] = proxy;
        }
        Integer key = new Random().nextInt(elements.length) + 1;
        int result = Arrays.binarySearch(elements, key);
        //elements是代理对象数组，便于理解可等价为，一个1-1000的Integer数组且绑定了代理功能
        if (result >= 0)
            System.out.println("the result is:" + elements[result]);
    }
}

class TraceHandler implements InvocationHandler {
    //定义一个新类来完成调用处理器并准备接应传入的对象
    private Object target;

    public TraceHandler(Object t) {
        target = t;
    }

    public Object invoke(Object proxy, Method m, Object[] args) throws Throwable {
        //invoke给出处理调用的方式（此例下是binarySearch调用compareTo再触发invoke）
        //被代理的方法是Arrays.binarySearch（其实现是由compareTo完成的，所以getname时返回的是compareTo）
        System.out.print(target);
        System.out.print("." + m.getName() + "(");
        if (args != null) {
            for (int i = 0; i < args.length; i++) {
                //由于key只有一个所以只输出一个key值
                System.out.print(args[i]);
                if (i < args.length - 1)
                    System.out.print(", ，，，，，，，，，，，，，，，");
            }
        }
        System.out.println(")");
        return m.invoke(target, args);
        // java.lang.reflect.Method.invoke(Object obj，Object... args)
        //obj为触发代理方法（Arrays.binarySearch->compareTo）的对象（此例中是Integer 类的value，
        // 尽管为Integer的对象，其实现了Comparable<Integer>,但是，在运行中，所有泛型都被取消，代理会将其构造为原Comparable类的对象）
        // args为代理方法所需的参数（此例子中args为key）
    }

}
