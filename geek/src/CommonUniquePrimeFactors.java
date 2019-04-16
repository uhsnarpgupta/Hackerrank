import java.util.ArrayList;
import java.util.List;

public class CommonUniquePrimeFactors {
    static final int MAXN = 100001;
    static boolean prime[] = new boolean[MAXN];

    static void SieveOfEratosthenes() {

        // Create a boolean array "prime[0..n]" and initialize
        // all entries it as true. A value in prime[i] will
        // finally be false if i is Not a prime, else true.

        for (int i = 0; i < prime.length; i++)
            prime[i] = true;

        // 0 and 1 are not prime numbers
        prime[0] = false;
        prime[1] = false;

        for (int p = 2; p * p < MAXN; p++) {
            // If prime[p] is not changed, then it is a prime
            if (prime[p] == true) {

                // Update all multiples of p as non-prime
                for (int i = p * p; i < MAXN; i += p)
                    prime[i] = false;
            }
        }
    }

    // Find the common prime divisors
    static int[] commonPrimeFactors(int a, int b) {
        List<Integer> lt = new ArrayList<>();

        // Get the GCD of the given numbers
        int gcd = (int) gcd(a, b);

        // Find the prime divisors of the gcd
        for (int i = 2; i <= (gcd); i++) {
            // If i is prime and a divisor of gcd
            if (prime[i] && gcd % i == 0) {
                lt.add(i);
            }
        }
        int[] array = new int[lt.size()];
        for (int i = 0; i < array.length; i++) {
            array[i] = lt.get(i);
        }
        return array;
    }

    static long gcd(long a, long b) {
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }

    public static void main(String[] args) {
        SieveOfEratosthenes();
        int a = 30, b = 165;
        int[] arr = commonPrimeFactors(a, b);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i] + " ");
        }
    }
}
