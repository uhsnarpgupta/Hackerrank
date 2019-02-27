package javabase;

import java.math.BigInteger;
import java.util.Scanner;

public class PrimalityTest {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        /*int n = scanner.nextInt();
        scanner.close();

        boolean isPrime = true;

        for(int i=2; i<n/2; i++){
            if(n%i==0){
                isPrime = false;
                break;
            }
        }
        if(n==1 | n==0){
            isPrime = false;
        }*/
        int k =3;

        BigInteger n = scanner.nextBigInteger();
        System.out.println(n.isProbablePrime(10)?"prime":"not prime");
    }
}
