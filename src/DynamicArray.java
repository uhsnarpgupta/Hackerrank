import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DynamicArray {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        int q = scanner.nextInt();
        n = 2;
        int lastAnswer = 0;

        int[] list1 = new int[n];
        int[] list2 = new int[n];
        int k = 0, l = 0;
        for (int i = 0; i < q; i++) {
            int c = scanner.nextInt();
            int x = scanner.nextInt();
            int temp = (x ^ lastAnswer) % n;
            int p = scanner.nextInt();
            switch (c) {
                case 1:
                    if (temp == 1) {
                        list2[k++] = p;
                    } else {
                        list1[l++] = p;
                    }
                    break;
                case 2:
                    if (temp == 0) {
                        lastAnswer = list1[x % l];
                    } else {
                        lastAnswer = list2[x % k];
                    }
                    System.out.println(lastAnswer);
                    break;
            }
        }
    }

    static List<Integer> dynamicArray(int n, List<List<Integer>> queries) {
        List<Integer> ans = new ArrayList<>();
        int lastAnswer = 0;
        ArrayList[] list = new ArrayList[n];
        for (int j = 0; j < n; j++) {
            list[j] = new ArrayList<Integer>();
        }

        for (int i = 0; i < queries.size(); i++) {
            List<Integer> lt = queries.get(i);
            int c = lt.get(0);
            int x = lt.get(1);
            int temp = (x ^ lastAnswer) % n;
            int p = lt.get(2);
            switch (c) {
                case 1:
                    list[temp].add(p);
                    break;
                case 2:
                    int len = list[temp].size();
                    lastAnswer = (int) list[temp].get(x % len);
                    ans.add(lastAnswer);
                    break;
            }
        }
        return ans;
    }
}
