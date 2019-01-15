package datastructures.sort;

public class BubbleSort {
    private static int[] sort(int[] unsortedArray) {
        for (int lastUnsortedIndex = 0; lastUnsortedIndex < unsortedArray.length; lastUnsortedIndex++) {
            for (int i = lastUnsortedIndex + 1; i < unsortedArray.length; i++) {
                if (unsortedArray[lastUnsortedIndex] > unsortedArray[i]) {
                    swap(unsortedArray, lastUnsortedIndex, i);
                }
            }
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
