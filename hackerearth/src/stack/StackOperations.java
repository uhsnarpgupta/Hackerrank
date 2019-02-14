package stack;

import java.util.Scanner;

public class StackOperations {
    public static void main(String[] args) throws Exception {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int k = s.nextInt();
        long[] arr = new long[n];
        long max = 0L;
        for (int i = 0; i < n; i++) {
            arr[i] = s.nextLong();
            if (max < arr[i] && i < k - 1) {
                max = arr[i];
            }
        }
        if (n == 1 && (k & 1) != 0) {
            System.out.println(-1);
        } else if (k < n && arr[k] > max) {
            System.out.println(arr[k]);
        } else {
            System.out.println(max);
        }
    }
}

/*
You are given a stack of N integers. In one operation, you can either pop an element from the stack or push any
popped element into the stack. You need to maximize the top element of the stack after performing exactly K operations.
If the stack becomes empty after performing K operations and there is no other way for the stack to be non-empty,
print -1.



Input format :

The first line of input consists of two space-separated integers N and K.
The second line of input consists N space-separated integers denoting the elements of the stack. The first element
represents the top of the stack and the last element represents the bottom of the stack.
Output format :

Print the maximum possible top element of the stack after performing exactly K operations.

Constraints :
1 ≤ N ≤ 2 * 10^6
1 ≤ Ai ≤ 10^18
1 ≤ K ≤ 10^9

SAMPLe INPUT:
6 4
1 2 4 3 3 5

SAMPLE OUTPUT:
4
 */