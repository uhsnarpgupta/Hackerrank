import java.math.BigInteger;
import java.util.Scanner;

public class BigIntegerOperation {
    public static void main(){
        Scanner scan = new Scanner(System.in);
        BigInteger a = scan.nextBigInteger();
        BigInteger b = scan.nextBigInteger();
        System.out.println(a.add(b));
        System.out.println(a.multiply(b));
    }
}
