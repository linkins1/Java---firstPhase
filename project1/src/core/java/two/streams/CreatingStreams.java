package core.java.two.streams;

import javax.print.DocFlavor;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

public class CreatingStreams {
    public static <T> void show(String title, Stream<T> stream) {
        final int SIZE = 10;
        List<T> firstElements = stream.limit(SIZE + 1).collect(Collectors.toList());
        System.out.print(title + ": ");
        for (int i = 0; i < firstElements.size(); i++) {
            if (i > 0) System.out.print(", ");
            if (i < SIZE) System.out.print(firstElements.get(i));
            else
                System.out.println("...");
        }
        System.out.println();
    }

    public static void main(String[] args) throws Exception {
        Path path = Paths.get("F://debug_drv.log");
        String contents = new String(Files.readAllBytes(path), StandardCharsets.UTF_8);
        Stream<String> words = Stream.of(contents.split(" "));
        show("words", words);

        Stream<String> song = Stream.of("one", "for", "one");
        show("song", song);

        Stream<String> silence = Stream.empty();
        show("silence", silence);

        Stream<String> echos = Stream.generate(() -> "ECHO");
        show("echos", echos);

        Stream<Double> randoms = Stream.generate(Math::random);
        show("random", randoms);

        Stream<BigInteger> integers = Stream.iterate(BigInteger.ONE, n -> n.add(BigInteger.ONE));
        show("integers", integers);

        Stream<String> wordsAnotherWay = Pattern.compile(" ").splitAsStream(contents);
        show("wordsAnotherWay", wordsAnotherWay);

        try (Stream<String> lines = Files.lines(path, StandardCharsets.UTF_8)) {
            show("lines", lines);
        }

        Stream<Integer> intArr = Stream.of(1,2,3);
        show("intArr: ",intArr);

        Double[] dArr = {1.1,1.2,1.3};
        Stream<Double> doubleArr = Arrays.stream(dArr,0,2);
        show("dArr: ",doubleArr);

        double[] dsArr = {2.1,2.2,2.3};
        DoubleStream doubleStream = Arrays.stream(dsArr,0,2);
        doubleStream.forEach(System.out::println);

        List<String> stringList = Arrays.asList(contents);
        Stream<String> stringStream = stringList.stream();
        show("stringStream",stringStream);
    }
}
