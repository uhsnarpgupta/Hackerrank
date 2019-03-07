package java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamInJava {
    public static void main(String[] args) {
        Arrays.asList("red", "green", "blue")
                .stream()
                .sorted()
                .findFirst()
                .ifPresent(System.out::println);

        //example of Stream.of with a filter
        Stream.of("apple", "pear", "banana", "cherry", "apricot")
                .filter(fruit -> {
                    System.out.println("filter: " + fruit);
                    return fruit.startsWith("a"); //predicate
                })
                //if forEach is removed nothing will print, the forEach makes it a terminal event
                .forEach(fruit -> System.out.println("Starts with A: " + fruit));

        //using a stream and map operation to create a list of word in caps
        List<String> collected = Stream.of("Java", "Rocks")
                .map(string -> string.toUpperCase())
                .collect(Collectors.toList());
        System.out.println(collected.toString());

        /*
        PRIMITIVE STREAMS
         */
        IntStream.range(1, 4)
                .forEach(System.out::println);

        //find the average of the numbers squared
        Arrays.stream(new int[]{1, 2, 3, 4})
                .map(n -> n * n)
                .average()
                .ifPresent(System.out::println);

        //map double to ints
        Stream.of(1.5, 2.3, 3.7)
                .mapToInt(Double::intValue)
                .forEach(System.out::println);
    }
}
