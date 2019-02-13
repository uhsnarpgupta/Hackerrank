package sort;

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

/*
Bubble sort has
worst-case and average complexity both О(n^2)
2, 4, 6, 9, 12, 23, 0, 1, 34,

2, 4, 6, 9, 12, 0, 1, 23, 34,

2, 4, 6, 9, 0, 1, 12, 23, 34,

2, 4, 6, 0, 1, 9, 12, 23, 34,

2, 4, 0, 1, 6, 9, 12, 23, 34,

2, 0, 1, 4, 6, 9, 12, 23, 34,

0, 1, 2, 4, 6, 9, 12, 23, 34,

0, 1, 2, 4, 6, 9, 12, 23, 34,

0, 1, 2, 4, 6, 9, 12, 23, 34,

0, 1, 2, 4, 6, 9, 12, 23, 34,
 */
