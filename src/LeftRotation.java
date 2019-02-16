import java.util.Scanner;

public class LeftRotation {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] a = new int[n];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }

        while (d != 0) {
            int temp = a[0];
            for (int i = n - 1; i > 0; i--) {
                a[n - 1 - i] = a[n - i];
            }
            a[n - 1] = temp;
            d--;
        }

        for (int j = 0; j < n; j++) {
            System.out.print(a[j] + " ");
        }
        scanner.close();
    }
}
