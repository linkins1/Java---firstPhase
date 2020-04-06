package core.java.one.treeSet;

import java.util.Comparator;
import java.util.NavigableSet;
import java.util.SortedSet;
import java.util.TreeSet;

public class TreeSetTest {
    public static void main(String[] args) {
        SortedSet<Item> parts = new TreeSet<>();
        parts.add(new Item("tinker", 1001));
        parts.add(new Item("tailor", 1002));
        parts.add(new Item("tailor", 1002));
        parts.add(new Item("soldier", 1003));
        parts.add(new Item("soldier", 1005));
        parts.add(new Item("soldier1", 1005));
        System.out.println(parts);
        NavigableSet<Item> sortByDescription = new TreeSet<>(Comparator.comparing(Item::getDescription));
        //在Treeset中指定比较器
        sortByDescription.addAll(parts);
        System.out.println(sortByDescription);
    }
}
