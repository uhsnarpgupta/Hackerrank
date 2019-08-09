public class LongestPalindromicSubsequence {

    public static void main(String[] args) {
        String x = "ABBDCACB";
        int len = x.length() - 1;
        int index = 0;

        System.out.println("The length of Longest Palindromic Subsequence is " + longestPalindrome(x, index, len));
        System.out.println("The length of Longest Palindromic Subsequence is " + longestPalindromeString(x, index, len));

    }

    public static int longestPalindrome(String x, int index, int len) {
        // base condition
        if (index > len)
            return 0;
        // if String X has only one character, it is palindrome
        if (index == len)
            return 1;
        // if last character of the string is same as the first character
        if (x.charAt(index) == x.charAt(len))
            // include first and last characters in palindrome
            // and recur for the remaining substring X[i+1, j-1]
            return longestPalindrome(x, index + 1, len - 1) + 2;

        // if last character of string is different to the first character

        // return maximum of -
        // 1. Remove last character & recur for the remaining
        // substring X[i, j-1]
        // 2. Remove first character & recur for the remaining
        // substring X[i+1, j]
        return Math.max(longestPalindrome(x, index + 1, len), longestPalindrome(x, index, len - 1));
    }

    public static String longestPalindromeString(String x, int index, int len) {
        // base condition
        if (index > len)
            return "";
        // if String X has only one character, it is palindrome
        if (index == len)
            return "" + x.charAt(index);
        // if last character of the string is same as the first character
        if (x.charAt(index) == x.charAt(len))
            // include first and last characters in palindrome
            // and recur for the remaining substring X[i+1, j-1]
            return x.charAt(index) + longestPalindromeString(x, index + 1, len - 1) + x.charAt(len);

        // if last character of string is different to the first character

        // return maximum of -
        // 1. Remove last character & recur for the remaining
        // substring X[i, j-1]
        // 2. Remove first character & recur for the remaining
        // substring X[i+1, j]
        String q = longestPalindromeString(x, index + 1, len);
        String r = longestPalindromeString(x, index, len - 1);
        return q.length() > r.length() ? q : r;
    }
}
