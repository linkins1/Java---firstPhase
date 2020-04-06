package core.java.one.future;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * The type Future test.
 * 此类验证了Callable和Future的联合使用
 */
public class FutureTest {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter base directory: ");
            String dir = scanner.nextLine();
            System.out.print("Enter keyword: ");
            String key = scanner.nextLine();

            MatchCounter matchCounter = new MatchCounter(new File(dir), key);
            FutureTask<Integer> task = new FutureTask<>(matchCounter);
            Thread t = new Thread(task);
            t.start();
            try {
                System.out.println(task.get() + " matching files.");//此处的get返回count++
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        } catch (InterruptedException e) {

        }
    }
}

/**
 * The type Match counter.
 */
class MatchCounter implements Callable<Integer> {
    private File dir;
    private String key;

    /**
     * Instantiates a new Match counter.
     *
     * @param dir the dir
     * @param key the key
     */

    public MatchCounter(File dir, String key) {
        this.dir = dir;
        this.key = key;
    }

    public Integer call() {
        int count = 0;
        try {
            File[] files = dir.listFiles();
            List<Future<Integer>> results = new ArrayList<>();

/**
 * 在遍历过程中，如果遍历项是文件，那么就检索其中是否有关键字并对count值依条件进行修改
 * 如果是子目录，那么就根据该子目录创建一个新的子线程递归调用call方法，使其返回子目录中的count值
 * 这样在遍历results集合时，已经把给定目录中的文件都遍历完且对应修改了count值，只需要在此基础上，
 * 再加上各个目录的count值即为给定目录的总count值
 */
            for (File file : files) {
                if (file.isDirectory()) {
                    //count=0;不可行
                    MatchCounter matchCounter = new MatchCounter(file, key);
                    FutureTask<Integer> task = new FutureTask<>(matchCounter);
                    results.add(task);
                    Thread thread = new Thread(task);
                    thread.start();
                } else {
                    if (search(file))
                        count++;
                }
            }

            for (Future<Integer> result : results)
                try {
                    count += result.get();//获得count的值

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