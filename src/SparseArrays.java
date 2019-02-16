import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SparseArrays {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        String[] input = new String[n];
        for (int i = 0; i < n; i++) {
            input[i] = scanner.nextLine();
        }

        List<String> inputList = Arrays.stream(input).collect(Collectors.toList());

        int q = scanner.nextInt();
        String[] queries = new String[q];
        for (int i = 0; i < q; i++) {
            queries[i] = scanner.nextLine();
            final int p = i;
            System.out.println(inputList.stream().filter(item -> item.equals(queries[p])).count());
        }
    }

    static int[] matchingStrings(String[] strings, String[] queries) {
        List<String> inputList = Arrays.stream(strings).collect(Collectors.toList());
        int[] output = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            final int p = i;
            output[i] = (int) inputList.stream()
                    .filter(item -> item.equals(queries[p])).count();
        }
        return output;
    }
}
