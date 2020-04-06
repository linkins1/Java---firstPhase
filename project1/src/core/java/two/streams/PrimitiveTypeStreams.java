package core.java.two.streams;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.IntSummaryStatistics;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PrimitiveTypeStreams {
    public static void show(String title, IntStream stream) {
        final int SIZE = 10;
        int[] firstElements = stream.limit(SIZE + 1).toArray();
        System.out.print(title + ": ");
        for (int i = 0; i < firstElements.length; i++) {
            if (i > 0)
                System.out.print(", ");
            if (i < SIZE)
                System.out.print(firstElements[i]);
            else
                System.out.print("...");
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        IntStream intStream = IntStream.generate(() -> (int) (Math.random() * 100));
        show("is1", intStream);
        IntStream intStream2 = IntStream.range(5, 10);
        show("is2", intStream2);
        IntStream intStream3 = IntStream.rangeClosed(5, 10);
        show("is3", intStream3);
        Path path = Paths.get("F://debug_drv.log");
        String contents = new String(Files.readAllBytes(path), StandardCharsets.UTF_8);

        Stream<String> words = Stream.of(contents.split(" "));
        IntStream intStream4 = words.mapToInt(String::length);
        show("is4", intStream4);
        String sentence = "\uD835\uDD46 is the set of octonions.";
        System.out.println(sentence);
        IntStream codes = sentence.codePoints();
        System.out.println(codes.mapToObj(c -> String.format("%X ", c)).collect(
                Collectors.joining()));

        Stream<Integer> integers = IntStream.range(0, 100).boxed();
        IntStream intStream5 = integers.mapToInt(Integer::intValue);
        show("is5", intStream5);
    }
}
