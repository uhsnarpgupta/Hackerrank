public class RecursiveDigitSum {
    public static void main(String[] args) {
        System.out.println(superDigit("123", 3));
    }

    static int superDigit(String n, int k) {
        StringBuilder sb = new StringBuilder(n);
        while (k-- > 1) {
            sb.append(n);
        }
        long num = Long.parseLong(sb.toString());
        int sum = 0;
        do {
            for (long i = num; i > 0; i = i / 10) {
                sum += i % 10;
            }
            num = sum;
            sum = 0;
        } while (num > 9);
        return (int) num;
    }
}
