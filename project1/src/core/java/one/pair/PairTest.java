package core.java.one.pair;


import java.time.LocalDate;

/**
 * 此类解释了如何定义泛型方法，并准确限制泛型的类型（extends 哪个类和哪些接口）
 */
public class PairTest {
    public static void main(String[] args) {
        LocalDate[] birthdays = {
                LocalDate.of(1906,12,9),
                LocalDate.of(1916,12,9),
                LocalDate.of(1926,12,9),
                LocalDate.of(1936,12,9),
                LocalDate.of(1946,12,9),
        };
        Pair<LocalDate> m = ArrayAlg.minmax(birthdays);
        System.out.println("mim ="+m.getFirst());
        System.out.println("max ="+m.getSecond());
    }
}

class ArrayAlg {
    public static <T extends Comparable> Pair<T> minmax(T[] a){
        //T类型必须实现了Comparable接口， 返回值为Pair<T>的对象,其中T与前面的T相同
        if(a==null||a.length==0){
            return null;
        }
        T min =a[0];
        T max =a[0];
        for (int i = 1; i < a.length; i++) {
            if(min.compareTo(a[i])>0) min = a[i];
            if(max.compareTo(a[i])<0) max = a[i];
        }
        return new Pair<>(min, max);
    }
}

class Pair<T> {
    private T first;
    private T second;

    public Pair() {
        first = null;
        second = null;
    }
    public Pair(T first, T second){
        this.first =first;
        this.second =second;
    }

    public T getFirst() {
        return first;
    }

    public T getSecond() {
        return second;
    }

    public void setFirst(T t) {
        first = t;
    }

    public void setSecond(T t) {
        second = t;
    }
}