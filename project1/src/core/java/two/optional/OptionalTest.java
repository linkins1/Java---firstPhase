package core.java.two.optional;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.zip.DeflaterOutputStream;

public class OptionalTest {
    public static void main(String[] args) throws Exception {
        String contents = new String(Files.readAllBytes(Paths.get("F://debug_drv.log")), StandardCharsets.UTF_8);
        List<String> words = Arrays.asList(contents.split(" "));
        Optional<String> optionalValue = words.stream().
                filter(s -> s.contains("startaaa")).
                findFirst();
        System.out.println(optionalValue.orElse("No such word") + " equals to start");
        String al = optionalValue.orElseGet(()-> "123");
        System.out.println(al);
        Optional<String> optionalString = Optional.empty();
        String result = optionalString.orElse("N/A");
        System.out.println("results: " + result);
        result = optionalString.orElseGet(() -> Locale.getDefault().getDisplayName());
        System.out.println("result" + result);
        try {
            result = optionalString.orElseThrow(IllegalStateException::new);
            System.out.println("result: " + result);
        } catch (Throwable t) {
            t.printStackTrace();
        }
        optionalValue = words.stream().
                filter(s -> s.contains("s")).
                findFirst();
        optionalValue.ifPresent(s -> System.out.println(s + " contains s"));
        Set<String> results = new HashSet<>();
        optionalValue.ifPresent(results::add);
        Optional<Boolean> added = optionalValue.map(results::add);
        System.out.println(added);

        System.out.println(inverse(0.25).flatMap(OptionalTest::squareRoot));
        System.out.println(inverse(-1.0).flatMap(OptionalTest::squareRoot));
        System.out.println(inverse(0.0).flatMap(OptionalTest::squareRoot));
        Optional<Double> result2 = Optional.of(-4.0).
                flatMap(OptionalTest::inverse).
                flatMap(OptionalTest::squareRoot);
        System.out.println(result2);
    }

    public static Optional<Double> inverse(Double x) {
        return x == 0 ? Optional.empty() : Optional.of(1 / x);
    }

    public static Optional<Double> squareRoot(Double x) {
        return x < 0 ? Optional.empty() : Optional.of(Math.sqrt(x));
    }
}
