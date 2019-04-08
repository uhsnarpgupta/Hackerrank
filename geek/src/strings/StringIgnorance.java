package strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class StringIgnorance {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            String str = br.readLine();
            System.out.println(ignoredString(str));
        }
    }

    private static String ignoredString(String str) {
        char[] arr = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        Map<Character, Integer> map = new HashMap<>();
        for (char c : arr) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
            if(map.get(c) == 1){
                sb.append(c);
            }
        }
        return null;
    }
}

/*
Given a string of both uppercase and lowercase alphabets, the task is to print the string with alternate occurrences of
 any character dropped(including space and consider upper and lowercase as same).

Input:
First line consists of T test cases. First line of every test case consists of String S.

Output:
Single line output, print the updated string.

Constraints:
1<=T<=100
1<=|String|<=10000

Example:
Input:
2
It is a long day dear.
Geeks for geeks
Output:
It sa longdy ear.
Geks fore

Explanation:
For the 1st test case.
Print first "I" and then ignore next "i". Similarly print first space then ignore next space. and so on.
 */