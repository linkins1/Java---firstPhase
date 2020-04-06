package core.java.one.objectAnalyzer;

import java.util.ArrayList;


import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class ObjectAnalyzerTest {
    public static void main(String[] args) {
        ArrayList<Integer> squares = new ArrayList<>();
        for (int i = 1; i <= 5; i++)
            squares.add(i * i);

        String string = new ObjectAnalyzer().toString(squares);
        System.out.println(string);
        System.out.println(squares.getClass());
    }
}
class ObjectAnalyzer {
    private ArrayList<Object> visited = new ArrayList<>();

    public String toString(Object object) {
        if (object == null)
            return "null";
        if(visited.contains(object))
            return"...";
        visited.add(object);
        Class cl = object.getClass();
        if (cl == String.class)//如果是字符串则返回字符串
            return (String) object;
        if (cl.isArray()) {//判断是否为一个数组
            String r = cl.getComponentType() + "[]{";//获取数组中的元素类型
            for (int i = 0; i < Array.getLength(object); i++) {
                if (i > 0)
                    r += ",";
                Object val = Array.get(object, i);//获取数组中给定index处的元素
                if (cl.getComponentType().isPrimitive())//看数组元素类型是否为基本类型
                    r += toString(val);
            }
            return r + "}";
        }

        String r = cl.getName();

        do {
            r += "[";
            Field[] fields = cl.getDeclaredFields();
            AccessibleObject.setAccessible(fields, true);//在java9之后，引入了module的概念导致不能这样获取private信息
            for (Field f : fields) {
                if (!Modifier.isStatic(f.getModifiers())) {
                    if (!r.endsWith("["))
                        r += ",";
                    r += f.getName() + "=";
                    try {
                        Class t = f.getType();
                        Object val = f.get(object);
                        if (t.isPrimitive())
                            r += val;
                        else
                            r += toString(val);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            r += "]";
            cl = cl.getSuperclass();
        }
        while (cl != null);
        return r;


    }

}


