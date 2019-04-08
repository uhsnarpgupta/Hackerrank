package strings;

public class SuperReducedString {
    public static void main(String[] args) {
        System.out.println(superReducedString("aaabccddd"));
        System.out.println(superReducedString("baab"));
        System.out.println(superReducedString("aa"));

    }

    static String superReducedString(String s) {
        while (true) {
            // Used for loop termination
            int len = s.length();

            // "(.)" is a capturing group that captures any character
            // "\\1" is a backreference that will match the character captured by the first capturing group
            // (i.e. the one captured by "(.)")
            s = s.replaceAll("(.)\\1", "");

            // If no changes were made to string, break loop
            if (s.length() == len) {
                break;
            }
        }
        return (s.isEmpty()) ? "Empty String" : s;
    }
}
