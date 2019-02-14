package stack;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FrustratedCoders {
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = s.nextInt();
        }
        List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
        Collections.sort(list);

        int i = 0;
        while (i < list.size()) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i) < list.get(j)) {
                    list.set(i, null);
                    i++;
                }
            }
            i++;
        }

        System.out.println(list.stream().filter(item -> item != null).mapToInt(l -> l).sum());
    }
}
