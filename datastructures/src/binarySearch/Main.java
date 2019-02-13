package binarySearch;

public class Main {
    public static void main(String[] args) {
        int[] array = {-22, -15, 1, 7, 20, 35, 55};
        System.out.println(iterativeBinarySearch(array, 1));

    }

    public static int iterativeBinarySearch(int[] input, int value) {
        int start = 0;
        int end = input.length;

        while (start < end) {
            int midpoint = (start + end) / 2;
            System.out.println("midpoint = " + midpoint);
            if (input[midpoint] == value) {
                return midpoint;
            } else if (input[midpoint] < value) {
                start = midpoint + 1;
            } else {
                end = midpoint;
            }
        }
        return -1;
    }

    public int recursiveBinarySearch(int arr[], int l, int r, int x) {
        if (r >= l) {
            int mid = l + (r - l) / 2;
            // If the element is present at the
            // middle itself
            if (arr[mid] == x)
                return mid;
            // If element is smaller than mid, then
            // it can only be present in left subarray
            if (arr[mid] > x)
                return recursiveBinarySearch(arr, l, mid - 1, x);
            // Else the element can only be present
            // in right subarray
            return recursiveBinarySearch(arr, mid + 1, r, x);
        }
        // We reach here when element is not present
        // in array
        return -1;
    }
}
