import java.util.Scanner;

public class CharDeleteForAnagram {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int testCount = Integer.parseInt(s.nextLine());
        while (testCount-- > 0) {
            String a = s.nextLine();
            String b = s.nextLine();
            System.out.println(charToBeRemoved(a, b));
        }

        String st = s.nextLine();
        char[] charArr = st.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (Character c : charArr) {
            if (65 <= c && c <= 90) {
                sb.append(c + 32);
            } else {
                sb.append(c - 32);
            }
        }
        System.out.print(sb.toString());
    }

    private static int charToBeRemoved(String a, String b) {
        boolean isAnagram = true;
        if (a == null || b == null || a.length() != b.length()) {
            isAnagram = false;
        }
        char[] first = a.toLowerCase().toCharArray();
        char[] second = b.toLowerCase().toCharArray();

        int[] counts = new int[26];
        for (int i = 0; i < first.length; i++) {
            counts[first[i] - 97]++;
            counts[second[i] - 97]--;
        }
        int removalCount = 0;
        for (int i = 0; i < 26; i++) {
            if (counts[i] != 0)
                removalCount += Math.abs(counts[i]);
        }
        return removalCount;
    }
}
