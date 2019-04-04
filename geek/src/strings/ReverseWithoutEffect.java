package strings;

public class ReverseWithoutEffect {
    public static void main(String[] args) {
        String str = "a,b$c";
        String str1 = "a!!!b.c.d,e'f,ghi";

        System.out.println(reverseAlphabets(str1));
    }

    private static String reverseAlphabets(String inp) {
        char[] cArray = inp.toCharArray();
        int r = cArray.length - 1, l = 0;

        while (l < r) {
            if (!Character.isAlphabetic(cArray[l])) {
                l++;
            } else if (!Character.isAlphabetic(cArray[r])) {
                r--;
            } else {
                char temp = cArray[l];
                cArray[l] = cArray[r];
                cArray[r] = temp;
            }
        }
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < cArray.length; i++) {
            sb.append(cArray[i]);
        }
        return sb.toString();
    }

    private static String reverse(String a) {
        StringBuilder sb = new StringBuilder();
        char[] cArray = a.toCharArray();
        for (int i = 0; i < cArray.length; i++) {
            char c = cArray[i];
            if ((c >= 65 && c <= 90) || (c >= 97 && c <= 123)) {
                sb.append(c);
                cArray[i] = '\u0000';
            }
        }

        sb.reverse();

        int l = 0;
        for (int i = 0; i < cArray.length; i++) {
            char c = cArray[i];
            if (c == '\u0000') {
                cArray[i] = sb.charAt(l);
                l++;
            }
        }
        sb = new StringBuilder();
        for (int i = 0; i < cArray.length; i++) {
            sb.append(cArray[i]);
        }
        return sb.toString();
    }
}

/*
Input:   str = "a,b$c"
Output:  str = "c,b$a"
Note that $ and , are not moved anywhere.
Only subsequence "abc" is reversed

Input:   str = "Ab,c,de!$"
Output:  str = "ed,c,bA!$"
 */