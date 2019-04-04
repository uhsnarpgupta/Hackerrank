import java.io.BufferedReader;
import java.io.InputStreamReader;

public class EasySumSet {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        String[] stringArr = br.readLine().split(" ");
        int[] intA = getIntArray(stringArr, a);

        int b = Integer.parseInt(br.readLine());
        String[] stringArrB = br.readLine().split(" ");
        int[] intB = getIntArray(stringArrB, b);

        for (int k = 1; k < 100; k++) {
            boolean canAdd = true;
            for (int i = 0; i < a; i++) {
                if (!isElementOfC((k + intA[i]), intB)) {
                    canAdd = false;
                }
            }
            if (canAdd) {
                System.out.print(k + " ");
            }
        }
    }

    private static boolean isElementOfC(int i, int[] c) {
        for (int p = 0; p < c.length; p++) {
            if (i == c[p]) return true;
        }
        return false;
    }

    private static int[] getIntArray(String[] stringArr, int a) {
        int[] intArr = new int[a];
        for (int i = 0; i < a; i++) {
            intArr[i] = Integer.parseInt(stringArr[i]);
        }
        return intArr;
    }
}
/*
In this problem, we define "set" is a collection of distinct numbers. For two sets A and B, we define their sum set is a
set S(A,B) = {a+b | a belongsTo A, b belongsTo B}. In other word, set S(A,B) contains all elements which can be represented
 as sum of an element in A and an element in B.
Given two sets A,C, your task is to find set B of positive integers less than or equals 100 with maximum size such that
S(A,B) = C.
It is guaranteed that there is unique such set.

Input Format

The first line contains N denoting the number of elements in set A, the following line contains N space-separated integers
ai denoting the elements of set A.

The third line contains M denoting the number of elements in set C, the following line contains M space-separated integers
ci denoting the elements of set C.

Output Format

Print all elements of B in increasing order in a single line, separated by space.

Constarints
1 <= N,M <=100
1 <= ai, ci <=100
 */
