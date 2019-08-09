import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LongestCommonSubsequence {

    public static void main(String[] args) {
        //String X = "ABCBDAB", Y = "BDCABA";
       /* System.out.println("The length of LongestCommonSubsequence is " + LCSLength(X, Y, X.length(), Y.length()));
        int m = X.length(), n = Y.length();
        int[][] seqMat = new int[m + 1][n + 1];*/

        String X = "XMJYAUZ", Y = "MZJAWXU";
        int m = X.length(), n = Y.length();
        // T[i][j] stores the length of LongestCommonSubsequence of substring
        // X[0..i-1], Y[0..j-1]
        int[][] T = new int[m + 1][n + 1];

        // fill lookup table
        LCSTable(X, Y, m, n, T);

        // find longest common sequence
        System.out.println(LCS(X, Y, m, n, T));

        String X1 = "ABCBDAB", Y1 = "BDCABA";
        // T[i][j] stores the length of LongestCommonSubsequence of substring
        // X[0..i-1], Y[0..j-1]
        int[][] T2 = new int[X1.length() + 1][Y1.length() + 1];

        Set<String> lcs = LCS(X1, Y1, T2);

        // print set elements

        lcs.forEach(System.out::println);
        //System.out.print(lcs);
    }

    private static int LCSLength(String X, String Y, int m, int n) {
        //return if we have reached the end of either sequence
        if (m == 0 || n == 0)
            return 0;

        //if last character of X and Y matches
        if (X.charAt(m - 1) == Y.charAt(n - 1))
            return LCSLength(X, Y, m - 1, n - 1) + 1;

        //else if last character of X and Y don't match
        return Integer.max((LCSLength(X, Y, m, n - 1)), LCSLength(X, Y, m - 1, n));
    }

    // Function to fill lookup table by finding the length of LongestCommonSubsequence
    // of substring X[0..m-1] and Y[0..n-1]
    public static void LCSTable(String p, String q, int m, int n, int[][] seqMat) {
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (p.charAt(i - 1) == q.charAt(j - 1))
                    seqMat[i][j] = seqMat[i - 1][j - 1] + 1;
                else
                    seqMat[i][j] = Integer.max(seqMat[i - 1][j], seqMat[i][j - 1]);
            }
        }
    }

    // Function to find LongestCommonSubsequence of String X[0..m-1] and Y[0..n-1]
    public static String LCS(String X, String Y, int m, int n, int[][] T) {
        // return empty string if we have reached the end of
        // either sequence
        if (m == 0 || n == 0) {
            return new String();
        }

        // if last character of X and Y matches
        if (X.charAt(m - 1) == Y.charAt(n - 1)) {
            // append current character (X[m-1] or Y[n-1]) to LongestCommonSubsequence of
            // substring X[0..m-2] and Y[0..n-2]
            return LCS(X, Y, m - 1, n - 1, T) + X.charAt(m - 1);
        }

        // else when the last character of X and Y are different

        // if top cell of current cell has more value than the left
        // cell, then drop current character of String X and find LongestCommonSubsequence
        // of substring X[0..m-2], Y[0..n-1]

        if (T[m - 1][n] > T[m][n - 1]) {
            return LCS(X, Y, m - 1, n, T);
        } else {
            // if left cell of current cell has more value than the top
            // cell, then drop current character of String Y and find LongestCommonSubsequence
            // of substring X[0..m-1], Y[0..n-2]

            return LCS(X, Y, m, n - 1, T);
        }
    }

    // Function to return all LongestCommonSubsequence of sub-strings X[0..m-1], Y[0..n-1]
    public static List<String> AllLCS(String X, String Y, int m, int n,
            int[][] T) {
        // if we have reached the end of either sequence
        if (m == 0 || n == 0) {
            // create a List with 1 empty string and return
            return new ArrayList<>(Collections.nCopies(1, ""));
        }

        // if last character of X and Y matches
        if (X.charAt(m - 1) == Y.charAt(n - 1)) {
            // ignore last characters of X and Y and find all LongestCommonSubsequence of
            // substring X[0..m-2], Y[0..n-2] and store it in a List
            List<String> lcs = AllLCS(X, Y, m - 1, n - 1, T);

            // append current character X[m - 1] or Y[n - 1]
            // to all LongestCommonSubsequence of substring X[0..m-2] and Y[0..n-2]
            for (int i = 0; i < lcs.size(); i++) {
                lcs.set(i, lcs.get(i) + (X.charAt(m - 1)));
            }

            return lcs;
        }

        // we reach here when the last character of X and Y don't match

        // if top cell of current cell has more value than the left cell,
        // then ignore current character of String X and find all LongestCommonSubsequence of
        // substring X[0..m-2], Y[0..n-1]
        if (T[m - 1][n] > T[m][n - 1])
            return AllLCS(X, Y, m - 1, n, T);

        // if left cell of current cell has more value than the top cell,
        // then ignore current character of String Y and find all LongestCommonSubsequence of
        // substring X[0..m-1], Y[0..n-2]
        if (T[m][n - 1] > T[m - 1][n])
            return AllLCS(X, Y, m, n - 1, T);

        // if top cell has equal value to the left cell,
        // then consider both character

        List<String> top = AllLCS(X, Y, m - 1, n, T);
        List<String> left = AllLCS(X, Y, m, n - 1, T);

        // merge two Lists and return
        top.addAll(left);

        return top;
    }

    // Function to find all LongestCommonSubsequence of String X[0..m-1] and Y[0..n-1]
    public static Set<String> LCS(String X, String Y, int[][] T) {
        // fill lookup table
        LCSTable(X, Y, X.length(), Y.length(), T);

        // find all longest common sequences
        List<String> lcs = AllLCS(X, Y, X.length(), Y.length(), T);

        // since List can contain duplicates, "convert" the list
        // to Set and return
        return new HashSet<>(lcs);
    }
}
