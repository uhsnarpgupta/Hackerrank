public class PairPresence {
    public static void main(String[] args) {
        String s1 = "RRGGBB";
        checkPair(s1);
    }

    private static void checkPair(String s1) {
        char[] c = s1.toLowerCase().toCharArray();
        int count[] = new int[26];
        for (int i = 0; i < c.length; i++) {
            count[c[i] - 97]++;
        }
        for (int k = 0; k < 26; k++) {
            if (count[k] % 2 != 0) {

            }
        }
    }
}
