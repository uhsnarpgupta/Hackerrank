import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReverseStringWords {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCaseCount = Integer.parseInt(br.readLine());

        while (testCaseCount-- > 0) {
            String str = br.readLine();

            String[] words = str.trim().split("\\.");

            StringBuffer sb = new StringBuffer();
            for (int i = words.length - 1; i > 0; i--) {
                sb.append(words[i]).append(".");
            }
            sb.append(words[0]);
            System.out.println(sb);
        }
    }
}
