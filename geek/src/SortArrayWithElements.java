import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class SortArrayWithElements {
    static Scanner scanner = new Scanner(System.in);

/*
    public static void main(String[] args) {
        //int[] arr = {0, 2, 1, 2, 0};
        int n = scanner.nextInt();
        scanner.nextLine();
        while (n-- > 0) {
            int k = scanner.nextInt();
            scanner.nextLine();
            int[] array = new int[k];
            for (int p = 0; p < k; p++) {
                array[p] = scanner.nextInt();
            }
            if (scanner.hasNextLine())
                scanner.nextLine();
            //array = sortedArray(array);
            array = anotherSolution(array);
            for (int i = 0; i < array.length; i++) {
                System.out.print(array[i] + " ");
            }
            System.out.println();
        }
    }
*/

    private static int[] sortedArray(int[] arr) {
        int count0 = 0, count1 = 0, count2 = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) count0++;
            if (arr[i] == 1) count1++;
            if (arr[i] == 2) count2++;
        }
        int j = 0;
        while (j < count0) {
            arr[j] = 0;
            j++;
        }
        while (j < count0 + count1) {
            arr[j] = 1;
            j++;
        }
        while (j < count0 + count1 + count2) {
            arr[j] = 2;
            j++;
        }
        return arr;
    }

    private static int[] anotherSolution(int[] arr) {
        int n = arr.length;
        int low = 0, mid = 0, high = n - 1, temp = 0;
        while (mid <= high) {
            if (arr[mid] == 0) {
                temp = arr[low];
                arr[low] = arr[mid];
                arr[mid] = temp;
                low++;
                mid++;
            } else if (arr[mid] == 2) {
                temp = arr[mid];
                arr[mid] = arr[high];
                arr[high] = temp;
                high--;
            } else if (arr[mid] == 1) {
                mid++;
            }
        }
        return arr;
    }

    private static int[] swap(int i, int i1, int[] arr) {
        int temp = arr[i];
        arr[i] = arr[i1];
        arr[i1] = temp;
        return arr;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        String line;
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            int[] array = new int[N];
            line = br.readLine();
            int j = 0;
            if (line != null && !line.isEmpty()) {
                for (String numString : line.split("\\s")) {
                    array[j] = Integer.parseInt(numString);
                    j++;
                }
            }
            array = bestSortingSol(array);
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < N; i++) {
                sb.append(array[i] + " ");
            }
            System.out.println(sb);
        }
    }

    private static int[] bestSortingSol(int[] arr) {
        int n = arr.length;
        int low = 0, mid = 0, high = n - 1, temp = 0;
        while (mid <= high) {
            switch (arr[mid]) {
                case 0:
                    temp = arr[low];
                    arr[low] = arr[mid];
                    arr[mid] = temp;
                    low++;
                    mid++;
                    break;
                case 2:
                    temp = arr[mid];
                    arr[mid] = arr[high];
                    arr[high] = temp;
                    high--;
                    break;

                case 1:
                    mid++;
                    break;
            }
        }
        return arr;
    }
}

/*
Given an array A of size N containing 0s, 1s, and 2s; you need to sort the array in ascending order.

Input:
The first line contains an integer 'T' denoting the total number of test cases. Then T testcases follow. Each testcases contains two lines of input. The first line denotes the size of the array N. The second lines contains the elements of the array A separated by spaces.

Output:
For each testcase, print the sorted array.

Constraints:
1 <= T <= 500
1 <= N <= 106
0 <= Ai <= 2

Example:
Input :
2
5
0 2 1 2 0
3
0 1 0

Output:
0 0 1 2 2
0 0 1

Explanation:
Testcase 1: After segragating the 0s, 1s and 2s, we have 0 0 1 2 2 which shown in the output.
 */