package java8;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.function.*;

public class FunctionalInterfaces {
    public static void main(String[] args) {
        /*
        Predicate : Takes one arg and returns a boolean
        */
        Predicate<String> stringLen = (s) -> s.length() < 10;
        System.out.println(stringLen.test("Apples") + " - Apples is less than 10");

        /*
        Consumer : Accepts one arg and returns nothing
         */
        Consumer<String> consumerStr = (s) -> System.out.println(s.toLowerCase());
        consumerStr.accept("AbcsdadsalkdalsadsASDAAS");

        /*
        Function : Takes one arg and produces result
         */
        Function<Integer, String> converter = (num) -> Integer.toString(num);
        System.out.println("Length of 26: " + converter.apply(26).length());

        /*
        Supplier : Represents a supplier of results
         */
        Supplier<String> s = () -> "Java is fun";
        System.out.println(s.get());

        // BinaryOperator : Takes 2 args and returns 1
        BinaryOperator<Integer> add = (a, b) -> a + b;
        System.out.println("add 10 + 25 : " + add.apply(10, 25));

        //UnaryOperator : Single arg with a return value
        UnaryOperator<String> str = (msg) -> msg.toLowerCase();
        System.out.println(str.apply("This is my message in uppercase"));

        BiFunction<String, String, String> concat = (a, b) -> a + b;
        String sentence = concat.apply("Today is ", " a great day");
        System.out.println(sentence);

        Consumer<String> hello = name -> System.out.println("Hello, " + name);
        for (String name : Arrays.asList("Duke", "Mickey", "Minnie")) {
            hello.accept(name);
        }

        IntFunction<String> intToString = num -> Integer.toString(num);
        System.out.println("expected value 3, actual value: " + intToString.apply(123).length());

        //Static method reference using ::
        IntFunction<String> intToString2 = Integer::toString;
        System.out.println("expected value 4, actual value: " + intToString.apply(4567).length());

        //lambdas using a constructor
        Function<String, BigInteger> newBigInt = BigInteger::new;
        System.out.println("expected value: 123456789, actual value: " + newBigInt.apply("123456789"));

        //example of lambda made from an instance method
        Consumer<String> print = System.out::println;
        print.accept("Coming to you directly from a lambda...");

        UnaryOperator<String> makeGreeting = "Hello, "::concat;
        System.out.println(makeGreeting.apply("Peggy"));


    }
}
