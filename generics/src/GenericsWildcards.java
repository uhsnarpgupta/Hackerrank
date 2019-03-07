import java.util.ArrayList;
import java.util.List;

public class GenericsWildcards {
    public static void main(String[] args) {
        List<Integer> ints = new ArrayList<>();
        ints.add(3);
        ints.add(5);
        ints.add(10);
        double sum = sum(ints);
        System.out.println("Sum of ints=" + sum);

        System.out.println(Integer.valueOf("10"));
        System.out.println(Integer.valueOf("-10"));

        System.out.println(Integer.parseInt("10"));
        System.out.println(Integer.parseInt("-10"));
    }

    //Upper Bounds
    public static double sum(List<? extends Number> list) {
        double sum = 0;
        for (Number n : list) {
            sum += n.doubleValue();
        }
        return sum;
    }

    //Lower Bounds
    public static void addIntegers(List<? super Integer> list) {
        list.add(new Integer(50));
    }

    //Unbounded Wildcard
    public static void printData(List<?> list) {
        for (Object obj : list) {
            System.out.print(obj + "::");
        }
    }
}
