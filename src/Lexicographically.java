import java.util.Scanner;

public class Lexicographically {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String [] args){
        String A = scanner.next();
        String B = scanner.next();
        scanner.close();

        /* Sum lengths */
        System.out.println(A.length() + B.length());

        /* Compare lexicographical ordering */
        System.out.println(A.compareTo(B) > 0 ? "Yes" : "No");

        /* Print the Strings in desired format */
        System.out.println(capFirstLetter(A) + " " + capFirstLetter(B));
    }

    private static String capFirstLetter(String str) {
        if (str == null || str.length() == 0) {
            return "";
        } else {
            return str.substring(0,1).toUpperCase() + str.substring(1);
        }
    }
}
