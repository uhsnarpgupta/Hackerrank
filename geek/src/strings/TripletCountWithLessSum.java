package strings;

import java.util.Arrays;

public class TripletCountWithLessSum {
    public static void main(String[] args) {
        int[] arr = {-2, 0, 1, 3};
        int sum = 2;
        int ans = 0;
        int n = arr.length;
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (arr[i] + arr[j] + arr[k] < sum) {
                        ans++;
                    }
                }
            }
        }
        //System.out.println(ans);
        System.out.println(countTriplets(arr, sum));
    }

    static int countTriplets(int[] arr, int sum) {
        // Sort input array
        Arrays.sort(arr);

        int n = arr.length;

        // Initialize result
        int ans = 0;

        // Every iteration of loop counts triplet with
        // first element as arr[i].
        for (int i = 0; i < n - 2; i++) {
            // Initialize other two elements as corner elements
            // of subarray arr[j+1..k]
            int j = i + 1, k = n - 1;

            // Use Meet in the Middle concept
            while (j < k) {
                // If sum of current triplet is more or equal,
                // move right corner to look for smaller values
                if (arr[i] + arr[j] + arr[k] >= sum)
                    k--;

                    // Else move left corner
                else {
                    // This is important. For current i and j, there
                    // can be total k-j third elements.
                    ans += (k - j);
                    j++;
                }
            }
        }
        return ans;
    }
}
