package strings;

public class MinDistanceOfWords {
    public static void main(String[] args) {
        String str = "geeks for geeks contribute practice";
        String w1 = "geeks";
        String w2 = "practice";

        String str2 = "the quick the brown quick brown the frog";
        String w11 = "quick";
        String w22 = "the";

        System.out.println(minDistance(str, w1, w2));
        System.out.println(minDistance(str2, w11, w22));
    }

    private static int minDistance(String str, String w1, String w2) {
        String[] arr = str.split(" ");
        int index1 = -1;
        int index2 = -1;
        int distance = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (w1.equals(arr[i])) index1 = i;
            if (w2.equals(arr[i])) index2 = i;
            if (index1 != -1 && index2 != -1) {
                distance = Math.min(distance, Math.abs(index2 - index1) - 1);
            }
        }

        if (index1 != -1 && index2 != -1) {
            return distance;
        }
        return -1;
    }
}
