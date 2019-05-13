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
/*
Streams support functional-style operations on streams of elements, such as map-reduce transformations on collections.
Stream operations are divided into intermediate and terminal operations, and are combined to form stream pipelines.
A stream pipeline consists of a source (such as a Collection, an array, a generator function, or an I/O channel);
followed by zero or more intermediate operations such as Stream.filter or Stream.map; and a terminal operation such as
Stream.forEach or Stream.reduce.

Intermediate operations return a new stream. They are always lazy; executing an intermediate operation such as filter()
does not actually perform any filtering, but instead creates a new stream that, when traversed, contains the elements
of the initial stream that match the given predicate. Traversal of the pipeline source does not begin until the terminal
operation of the pipeline is executed.

Terminal operations, such as Stream.forEach or IntStream.sum, may traverse the stream to produce a result or a
side-effect. After the terminal operation is performed, the stream pipeline is considered consumed, and can no longer be
used; if you need to traverse the same data source again, you must return to the data source to get a new stream. In
almost all cases, terminal operations are eager, completing their traversal of the data source and processing of the
pipeline before returning. Only the terminal operations iterator() and spliterator() are not; these are provided as an
"escape hatch" to enable arbitrary client-controlled pipeline traversals in the event that the existing operations are
not sufficient to the task.

Stateless operations, such as filter and map, retain no state from previously seen element when processing a
new element

Stateful operations, such as distinct and sorted, may incorporate state from previously seen elements when processing
new elements
 */