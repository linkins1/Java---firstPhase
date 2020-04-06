package core.java.one.comparetest;
import java.util.Arrays;
import java.util.Comparator;
class LengthComparator implements Comparator<String> {
    public int compare(String first, String second) {
        return first.length()-second.length();
    }
}
public class LenComTest {

    public static void main(String[] args) {

        String[] friends = {"peter","jacccck","sue"};
        System.out.println("before sort: " + Arrays.toString(friends));
        Arrays.sort(friends,new LengthComparator());
        //由于在使用Arrays.sort时如果要指定比较器，需要调用Comparator接口中的compare方法
        //因此需要实现compare方法
        //Comparator<String> = new LengthComparator();
        System.out.println("after sort: " + Arrays.toString(friends));
    }
}
