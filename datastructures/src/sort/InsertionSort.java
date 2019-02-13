package sort;

public class InsertionSort {
    private static int[] sort(int[] intArray) {
        for (int firstUnsortedIndex = 1; firstUnsortedIndex < intArray.length; firstUnsortedIndex++) {
            int newElement = intArray[firstUnsortedIndex];
            int i;
            for (i = firstUnsortedIndex; i > 0 && intArray[i - 1] > newElement; i--) {
                intArray[i] = intArray[i - 1];
            }
            intArray[i] = newElement;
        }
        return intArray;
    }

    public static void main(String[] args) {
        int[] intArray = {20, 35, -15, 7, 55, 1, -22};
        for (int i : sort(intArray)) {
            System.out.print(i + " ");
        }
    }
}

/*
Insertion sort a quadratic running time (i.e., O(n2)).
The average case is also quadratic, which makes insertion sort impractical for sorting large arrays.
 */