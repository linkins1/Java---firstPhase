package core.java.two.streams;

import javax.print.DocFlavor;
import javax.print.attribute.standard.PresentationDirection;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MiddleFilter {
    public static void main(String[] args) throws Exception {
        String contents = new String(Files.readAllBytes(Paths.get("C:/Users/123/Desktop/list.txt")), StandardCharsets.UTF_16);
        List<String> words = Arrays.asList(contents.split(" "));

        long count = 0;
        for (String s : words) {
            if (s.length() > 6)
                count++;
        }
        System.out.println(count);
        count = words.stream().filter(s -> s.length() > 2).count();
        System.out.println(count);

        Stream<String> stringStream = words.stream().filter(s -> s.length() > 2);
        //stringStream.forEach(System.out::println);

        String wordTest = "i am an alien";
        List<String> stringList = Arrays.asList(wordTest.split(" "));
        Stream<String> upperCases = stringList.stream().map(String::toUpperCase);
        Stream<String> firstLetters = stringList.stream().map(x -> x.substring(0, 2));

        Stream<Stream<String>> result = stringList.stream().map(x -> {
            List<String> flat = new ArrayList<>();
            for (int i = 0; i < x.length(); i++) {
                flat.add(x.substring(0, 1));
            }
            return flat.stream();
        });
//        result.forEach(x-> {
//            Set<String> strings = new HashSet<>();
//            strings = x.collect(Collectors.toSet());
//            System.out.print(strings);
//        });
//        System.out.println();
        result.forEach(x -> {
            x.forEach(System.out::print);
        });
        System.out.println();
        Stream<String> flatResult = stringList.stream().flatMap(x -> {
            List<String> flat2 = new ArrayList<>();
            for (int i = 0; i < x.length(); i++) {
                flat2.add(x.substring(0, 1));
            }
            return flat2.stream();
        });
        flatResult.forEach(System.out::print);

        System.out.println();
        System.out.println("now we implement it by writing a static method");

        Stream<Stream<String>> result_letter = stringList.stream().map(x -> letters(x));
        result_letter.forEach(x -> {
            Set<String> strings;
            strings = x.collect(Collectors.toCollection(LinkedHashSet::new));
            System.out.print(strings);
        });

        System.out.println();

        Stream<String> flatResult_letter = stringList.stream().flatMap(x -> letters(x));
        flatResult_letter.forEach(x -> System.out.print(x + " "));

        System.out.println();
        Stream<String> combined = Stream.concat(letters("hello,"), letters(" it's me"));
        combined.forEach(System.out::print);

        System.out.println();
        Stream<String> unique = Stream.of("i", "i", "i", "i", "i", "i", "fart").distinct();
        unique.forEach(System.out::print);

        System.out.println();
        Stream<String> sortStream = stringList.stream().
                sorted(Comparator.comparing(String::length).reversed());
        sortStream.forEach(x -> System.out.print(x + " "));

        System.out.println();
        Set<Double> stringSet = Stream.iterate(1.0,x->x*2).
                peek(peek-> System.out.println("Fetching: "+peek)).limit(4).collect(Collectors
                .toCollection(LinkedHashSet::new));
    }

    public static Stream<String> letters(String s) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            result.add(s.substring(i, i + 1));
        }
        return result.stream();
    }
}
