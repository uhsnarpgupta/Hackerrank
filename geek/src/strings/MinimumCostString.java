package strings;

public class MinimumCostString {
    public static void main(String[] args) {
        String s = "geeksforgeeks";
        System.out.println(findMinConstructCost(s));
        System.out.println(minCost(s));
    }

    private static int findMinConstructCost(String s) {
        int len = s.length();
        int cost = 0;
        StringBuilder sb = new StringBuilder();
        if (len > 0) {
            sb.append(s.charAt(0));
            cost++;
            for (int i = 1; i < len; i++) {
                String temp = String.valueOf(s.charAt(i));
                String temp2 = String.valueOf(s.substring(i, len));
                if (sb.indexOf(temp2) != -1) {
                    i = len - 1;
                } else if (sb.indexOf(temp) == -1) {
                    sb.append(temp);
                    cost++;
                }
            }
        }
        return cost;
    }

    private static int minCost(String str) {
        char[] s = str.toCharArray();

        // Initially all characters are un-seen
        boolean alphabets[] = new boolean[26];

        // Marking seen characters
        for (int i = 0; i < s.length; i++) {
            alphabets[(int) s[i] - 97] = true;
        }

        // Count total seen character, and that is the cost
        int count = 0;
        for (int i = 0; i < 26; i++) {
            if (alphabets[i]) {
                count++;
            }
        }
        return count;
    }
}
