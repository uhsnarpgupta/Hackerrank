import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SortArrayWithZO {
    // Driver Code
    public static void main(String[] args) throws IOException {

        // Using BufferedReader class to take input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // taking input of number of testcase
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            // n : size of array
            int n = Integer.parseInt(br.readLine());

            // Declaring array
            Integer arr[] = new Integer[n];

            // to read multiple integers line
            String line = br.readLine();
            String[] strs = line.trim().split("\\s+");

            // array elements input
            for (int i = 0; i < n; i++)
                arr[i] = Integer.parseInt(strs[i]);

            List<Integer> list = Arrays.asList(arr);
            // Calling Functions to segregate Array elements
            Collections.sort(list);

            // Using string buffer to append each output in a string
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < n; i++)
                sb.append(list.get(i) + " ");

            // finally printing the string
            System.out.println(sb);
        }
        br.close();
    }
}
