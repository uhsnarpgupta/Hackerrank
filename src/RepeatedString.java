public class RepeatedString {
    public static void main(String[] args) {
        System.out.println(repeatedString("aba", 10));
    }

    static long repeatedString(String s, long n) {
        long sum = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a') {
                sum++;
            }
        }
        long sumInString = sum;
        sum = 0;
        long doubles = n / s.length();
        sum = doubles * sumInString;
        long modulus = n % s.length();
        for (int i = 0; i < modulus; i++) {
            if (s.charAt(i) == 'a') {
                sum++;
            }
        }
        return sum;
    }

    static long repeatedStringBad(String s, long n) {
        StringBuilder sb = new StringBuilder(s);
        String p = s;
        while (p.length() < n) {
            int k = (int) n - p.length();
            if (k < s.length()) {
                sb.append(s.substring(0, k));
            } else {
                sb.append(s);
            }
            p = sb.toString();
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (p.charAt(i) == 'a') count++;
        }
        return count;
    }
}
