import java.util.Scanner;

public class SeriesAP {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int T = Integer.parseInt(scanner.nextLine());
        while (T-- > 0) {
            String[] inp = scanner.nextLine().split(" ");
            int A = Integer.parseInt(inp[0]);
            int B = Integer.parseInt(inp[1]);
            int N = Integer.parseInt(scanner.nextLine());
            calculateNthTerm(A, B, N);
        }
    }

    static void calculateNthTerm(int a, int b, int n) {
        int d = b - a;
        int an = a + (n - 1) * d;
        System.out.println(an);
    }
}
