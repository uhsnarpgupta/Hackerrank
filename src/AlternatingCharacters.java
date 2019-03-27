public class AlternatingCharacters {
    public static void main(String[] args) {
        String s = "AAAA";
        alternatingCharacters(s);
    }

    static int alternatingCharacters(String s) {
        int count = 0;
        char[] array = s.toLowerCase().toCharArray();
        for (int i = 0; i < array.length - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                count++;

            }
        }
        return count;
    }
}

/*
You are given a string containing characters A and B only. Your task is to change it into a string such that there are no
 matching adjacent characters. To do this, you are allowed to delete zero or more characters in the string.

Your task is to find the minimum number of required deletions.

For example, given the string s = AABAAB, remove an A at positions 0 and 3 to make s = ABAB in 2 deletions.

Function Description

Complete the alternatingCharacters function in the editor below. It must return an integer representing the minimum
number of deletions to make the alternating string.

alternatingCharacters has the following parameter(s):

s: a string
Input Format

The first line contains an integer , the number of queries.
The next q lines each contain a string .

Constraints
1 <= q <=10
1 <= |s| <= 10^5

Each string  will consist only of characters A and B
Output Format

For each query, print the minimum number of deletions required on a new line.

Sample Input

5
AAAA
BBBBB
ABABABAB
BABABA
AAABBB

Sample Output

3
4
0
0
4

Explanation
The characters marked red are the ones that can be deleted so that the string doesn't have matching consecutive characters.
AAAA -> A (3 deletions)
BBBBB -> B (4 deletions)
ABABABAB -> ABABABAB (0 deletions)
BABABA -> BABABA (0 deletions)
AAABBB -> AB (4 deletions)
 */