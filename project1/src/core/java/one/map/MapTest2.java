package core.java.one.map;

import java.util.HashMap;
import java.util.Iterator;

/**
 * The type Map test 2.
 * 本类验证了merge函数的用法
 */
public class MapTest2 {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        HashMap<Integer,String> hashMap = new HashMap<>();
        hashMap.put(1,"one");
        hashMap.put(2,"for");
        hashMap.put(3,"one");
        HashMap<Integer,String> hashMap1 = new HashMap<>();
        hashMap1.put(1,"two");
        hashMap1.put(2,"for");
        hashMap1.put(3,"two");
        System.out.println("Before merging");
        System.out.println(hashMap);
        System.out.println(hashMap1);
        System.out.println("Starting to merge");
        hashMap.forEach((k,v)->hashMap1.merge(k,v,(v1,v2)->v1.equalsIgnoreCase(v2)?v1:v1+","+v2));
        //foreach来遍历hashMap中的元素，提取出k和对应的v，hashMap1根据k找出对应的v1，并于v2（v）作比较
        System.out.println(hashMap1);
        hashMap1.forEach((k,v)-> System.out.println("number ="+k+"value="+v));
        System.out.println();
        hashMap.merge(1,"vulfpeck",(v1,v2)->v1.length()>v2.length()?v1:v1+","+v2);
        System.out.println(hashMap);
        System.out.println(hashMap);
        System.out.println(hashMap);
        Iterator iter = hashMap.entrySet().iterator();
        System.out.println("iter");
        while(iter.hasNext())
            System.out.println(iter.next());
        while(iter.hasNext())
            System.out.println(iter.next());
        //System.out.println(hashMap);
    }
}
