package core.java.one.genericTest;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 本类调查的通配符的使用方案
 * 首先，通配符是为了同时满足多个泛型类的需要而存在的，而泛型类是为了满足不同的类型要求而存在的
 * extends 和 super 都以向上转型安全作为标准来决定使用
 *
 * 下界代表下界以下的操作是确定的
 * 上界代表上界以上的操作是确定的
 */
class father{

}
class son extends father{

}
class grandSon extends son{

}
class grandGrandSon extends grandSon{

}
public class testfather{
    public static void main(String[] args) {
        List<grandSon> listGrandson = new ArrayList<>();
        grandSon grandSon1 = new grandSon();
        grandSon grandSon2 = new grandSon();
        grandSon grandSon3 = new grandSon();
        grandSon grandSon4 = new grandSon();

        listGrandson.add(grandSon1);
        listGrandson.add(grandSon2);
        listGrandson.add(grandSon3);
        listGrandson.add(grandSon4);
        //可以通过先定义一个添加好元素的grandson集合类对象listGrandson

        List<? extends son> list1 = listGrandson;//?限制了最终获得的类型要是son的子类
        /**************************编译器会遇到如下问题***************************/
        //? extends son 表明在读取时，至少可以确定？类型可以向上转型为son
        //但是在添加元素时，son的子类可以有很多种类型（例如grandson和grandGrandson）
        //所以很难确定要添加的元素类型
        //此处可以将listGrandson集合赋值给list1

        /************************************************************************/

        List<? super son> list2 = new ArrayList<father>();//限制了最终获得的的类型是son的父类
        /**************************编译器会遇到如下问题***************************/
        //? super son 表明在添加元素时，如果是son和son的子类，那么都可以向上转型为son
        //但是在读取元素时，由于？为son的父类，向上转型时不确定，可以有很多取值（例如father Object等）
        //所以很难确定读取出来的元素类型
        grandSon grandSon = (grandSon) list1.get(0);
        father father = list1.get(1);
        //直接读取grandSon的操作是安全的
        list2.add(grandSon);
        //add方法的参数是泛型，此时为? super son，所以传入son的子类对象是安全的
        //直接添加grandSon的操作是安全的
        list2.forEach(System.out::println);
        //在输出list2时可以采用foreach

        /**
        综上所述，? super xxx,适用于只写入元素
                 ? extends xxx,适用于只读出元素
         */
    }
}