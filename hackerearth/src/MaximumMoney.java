import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class MaximumMoney {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String[] maxCoins = br.readLine().split(" ");
        int X = Integer.parseInt(maxCoins[0]);
        int Y = Integer.parseInt(maxCoins[1]);
        int Z = Integer.parseInt(maxCoins[2]);

        int A[] = new int[n];
        int B[] = new int[n];
        int C[] = new int[n];

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            String[] ABC = br.readLine().split(" ");
            A[i] = Integer.parseInt(maxCoins[0]);

            max = A[i] > max ? A[i] : max;
            B[i] = Integer.parseInt(maxCoins[1]);
            max = B[i] > max ? B[i] : max;

            C[i] = Integer.parseInt(maxCoins[2]);
            max = C[i] > max ? C[i] : max;
        }

        Arrays.sort(A);
        Arrays.sort(B);
        Arrays.sort(C);


        int maxA = A[A.length - 1];
        int maxB = B[B.length - 1];
        int maxC = C[C.length - 1];


    }

    private static int findMaxOfArray(int[] arr) {
        Arrays.sort(arr);
        return arr[arr.length - 1];
    }

    private static int findSecondMaxOfArray(int[] arr) {
        Arrays.sort(arr);
        return arr[arr.length - 2];
    }
}
/*
Maximum Money
There are  jewelry shop. Each jewelry shop has three kinds of coins - Gold, Platinum, and Diamond having worth value  , , and  respectively. You decided to go to each of  jewelry shop and take coins from each of the shop. But to do so following conditions must satisfy -

 You can take at most  coin from an individual shop.
 You can take at most  coins of Gold type.
 You can take at most  coins of Platinum type.
 You can take at most   coins of Diamond type.
You want to collect coins from shops in such a way that worth value of coins collected is maximized.

Input Format :

The first line contains an integer . Where  is the number of jewelry shops.
The second line contains three integers  ,  , . Where  ,  ,  denotes the maximum number of coins you can collect of type Gold, Platinum, and diamond respectively.
Then   lines contain three space-separated integers  ,  , . Where  ,  ,  is the worth value of the Gold, Platinum, and diamond coin respectively.
Output Format :

Print a single integer representing the maximum worth value you can get.
Constraints :



Sample Input
4
2 1 1
5 4 5
4 3 2
10 9 7
8 2 9
Sample Output
27

 */