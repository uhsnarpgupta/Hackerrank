import java.util.Scanner;

public class MinimumOperations {
    private static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        int m = Integer.parseInt(scan.nextLine());
        while (m-- > 0) {
            int ops = 0;
            int n = scan.nextInt();
            while (n >= 1) {
                if (n == 1) {
                    ops++;
                    break;
                } else {
                    if (n % 2 == 0) {
                        n = n / 2;
                        ops++;
                    } else {
                        n = n - 1;
                        ops++;
                    }
                }
            }
            System.out.println(ops);
        }
    }

    private static int fn(int n) {
        int ans = Integer.MAX_VALUE;
        return Math.min(ans, Math.min(1 + fn(n - 1), 1 + fn(n / 2) + n % 2));
    }
}

/*
You are given a number N. You have to find the number of operations required to reach N from 0. You have 2 operations available:

Double the number
Add one to the number
Input:
The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. Each test case contains an integer N.

Output:
For each test case, in a new line, print the minimum number of operations required to reach N from 0.

Constraints:
1<=T<=100
1<=N<=104

Example:
Input:
2
8
7
Input:
4
5

Explanation:
Testcase1:
Input  : N = 8
Output : 4
0 + 1 = 1, 1 + 1 = 2, 2 * 2 = 4, 4 * 2 = 8
Testcase2:
Input  : N = 7
Output : 5
0 + 1 = 1, 1 + 1 = 2, 1 + 2 = 3, 3 * 2 = 6, 6 + 1 = 7

Recurrence relation
F(N) = min(ans,min(1 + F(n-1),1 + F(n/2) + N%2));
// two states one from previous, and one from half the distance plus an unequal length ie (N%2)
 */