import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TimeConversion {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String s = scanner.nextLine();
        scanner.close();
        String result = timeConversion(s);
        System.out.println(result);
    }

    private static String timeConversion(String s) {
        int hours   = Integer.parseInt(s.substring(0,2));
        int minutes = Integer.parseInt(s.substring(3,5));
        int seconds = Integer.parseInt(s.substring(6,8));

        if (s.substring(8, 10).equals("PM") && hours != 12) {
            hours += 12;
        } else if (s.substring(8, 10).equals("AM") && hours == 12) {
            hours = 0;
        }

        System.out.format("%02d:%02d:%02d", hours, minutes, seconds);
        return null;
    }
}
