import java.util.Scanner;

public class ArmstrongNumber {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int T = Integer.parseInt(scanner.nextLine());

        while (T-- > 0) {
            int n = Integer.parseInt(scanner.nextLine());
            System.out.println(checkForArmstrongNum(n));
        }

    }

    private static String checkForArmstrongNum(int n) {
        int sum = 0;
        for (int i = n; i > 0; i = i / 10) {
            sum += Math.pow(i % 10, 3);
        }
        return n == sum ? "Yes" : "No";
    }
}
