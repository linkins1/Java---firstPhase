package core.java.two.collect;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.io.IOException;
import java.io.StringReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectingTest {
    public static Stream<String> noVowels() throws IOException {
        String contents = new String(Files.readAllBytes(Paths.get("F://debug_drv.log")), StandardCharsets.UTF_8);
        List<String> wordList = Arrays.asList(contents.split(" "));
        Stream<String> words = wordList.stream();
        return words.map(s -> s.replaceAll("[aeiou]", ""));
    }

    public static <T> void show(String label, Set<T> set) {
        System.out.println(label + ": " + set.getClass().getName());
        System.out.println("[" +
                set.stream().limit(6).map(Objects::toString).
                        collect(Collectors.joining(", ")) + "]");
    }

    public static void main(String[] args) throws IOException {
        Iterator<Integer> iterator = Stream.iterate(0, n -> n + 1).limit(6).iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        Object[] number = Stream.iterate(0, n -> n + 1).limit(10).toArray();
        System.out.println("Object array: " + number);
        try {
            Integer num = (Integer) number[0];
            System.out.println("number: " + num);
            System.out.println("The following statement throws an exception: ");
            Integer[] number1 = (Integer[]) number;
        } catch (ClassCastException e) {
            System.out.println(e);
        }
        Integer[] number2 = Stream.iterate(0, n -> n + 1).limit(10).toArray(Integer[]::new);
        System.out.println("Integer array: " + number2);
        Set<String> noVowelSet = noVowels().collect(Collectors.toSet());
        show("noVowelSet", noVowelSet);
        TreeSet<String> noVowelTreeSet = noVowels().collect(Collectors.toCollection(TreeSet::new));
        show("noVowelTreeSet", noVowelTreeSet);
        String result = noVowels().limit(10).collect(Collectors.joining());
        System.out.println("Joining: " + result);
        result = noVowels().limit(10).collect(Collectors.joining(","));
        System.out.println("Joining with , : " + result);
        IntSummaryStatistics summaryStatistics = noVowels().collect(Collectors.summarizingInt(String::length));
        double averageWordLength = summaryStatistics.getAverage();
        double maxWordLength = summaryStatistics.getMax();
        System.out.println("Average word length: " + averageWordLength);
        System.out.println("Max word length: " + maxWordLength);
        System.out.println("foreach");
        noVowels().limit(10).forEach(System.out::println);
    }
}
