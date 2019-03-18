package stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class NitishAndPillars {
    private static Scanner scanner = new Scanner(System.in);
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        long n = Long.parseLong(br.readLine());
        //int n = Integer.parseInt(br.readLine());
        //scanner.nextLine();
        long[] pillars = new long[(int) n];
        int i = 0;

        String[] arr = br.readLine().trim().split(" ");
        while (n-- > 0) {
            pillars[i] = Long.parseLong(arr[i]);
            i++;
        }

        long q = Long.parseLong(br.readLine());
        while (q-- > 0) {
            String[] indices = br.readLine().trim().split(" ");
            long l = Long.parseLong(indices[0]);
            long r = Long.parseLong(indices[1]);
            System.out.println(countVisiblePillars(pillars, l, r));
        }
    }

    private static int countVisiblePillars(long[] pillars, long l, long r) {
        int count = 0;
        long big = pillars[(int) l];
        for (long i = l + 1; i <= r; i++) {
            if (pillars[(int) i] >= big) {
                count++;
                big = pillars[(int) i];
            }
        }
        return count + 1;
    }
}

/*
Nitish is a short heighted person. He is standing facing N pillars of different heights with ith pillar having height
hi. He tries to see all the possible pillars. He wants to know that how many buildings will he be able to see in the
range [L, R] both inclusive.

Input

The first line contains an integer N denoting the number of pillars.
Next line contains N integers denoting height of ith pillar.
Next line contains a single integer Q.
Next Q lines contain pairs L and R respectively.


Output
For every Q queries print the number of buildings visible in the range [L, R].

Constraints

1<=N, Q<=105

1<=L<=R<=N

1<=h<=109

SAMPLE INPUT
7
5 2 3 7 9 8 11
4
0 6
1 5
2 6
3 4
SAMPLE OUTPUT
4
4
4
2
Explanation
In query 1 5, 7, 9, 11 pillars are visible so answer is 4.

In query 2 2, 3, 7, 9 are visible so answer is 4.
 */