public class BitwiseOperators {
    public static void main(String[] args) {
        int x = 42, y = 27;
        System.out.printf("%d , %d", x, y);
        System.out.println();

        System.out.println(Integer.toBinaryString(x) + " " + Integer.toBinaryString(y));

        System.out.println("x & y: " + (x & y));
        System.out.println("x | y: " + (x | y));
        System.out.println("x ^ y: " + (x ^ y));
        System.out.println("~x: " + (~x));
        System.out.println("x << 2: " + (x << 2));
        System.out.println("x >> 2: " + (x >> 2));

    }
}
