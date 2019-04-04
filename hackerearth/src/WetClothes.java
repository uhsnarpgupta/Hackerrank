import java.util.Scanner;

public class WetClothes {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] t = new int[n];

        int m = input.nextInt();
        int[] a = new int[m];

        int g = input.nextInt();
        int count = 0;

        for (int i = 0; i < n; i++) {
            t[i] = input.nextInt();
        }

        for (int i = 0; i < m; i++) {
            a[i] = input.nextInt();
        }

        for (int j = 1; j <= g; j++) {
            for (int i = 1; i < n; i++) {
                for (int k = 0; k < m; k++) {
                    if (a[k] <= t[i] - t[i - 1]) {
                        count++;
                        a[k] = 100000;
                    }
                }
            }
        }
        System.out.println(count);

    }
}
