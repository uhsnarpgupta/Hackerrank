import java.util.Arrays;
import java.util.Scanner;

public class Primality {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int p = scan.nextInt();
        int [] arr = new int[p];
        String [] result = new String[p];
        while (p-- > 0) {
            arr[arr.length - p -1] = scan.nextInt();
            result[arr.length - p-1] = isPrime(arr[arr.length - p-1]) ? "Prime" : "Not prime";
        }
        scan.close();
        Arrays.stream(result).forEach(System.out::println);
    }

    public static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        } else if (n == 2) {     // account for even numbers now, so that we can do i+=2 in loop below
            return true;
        } else if (n % 2 == 0) { // account for even numbers now, so that we can do i+=2 in loop below
            return false;
        }
        int sqrt = (int) Math.sqrt(n);
        for (int i = 3; i <= sqrt; i += 2) { // skips even numbers for faster results
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
