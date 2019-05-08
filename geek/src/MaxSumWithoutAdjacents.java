import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MaxSumWithoutAdjacents {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            int[] array = new int[N];
            int k = 0;
            for (String element : br.readLine().split(" ")) {
                array[k] = Integer.parseInt(element);
                k++;
            }
            int max = FindMaxSum(array, N);
            System.out.println(max);
        }

    }

    /*Function to return max sum such that no two elements
      are adjacent */
    private static int FindMaxSum(int arr[], int n) {
        int incl = arr[0];
        int excl = 0;
        int excl_new;
        int i;

        for (i = 1; i < n; i++) {
            /* current max excluding i */
            excl_new = Math.max(incl, excl);

            /* current max including i */
            incl = excl + arr[i];
            excl = excl_new;
        }

        /* return max of incl and excl */
        return Math.max(incl, excl);
    }
}
/*
Given an array A of positive integers. Find the maximum sum of a subsequence such that no two numbers in the sequence
 should be adjacent in the array.

Input:
The first line of input contains an integer T denoting the number of test cases. The first line of each test case is N,
size of array. The second line of each test case contains N elements.

Output:
Print the maximum sum of a subsequence.

Constraints:
1 ≤ T ≤ 100
1 ≤ N ≤ 106
1 ≤ Ci ≤ 107

Example:
Input:
2
6
5 5 10 100 10 5
4
3 2 7 10

Output:
110
13

Explanation:
Testcase 2 : 3 and 10 forms a non-continuous subsequence with maximum sum.
 */