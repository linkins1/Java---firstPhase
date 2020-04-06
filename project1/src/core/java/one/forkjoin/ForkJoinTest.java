package core.java.one.forkjoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.function.DoublePredicate;

/**
 * The type Fork join test.
 * 本类验证了ForkJoin框架，compute方法会被递归调用
 * compute中需要给出拆分原对象的条件和拆分的方法
 */
public class ForkJoinTest {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        final int SIZE=10000000;
        double[] numbers = new double[SIZE];
        for (int i = 0; i < SIZE; i++) {
            numbers[i]=Math.random();
        }
        Counter counter = new Counter(numbers, 0, numbers.length,x->x>0.5);
        ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(counter);
        System.out.println(counter.join());
    }
}

/**
 * The type Counter.
 */
class Counter extends RecursiveTask<Integer>{
    /**
     * The constant THRESHOLD.
     */
    public static final int THRESHOLD = 1000;
    private double[] values;
    private int from;
    private int to;
    private DoublePredicate filter;

    /**
     * Instantiates a new Counter.
     *
     * @param values the values
     * @param from   the from
     * @param to     the to
     * @param filter the filter
     */
    public Counter(double[] values, int from, int to, DoublePredicate filter){
        this.filter=filter;
        this.from=from;
        this.to=to;
        this.values=values;
    }
    protected Integer compute(){
        if(to-from<THRESHOLD){
            int count=0;
            for (int i = from; i < to; i++) {
                if(filter.test(values[i]))
                    count++;
            }
            return count;
        }
        else{
            int mid = (from+to)/2;
            Counter first = new Counter(values, from, mid, filter);
            Counter second = new Counter(values, mid, to, filter);
            invokeAll(first,second);
            return first.join()+second.join();
        }
    }
}
