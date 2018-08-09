import java.util.Scanner;
import java.util.regex.Pattern;

public class PatternRegexChecker {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());
        while(testCases-- > 0){
            String pattern = in.nextLine();
            try {
                Pattern pattern1 = Pattern.compile(pattern);
            }
            catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }
}
