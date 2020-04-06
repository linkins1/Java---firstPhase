package core.java.one.threadPool;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.*;

/**
 * The type Thread pool test.
 * 本类给出了利用ExecuteService创建线程池，并在池内创建多线程任务的过程
 */
public class ThreadPoolTest {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     * @throws Exception the exception
     */
    public static void main(String[] args) throws Exception {
        try (Scanner in = new Scanner(System.in)) {
            System.out.print("Enter base directory : ");
            String directory = in.nextLine();
            System.out.print("Enter keyword : ");
            String keyword = in.nextLine();
            ExecutorService pool = Executors.newCachedThreadPool();
            MatchCounter counter = new MatchCounter(new File(directory), keyword, pool);
            Future<Integer> result = pool.submit(counter);
            try {
                System.out.println(result.get() + " matching files.");
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
            }
            pool.shutdown();
            int largestPoolSize = ((ThreadPoolExecutor) pool).getLargestPoolSize();
            System.out.println("largest pool size=" + largestPoolSize);
        }
    }
}

/**
 * The type Match counter.
 */
class MatchCounter implements Callable<Integer> {
    private File dir;
    private String key;
    private ExecutorService pool;
    private int count;

    /**
     * Instantiates a new Match counter.
     *
     * @param dir  the dir
     * @param key  the key
     * @param pool the pool
     */
    public MatchCounter(File dir, String key, ExecutorService pool) {
        this.dir = dir;
        this.key = key;
        this.pool = pool;
    }

    public Integer call() {
        count = 0;
        try {
            File[] files = dir.listFiles();
            List<Future<Integer>> results = new ArrayList();
            for (File file : files)
                if (file.isDirectory()) {
                    MatchCounter counter = new MatchCounter(file, key, pool);
                    Future<Integer> result = pool.submit(counter);
                    /**调用submit将在线程池中创建一个新的线程来处理任务，并用result来接应call返回的值*/
                    results.add(result);
                } else {
                    if (search(file)) count++;
                }
            for (Future<Integer> result : results)
                try {
                    count += result.get();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }

        } catch (InterruptedException e) {
        }
        return count;
    }

    /**
     * Search boolean.
     *
     * @param file the file
     * @return the boolean
     */
    public boolean search(File file) {
        try {
            try (Scanner scanner = new Scanner(file, "UTF-8")) {
                boolean found = false;
                while (!found && scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    if (line.contains(key))
                        found = true;
                }
                return found;
            }
        } catch (IOException e) {
            return false;
        }
    }
}