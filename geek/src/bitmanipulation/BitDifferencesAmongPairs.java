package bitmanipulation;

import java.util.ArrayList;
import java.util.List;

public class BitDifferencesAmongPairs {
    public static void main(String[] args) {
        int[] inp = {1, 3, 5};
        int n = inp.length;
        int[][] subArrays = new int[n][];

        List<List<Integer>> ls = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                List<Integer> lt = new ArrayList<>();
                for (int k = i; k <= j; k++) {
                    lt.add(inp[k]);
                }
                ls.add(lt);
            }
        }
        for (List<Integer> list : ls) {
            for (Integer it : list) {
                System.out.print(it + " ");
            }
            System.out.println();
        }
    }
}
