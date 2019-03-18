import java.util.Scanner;

public class BinaryToDecimal {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int T = Integer.parseInt(scanner.nextLine());

        while (T-- > 0) {
            long n = Long.parseLong(scanner.nextLine());
            long sum = 0;
            int j = 0;
            for (long i = n; i > 0; i = i / 10) {
                long k = i % 10;
                if (k == 1) {
                    sum += Math.pow(2, j);
                }
                j++;
            }
            System.out.println(sum);
        }
    }
}
