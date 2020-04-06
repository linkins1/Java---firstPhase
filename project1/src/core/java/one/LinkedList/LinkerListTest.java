package core.java.one.LinkedList;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * The type Linker list test.
 * 此类验证了链表的迭代方式以及ListIterator中比Iterator中多的add方法的特性
 */
public class LinkerListTest {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        List<String> a = new LinkedList<>();
        a.add("AMY");
        a.add("CARL");
        a.add("ERIC");
        List<String> b = new LinkedList<>();
        b.add("bob");
        b.add("doug");
        b.add("frances");
        b.add("gloria");
        ListIterator<String> aIter = a.listIterator();
        //
        Iterator<String> bIter = b.iterator();
        int count = 0;
        while (bIter.hasNext()) {
            System.out.println("the " + count + " time loop");
            System.out.println(a);
            System.out.println(b);
            if (aIter.hasNext())
                aIter.next();
            aIter.add(bIter.next());
            //add后aIter中的nextIndex会加1，使得aIter迭代器仍然指向原来a中的第二个元素(现在的第三个)
            //1.aIter.hasNext()：aIter.nextIndex=0
            //2.aIter.next()：aIter.nextIndex=1
            //3.aIter.add(bIter.next())：aIter.nextIndex=2
            //在最后一次迭代中，if (aIter.hasNext())不成立，直接在队尾加上b中的最后一个元素
            count++;
        }
        System.out.println(a);
        bIter = b.iterator();
        //重新更新迭代器，由于每个迭代器只能遍历一遍
        while (bIter.hasNext()) {
            bIter.next();
            if (bIter.hasNext()) {
                bIter.next();
                bIter.remove();
            }
        }
        System.out.println(b);
        a.removeAll(b);
        System.out.println(a);

    }
}
