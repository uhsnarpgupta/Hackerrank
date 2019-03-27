public class BubbSort {
    private static int count = 0;

    // Complete the countSwaps function below.
    static void countSwaps(int[] a) {
        int [] arr = bubbleSort(a);
        System.out.println("Array is sorted in " + count + " swaps.");
        System.out.println("First Element: " + arr[0]);
        System.out.println("Last Element: " + arr[a.length - 1]);

    }

    private static int[] bubbleSort(int[] arr) {
        boolean isSorted = false;
        int lastUnsorted = arr.length - 1;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < lastUnsorted; i++) {
                if (arr[i] > arr[i + 1]) {
                    swap(arr, i, i + 1);
                    isSorted = false;
                    count++;
                }
            }
            lastUnsorted--;
        }
        return arr;
    }

    private static int[] swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
        return a;
    }

    public static void main(String[] args) {
        countSwaps(new int[]{3, 2, 1});
    }
}
