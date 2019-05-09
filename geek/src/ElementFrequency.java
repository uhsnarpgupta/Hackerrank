import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ElementFrequency {

    /*public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCaseCount = Integer.parseInt(br.readLine());
        while (testCaseCount-- > 0) {
            int n = Integer.parseInt(br.readLine());
            Integer[] input = new Integer[n];
            String str = br.readLine();
            String[] inputArray = str.trim().split("\\s+");
            for (int i = 0; i < n; i++) {
                input[i] = Integer.parseInt(inputArray[i]);
            }

            Map<Integer, Integer> map = new HashMap<>();
            for (Integer number : input) {
                if (map.containsKey(number)) {
                    map.put(number, map.get(number) + 1);
                } else {
                    map.put(number, 1);
                }
            }

            for (int i = 0; i < n; i++) {
                int freq = map.get(i + 1) != null ? map.get(i + 1) : 0;
                System.out.print(freq + " ");
            }
        }

    }*/

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];
            int j = 0;
            for (String str : br.readLine().split(" ")) {
                arr[j] = Integer.parseInt(str);
                j++;
            }
            printfrequency(arr, N);
        }

    }

    // Function to find counts of all elements present in
    // arr[0..n-1]. The array elements must be range from
    // 1 to n
    private static void printfrequency(int arr[], int n) {
        // Subtract 1 from every element so that the elements
        // become in range from 0 to n-1
        for (int j = 0; j < n; j++)
            arr[j] = arr[j] - 1;

        // Use every element arr[i] as index and add 'n' to
        // element present at arr[i]%n to keep track of count of
        // occurrences of arr[i]
        for (int i = 0; i < n; i++)
            arr[arr[i] % n] = arr[arr[i] % n] + n;

        // To print counts, simply print the number of times n
        // was added at index corresponding to every element
        for (int i = 0; i < n; i++)
            System.out.println(i + 1 + "->" + arr[i] / n);
    }
}

/*
Given an unsorted array of n integers which can contain integers from 1 to n. Some elements can be repeated multiple
times and some other elements can be absent from the array. Count frequency of all elements that are present and print
the missing elements.

Input: arr[] = {2, 3, 3, 2, 5}
Output: Below are frequencies of all elements
        1 -> 0
        2 -> 2
        3 -> 2
        4 -> 0
        5 -> 1

Input: arr[] = {4, 4, 4, 4}
Output: Below are frequencies of all elements
        1 -> 0
        2 -> 0
        3 -> 0
        4 -> 4
 */