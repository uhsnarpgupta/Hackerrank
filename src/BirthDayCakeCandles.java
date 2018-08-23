import java.util.Arrays;
import java.util.Scanner;

public class BirthDayCakeCandles {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int arCount = scanner.nextInt();
        int[] ar = new int[arCount];
        for (int i = 0; i < arCount; i++) {
            ar[i] = scanner.nextInt();
        }
        int result = birthdayCakeCandles(ar);
        System.out.println(result);
        scanner.close();
    }

    static int birthdayCakeCandles(int[] ar) {
        Arrays.sort(ar);
        int max  = ar[ar.length-1];
        Long l = Arrays.stream(ar).boxed().filter(item -> item == max).count();
        return l.intValue();
    }
}
