package array;

import java.util.Scanner;

public class PerfectSubarray {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        final int n = scan.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
        }
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            int sumOfSubArr = 0;
            for (int j = i; j < arr.length; j++) {
                sumOfSubArr += arr[j];
                if (isPerfectSquare(sumOfSubArr)) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    private static boolean isPerfectSquare(int sumOfSubArr) {
        double sqrt = Math.sqrt(sumOfSubArr);
        return sqrt - Math.floor(sqrt) == 0;
    }
}