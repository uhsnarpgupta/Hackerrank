import java.util.*;
import java.util.stream.Collectors;

public class SecondLargestNum {
    public static void main(String[] args) {
        int[] arr1 = {5, 19, 7, 11, 8};
        int[] arr2 = {5, 10, 10};
        int[] arr3 = {10, 10, 10};

        print2largest(arr3);
    }

    private static void secondLargestElement(int[] arr) {
        List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
        Collections.sort(list);
        Set<Integer> set = new LinkedHashSet<>(list);
        if (set.size() > 1) {
            list = new ArrayList<>(set);
            System.out.println(list.get(set.size() - 2));
        } else {
            System.out.println("It does not have second largest element");
        }
    }

    /* Function to print the second largest
    elements */
    public static void print2largest(int arr[]) {
        int i, first, second;

        int arr_size = arr.length;
        /* There should be atleast two elements */
        if (arr_size < 2) {
            System.out.print(" Invalid Input ");
            return;
        }

        first = second = Integer.MIN_VALUE;
        for (i = 0; i < arr_size; i++) {
            /* If current element is smaller than
            first then update both first and second */
            if (arr[i] > first) {
                second = first;
                first = arr[i];
            }

            /* If arr[i] is in between first and
               second then update second  */
            else if (arr[i] > second && arr[i] != first)
                second = arr[i];
        }

        if (second == Integer.MIN_VALUE)
            System.out.print("There is no second largest" +
                    " element\n");
        else
            System.out.print("The second largest element" +
                    " is " + second);
    }
}
