package array;

import java.util.Scanner;

public class TakeOff {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        for (int i = 1; i <= T; i++) {
            int N = scan.nextInt();
            int p = scan.nextInt();
            int q = scan.nextInt();
            int r = scan.nextInt();
            int c = 0;
            int D = Math.min(p, Math.min(q, r));
            int mc = 0;
            while (D <= N) {
                if (D % p == 0) {
                    mc++;
                }
                if (D % q == 0) {
                    mc++;
                }
                if (D % r == 0) {
                    mc++;
                }
                if (mc == 1) {
                    c++;
                }
                mc = 0;
                D++;
            }
            System.out.println(c);
        }
    }
}
/*
There are three planes A, B and C. Plane A will takeoff on every p(th) day i.e. p, 2p, 3p  and so on. Plane B will
takeoff on every q(th) day and plane C will takeoff on every r(th) day. There is only one runway and the
takeoff timing is same for each of the three planes on each day. Your task is to find out the maximum number of
flights that will successfully takeoff in the period of  days.

Note: If there is collision between the flights no flight will take off on that day.

Input Format
The first line of the input contains a single integer , the number of test cases.
Then  lines follow each containing four space-separated integers , ,  and  as denoted in the statement.

Output Format
For each test case print a single integer representing the maximum number of flights that will successfully takeoff
in the period of  days.

Constraints
1 <= T <= 10
1 <= N,p,q,r <= 10^5

Sample Input:
2
10 2 3 4
10 2 2 4

Sample Output:
4
0

Explanation
Sample test case 1:
Note that on days 2 and 10 plane A can takeoff, on days 3 and 9 plane B can takeoff.

Sample test case :
Note that there is no day on which there is no collision.
 */
