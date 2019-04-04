package strings;

import java.util.ArrayList;

public class PossiblePalindromicPartitions {
    public static void main(String[] args) {
        String input = "nitin";

        iterateAndPalindrome(input);
    }

    private static void iterateAndPalindrome(String input) {
        StringBuilder sb = new StringBuilder();
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        for (int j = 0; j < input.length(); j++) {
            ArrayList<String> arr = new ArrayList<>();
            for (int i = j; i < input.length(); i++) {
                sb.append(input.charAt(i));
                boolean isPalindrome = checkForPalindrome(sb.toString());
                if (isPalindrome) {
                    arr.add(sb.toString());
                }
            }
            sb = new StringBuilder();
            if (!arr.isEmpty())
                result.add(arr);
        }

        for (ArrayList<String> arr : result) {
            System.out.print("[ ");
            for (String str : arr) {
                System.out.print(str + " ");
            }
            System.out.println(" ]");
        }
    }

    public static boolean checkForPalindrome(String original) {
        String reverse = new StringBuilder(original).reverse().toString();
        return original.equals(reverse);
    }

}
/*
Given a string, find all possible palindromic partitions of given string.

Example:
Input : nitin
Output:
n i t i n
n iti n
nitin

Input : geeks
Output:
g e e k s
g ee k s
 */