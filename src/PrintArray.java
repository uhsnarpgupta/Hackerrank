import java.util.Arrays;
import java.util.Collections;

public class PrintArray {
    public static void main(String[] args) {
        int[] array = new int[]{23, 12, 345, 32, 11, 56, 9};
        Integer[] arr = Arrays.stream(array).boxed().toArray(Integer[]::new);
        printSortedArray(arr);
    }

    private static void printSortedArray(Integer[] arr) {
        int n = arr.length;
        // Current indexes from left and right
        int l = 0, r = n - 1;

        // Count of odd numbers
        int k = 0;

        while (l < r) {
            // Find first odd number from left side.
            while (arr[l] % 2 != 0) {
                l++;
                k++;
            }

            // Find first even number from right side.
            while (arr[r] % 2 == 0 && l < r)
                r--;

            // Swap odd number present on left and even
            // number right.
            if (l < r) {
                //  swap arr[l] arr[r]
                int temp = arr[l];
                arr[l] = arr[r];
                arr[r] = temp;
            }
        }

        // Sort odd number in descending order
        Arrays.sort(arr, 0, k, Collections.reverseOrder());

        // Sort even number in ascending order
        Arrays.sort(arr, k, n);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
/*
2.Given array.Print even numbers in ascending order and odd numbers in descending order.
 */
