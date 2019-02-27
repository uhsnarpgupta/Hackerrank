package javabase;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/*
Two strings,  and , are called anagrams if they contain all the same characters in the same frequencies.
For example, the anagrams of CAT are CAT, ACT, TAC, TCA, ATC, and CTA.
The ASCII value of lowercase alphabets are from 97 to 122. And the ASCII value of uppercase alphabets are from 65 to 90
 */
public class Anagram {

    static Scanner scanner = new Scanner(System.in);

    static boolean isAnagram(String a, String b) {
        if (a == null || b == null || a.length() != b.length()) {
            return false;
        }
        char[] first = a.toLowerCase().toCharArray();
        char[] second = b.toLowerCase().toCharArray();

        int[] counts = new int[26];
        for (int i = 0; i < first.length; i++) {
            counts[first[i] - 97]++;
            counts[second[i] - 97]--;
        }
        for (int i = 0; i < 26; i++) {
            if (counts[i] != 0)
                return false;
        }
        return true;
    }

    // Time Complexity: O(n) using a HashMap
    // Space Complexity: O(n)
    static boolean isAnagram(String a, String b, boolean bol) {
        if (a == null || b == null || a.length() != b.length()) {
            return false;
        }
        a = a.toLowerCase();
        b = b.toLowerCase();
        HashMap<Character, Integer> map = new HashMap<>();

        /* Fill HashMap with 1st String */
        for (int i = 0; i < a.length(); i++) {
            char ch = a.charAt(i);
            map.merge(ch, 1, Integer::sum);
            // map.merge(ch, 1, (x, y) -> x + y);
        }

        /* Compare 2nd String to 1st String's HashMap */
        for (int i = 0; i < b.length(); i++) {
            char ch = b.charAt(i);
            if (map.containsKey(ch) && map.get(ch) > 0) {
                map.put(ch, map.get(ch) - 1);
            } else {
                return false;
            }
        }
        return true;
    }

    static void isAnagram(String s1, String s2, String p) {
        //Removing all white spaces from s1 and s2
        String copyOfs1 = s1.replaceAll("\\s", "");
        String copyOfs2 = s2.replaceAll("\\s", "");

        //Initially setting status as true
        boolean status = true;

        if (copyOfs1.length() != copyOfs2.length()) {
            //Setting status as false if copyOfs1 and copyOfs2 doesn't have same length
            status = false;
        } else {
            //Changing the case of characters of both copyOfs1 and copyOfs2 and converting them to char array
            char[] s1Array = copyOfs1.toLowerCase().toCharArray();
            char[] s2Array = copyOfs2.toLowerCase().toCharArray();

            //Sorting both s1Array and s2Array
            Arrays.sort(s1Array);
            Arrays.sort(s2Array);

            //Checking whether s1Array and s2Array are equal
            status = Arrays.equals(s1Array, s2Array);
        }

        //Output
        if (status) {
            System.out.println(s1 + " and " + s2 + " are anagrams");
        } else {
            System.out.println(s1 + " and " + s2 + " are not anagrams");
        }
    }

    public static void main(String[] args) {
        String A = scanner.next();
        String B = scanner.next();
        isAnagram(A, B, new String(""));
        System.out.println(isAnagram(A, B) ? "Anagram" : "Not Anagram");
        System.out.println(isAnagram(A, B, true) ? "Anagram" : "Not Anagram");
    }
}
