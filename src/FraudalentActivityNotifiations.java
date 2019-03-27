import java.util.Arrays;

public class FraudalentActivityNotifiations {
    static int[] expenditure = {2, 3, 4, 2, 3, 6, 8, 4, 5};
    static int[] expenditure1 = {10, 20, 30, 40, 50};

    static int d = 5;
    static int d1 = 3;

    public static void main(String[] args) {
        System.out.println(activityNotifications(expenditure, d));
    }

    private static int activityNotifications(int[] expenditure, int d) {
        int count = 0;
        int k = 0;

        while (k + d < expenditure.length) {
            for (int i = k; i < k + d; i++) {
                if (i + d < expenditure.length - 1 &&
                        expenditure[i + d] >= median(Arrays.copyOfRange(expenditure, i, i + d), d)) {
                    count++;
                } else {
                    break;
                }
            }
            k++;
        }

        /*for (int i = 0; i < expenditure.length - d; i++) {
            for (int j = i; j < i + d - 1; j++) {
                if (expenditure[i + d] > median(Arrays.copyOfRange(expenditure, j, j + d - 1), d)) {
                    count++;
                } else {
                    break;
                }
            }

        }*/
        return count;
    }

    private static int median(int[] expenditure, int d) {
        int median;
        Arrays.sort(expenditure);
        if (d % 2 != 0) {
            median = expenditure[(int) Math.ceil(d / 2)];
        } else {
            median = (expenditure[d / 2] + expenditure[(d / 2) + 1]) / 2;
        }

        return median;
    }
}
