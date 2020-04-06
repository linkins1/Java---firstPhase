package core.java.one.linkedHashset;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.*;

/**
 * The type Linked hash set test.
 * LinkedHashMap(双向链表)按照插入顺序访问元素，避免HashMap中随机的访问顺序,且LinkedHashMap中
 * 每调用一次get就会将被调用元素放至队尾(需要把accessOrder设定为true，默认为false)
 */
public class LinkedHashSetMapTest {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        Set<String> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add("E");
        linkedHashSet.add("D");
        linkedHashSet.add("C");
        linkedHashSet.add("B");
        linkedHashSet.add("A");
        Iterator<String> iterator = linkedHashSet.iterator();
        System.out.println("Iterating LinkedHashSet");
        while (iterator.hasNext())
            System.out.println(iterator.next());

        Map<Integer, String> HashMap = new HashMap<>();
        Map<Integer, String> LinkedHashMap = new LinkedHashMap<>(6,0.75f,true);
        //initialCapacity为初始桶的数量，loadFactor为阈值百分比，
        //当映射中元素的数量大于前两者相乘，就会将容量翻倍(乘2)，进行rehashing，这样会带来较大的开销
        HashMap.put(3, "C");
        HashMap.put(1, "A");
        HashMap.put(2, "B");
        System.out.println("HashMap's iter: ");
        HashMap.forEach((k, v) -> System.out.println(k + v));

        System.out.println("LinkedHashMap, Before get()");
        LinkedHashMap.put(3, "C");
        LinkedHashMap.put(1, "A");
        LinkedHashMap.put(2, "B");
        Iterator iterator1 = LinkedHashMap.entrySet().iterator();
        while (iterator1.hasNext())
            System.out.println(iterator1.next());
        //LinkedHashMap.forEach((k,v)-> System.out.println(k+v));

        System.out.println("After get()");
        LinkedHashMap.get(3);
        iterator1 = LinkedHashMap.entrySet().iterator();
        while (iterator1.hasNext()) {
            Map.Entry entry = (Map.Entry) iterator1.next();
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
        //LinkedHashMap.forEach((k,v)-> System.out.println(k+v));

    }

}
