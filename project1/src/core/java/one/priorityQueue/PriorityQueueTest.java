package core.java.one.priorityQueue;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.PriorityQueue;

/**
 * The type Priority queue test.
 * 验证了优先级队列每次在删除元素时会先删除最小的元素，这得益于heap的性质
 */
public class PriorityQueueTest {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        PriorityQueue<LocalDate> pq = new PriorityQueue<>();
        pq.add(LocalDate.of(1996,12,9));
        pq.add(LocalDate.of(1815,1,28));
        pq.add(LocalDate.of(1946,10,15));
        LocalDate localDate = LocalDate.of(1988,4,1);
        System.out.println(pq.add(localDate));
        System.out.println(pq.add(LocalDate.of(1988,4,1)));
        System.out.println("Iterating over Elements");
        for(LocalDate date : pq){
            System.out.println(date);
        }
        System.out.println("Removing Elements");
        System.out.println(pq.remove());
        System.out.println(pq.remove(localDate));
        while (!pq.isEmpty()){
            System.out.println("removing!");
            System.out.println(pq.remove());
        }

    }
}
