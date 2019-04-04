package sets;

import java.util.Set;
import java.util.TreeSet;

public class ElementAppearingOnce {
    static int[] arr = {12, 1, 12, 3, 12, 1, 1, 2, 3, 3};

    public static void main(String[] args) {
        int ar = findElementWithFreqOne(arr);
        System.out.println(ar);
    }

    private static int findElementWithFreqOne(int[] arr) {
        int sum_arr = 0;
        int sum_set = 0;
        Set<Integer> set = new TreeSet<>();
        for (int ele : arr) {
            set.add(ele);
            sum_arr += ele;
        }

        for (Integer it : set) {
            sum_set += it;
        }

        return ((3 * sum_set) - sum_arr) / 2;
    }
}
