package datastructures.sort;

public class SelectionSort {
    private static int[] sort(int[] unsortedArray) {
        for (int lastUnsortedIndex = unsortedArray.length - 1; lastUnsortedIndex >= 0; lastUnsortedIndex--) {
            int largestIndex = 0;
            for (int i = 1; i <= lastUnsortedIndex; i++) {
                largestIndex = unsortedArray[largestIndex] < unsortedArray[i] ? i : largestIndex;
            }
            swap(unsortedArray, largestIndex, lastUnsortedIndex);
        }
        return unsortedArray;
    }

    private static void swap(int[] unsortedArray, int j, int i) {
        int temp = unsortedArray[j];
        unsortedArray[j] = unsortedArray[i];
        unsortedArray[i] = temp;
    }

    public static void main(String[] args) {
        int[] intArray = {20, 35, -15, 7, 55, 1, -22};
        for (int i : sort(intArray)) {
            System.out.print(i + " ");
        }
    }
}
