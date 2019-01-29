import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MaxSumWithoutAdjacent {
    // Driver program to test above functions
    public static void main(String[] args) throws IOException {
        MaxSumWithoutAdjacent sum = new MaxSumWithoutAdjacent();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCaseCount = Integer.parseInt(br.readLine());
        while (testCaseCount-- > 0) {
            int size = Integer.parseInt(br.readLine());
            String line = br.readLine();
            String[] strs = line.trim().split("\\s+");
            Integer[] array = new Integer[size];
            for (int j = 0; j < size; j++) {
                array[j] = Integer.parseInt(strs[j]);
            }
            System.out.println(sum.FindMaxSum(array, array.length));

        }
        Integer arr[] = new Integer[]{5, 5, 10, 100, 10, 5};
        System.out.println(sum.FindMaxSum(arr, arr.length));
    }

    /*Function to return max sum such that no two elements
      are adjacent */
    int FindMaxSum(Integer arr[], int n) {
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
