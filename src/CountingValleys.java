import java.util.Stack;

public class CountingValleys {
    public static void main(String[] args) {
        System.out.println(countingValleys(8, "UDDDUDUU"));
    }

    static int countingValleys(int n, String s) {
        char[] cArr = s.toCharArray();
        Stack<Character> st = new Stack<>();
        int count = 0;
        st.push(cArr[0]);
        char c = cArr[0];
        for (int i = 1; i < cArr.length; i++) {
            if ((c == 'U' && cArr[i] == c) || (c == 'D' && cArr[i] == c) || st.size() == 0) {
                st.push(cArr[i]);
                c = cArr[i];
            } else if ((c == 'U' && cArr[i] == 'D') || (c == 'D' && cArr[i] == 'U')) {
                st.pop();
                if ((c == 'D' && cArr[i] == 'U') && st.size() == 0) {
                    count++;
                }
            }
        }
        return count;
    }
}
