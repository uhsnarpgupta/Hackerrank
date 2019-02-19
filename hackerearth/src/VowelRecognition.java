import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VowelRecognition {
    public static void main(String args[]) throws Exception {
        Scanner s = new Scanner(System.in);
        int n = Integer.parseInt(s.nextLine());
        while (n-- > 0) {
            String input = s.nextLine();
            List<String> list = new ArrayList<>();
            for (int i = 0; i < input.length(); i++) {
                for (int j = i + 1; j <= input.length(); j++) {
                    list.add(input.substring(i, j));
                }
            }
            int sum = 0;
            for (String item : list) {
                item = item.toLowerCase();
                for (int i = 0; i < item.length(); i++) {
                    if (item.charAt(i) == 'a' || item.charAt(i) == 'e' || item.charAt(i) == 'i'
                            || item.charAt(i) == 'o' || item.charAt(i) == 'u') {
                        sum++;
                    }
                }
            }
            System.out.println(sum);
        }
    }
}
