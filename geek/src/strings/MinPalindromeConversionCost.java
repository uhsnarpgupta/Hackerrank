package strings;

public class MinPalindromeConversionCost {
    public static void main(String[] args) {
        String str = "fedcba";
        System.out.println(cost(str));
    }

    private static int cost(String str) {
        int len = str.length();
        char[] chars = str.toCharArray();
        int temp = len / 2;
        int cost = 0;
        for (int i = 1; i <= temp; i++) {
            if (chars[i - 1] != chars[len - i]) {
                cost += Math.min(chars[i - 1], chars[len - i]) - 97 + 1;
            }
        }
        return cost;
    }
}
