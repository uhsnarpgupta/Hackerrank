package bitmanipulation;

public class BinaryRepresenation {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        bin(7, sb);
        System.out.println(sb);

        StringBuilder sb2 = new StringBuilder();
        bin2(7, sb2);
        System.out.println(sb2);
    }

    static void bin(int n, StringBuilder sb) {
        /* step 1 */
        if (n > 1)
            bin(n / 2, sb);

        /* step 2 */
        sb.append(n % 2);
    }

    static void bin2(Integer n, StringBuilder sb2) {
        if (n > 1)
            bin2(n >> 1, sb2);
        sb2.append(n & 1);
    }
}
