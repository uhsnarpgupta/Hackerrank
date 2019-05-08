import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReverseWordsInGivenString {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            String inputString = br.readLine();
            String[] arr = inputString.split("\\.");
            StringBuilder sb = new StringBuilder();
            for (int j = arr.length - 1; j >= 0; j--) {
                if (j == 0) sb.append(arr[j]);
                else sb.append(arr[j]).append(".");
            }
            System.out.println(sb.toString());
        }
    }
}
