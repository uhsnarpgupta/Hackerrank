import java.util.HashSet;
import java.util.Set;

public class SherlockAndValidString {
    public static void main(String[] args) {
        System.out.println(isValid("aabbccddeefghi"));
    }

    static String isValid(String s) {
        s = s.toLowerCase();
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 97]++;
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < 26; i++)
            if (count[i] > 0)
                set.add(count[i]);
        if (set.size() == 1) {
            return "YES";
        }
        for (int i = 0; i < 26; i++) {
            set.clear();
            for (int j = 0; j < 26; j++)
                if (count[j] > 0 && j != i)
                    set.add(count[j]);
            if (set.size() == 1) {
                return "YES";
            }
        }
        return "NO";
    }
}
