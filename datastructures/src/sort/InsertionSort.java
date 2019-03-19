package sort;

public class InsertionSort {
    private static int[] sort(int[] intArray) {
        for (int firstUnsortedIndex = 1; firstUnsortedIndex < intArray.length; firstUnsortedIndex++) {
            int newElement = intArray[firstUnsortedIndex];
            /*int i;
            for (i = firstUnsortedIndex; i > 0 && intArray[i - 1] > newElement; i--) {
                intArray[i] = intArray[i - 1];
            }
            intArray[i] = newElement;
            */
            int i = firstUnsortedIndex - 1;
            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while (i >= 0 && intArray[i] > newElement) {
                intArray[i + 1] = intArray[i];
                i--;
            }
            intArray[i + 1] = newElement;
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