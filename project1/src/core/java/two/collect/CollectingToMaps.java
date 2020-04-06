package core.java.two.collect;

import java.io.IOException;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectingToMaps {

    public static class Person {
        private int id;
        private String name;

        public Person(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String toString() {
            return getClass().getName() + "[id=" + id + ",name=" + name + "]";
        }
    }

    public static Stream<Person> people() {
        return Stream.of(new Person(1001, "peter"), new Person(1002, "laura"), new Person(1003, "karl"));
    }

    public static void main(String[] args) throws IOException {
        Map<Integer, String> idToName = people().collect(Collectors.toMap(Person::getId, Person::getName));
        System.out.println("idToName: " + idToName);
        Map<Integer, Person> idToPerson = people().collect(Collectors.toMap(Person::getId, Function.identity()));
        System.out.println("idToPerson:" + idToPerson.getClass().getName() + idToPerson);
        idToPerson = people().collect(Collectors.toMap(Person::getId, Function.identity(),
                (exitV, newV) -> {
                    throw new IllegalStateException();
                }, TreeMap::new));
        System.out.println("idToPerson: " + idToPerson.getClass().getName() + idToPerson);
        Stream<Locale> locales = Stream.of(Locale.getAvailableLocales());
        Map<String, String> languageName = locales.collect(Collectors.toMap(Locale::getDisplayLanguage,
                L -> L.getDisplayLanguage(L), (exitV, newV) -> exitV));
        System.out.println("LanguageNames: " + languageName);
        locales = Stream.of(Locale.getAvailableLocales());
        Map<String, Set<String>> countryLanguageSet = locales.collect(Collectors.toMap(
                Locale::getDisplayCountry, L -> Collections.singleton(L.getDisplayLanguage()),
                (a, b) -> {
                    Set<String> union = new HashSet<>(a);
                    union.addAll(b);
                    return union;
                }
        ));
        System.out.println("countryLanguageSet: " + countryLanguageSet);

        locales = Stream.of(Locale.getAvailableLocales());
        Map<String, List<Locale>> countryToLocale = locales.collect(Collectors.groupingBy(Locale::getCountry));
        List<Locale> swissLocales = countryToLocale.get("CH");
        swissLocales.forEach(System.out::println);

        locales = Stream.of(Locale.getAvailableLocales());
        Map<Boolean, List<Locale>> englishAndOtherLocales = locales.collect(Collectors.
                partitioningBy(
                l->l.getLanguage().equals("en")
        ));
        List<Locale> englishLocales = englishAndOtherLocales.get(true);
        englishLocales.forEach(System.out::println);
    }
}
