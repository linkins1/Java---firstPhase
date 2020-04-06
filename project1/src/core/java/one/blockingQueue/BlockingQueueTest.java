package core.java.one.blockingQueue;

import java.io.File;
import java.io.IOException;
import java.io.PipedReader;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * The type Blocking queue test.
 */
public class BlockingQueueTest {
    private static final int FILE_QUEUE_SIZE = 10;
    private static final int SEARCH_THREADS = 100;
    private static final File DUMMY = new File("");
    private static BlockingQueue<File> queue = new ArrayBlockingQueue<>(FILE_QUEUE_SIZE);

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter a base dir: ");
            String dir = scanner.nextLine();
            System.out.println("Enter keyword: ");
            String keyword = scanner.nextLine();

            Runnable enumerator = () -> {
                try {
                    enumerate(new File(dir));
                    queue.put(DUMMY);
                } catch (InterruptedException e) {

                }
            };
            new Thread(enumerator).start();
            for (int i = 0; i <= SEARCH_THREADS; i++) {
                Runnable searcher = () -> {
                    try {
                        boolean done = false;
                        while (!done) {
                            File file = queue.take();
                            if (file == DUMMY) {
                                queue.put(file);
                                done = true;
                            } else search(file, keyword);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (InterruptedException e) {

                    }
                };
                new Thread(searcher).start();
            }
        }
    }

    /**
     * Enumerate.
     *
     * @param dir the dir
     * @throws InterruptedException the interrupted exception
     */
    public static void enumerate(File dir) throws InterruptedException {
        File[] files = dir.listFiles();
        for (File file : files) {
            if (file.isDirectory()) enumerate(file);
            else
                queue.put(file);
        }
    }

    /**
     * Search.
     *
     * @param file    the file
     * @param keyword the keyword
     * @throws IOException the io exception
     */
    public static void search(File file, String keyword) throws IOException {
        try (Scanner scanner = new Scanner(file, "UTF-8")) {
            int lineNumber = 0;
            while (scanner.hasNextLine()) {
                lineNumber++;
                String line = scanner.nextLine();
                if (line.contains(keyword))
                    System.out.printf("%s:%d:%s%n", file.getPath(), lineNumber, line);
            }
        }
    }

}
