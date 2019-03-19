public class MinimumSweeps {
    static int count = 0;

    public static void main(String[] args) {
        int[] arr = {4, 3, 1, 2};
        int[] arr1 = {1, 3, 5, 2, 4, 6, 7};
        bubbleSort(arr1);
        System.out.println(minimumSwaps(arr1));

    }

    // Complete the minimumSwaps function below.
    static int minimumSwaps(int[] arr) {
        return count;
    }

    static int[] bubbleSort(int[] arr) {
        for (int i = arr.length - 1; i >= 0; i--) {
            int largest = i;
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[largest]) {
                    largest = j;
                }
            }
            if (arr[largest] > arr[i]) {
                arr = swap(arr, largest, i);
                count++;
            }
        }
        return arr;
    }

    private static int[] swap(int[] arr, int largest, int i) {
        int temp = arr[i];
        arr[i] = arr[largest];
        arr[largest] = temp;
        return arr;
    }
}

/*
You are given an unordered array consisting of consecutive integers  [1, 2, 3, ..., n] without any duplicates. You are allowed to swap any two elements. You need to find the minimum number of swaps required to sort the array in ascending order.

For example, given the array arr we perform the following steps:

i   arr                         swap (indices)
0   [7, 1, 3, 2, 4, 5, 6]   swap (0,3)
1   [2, 1, 3, 7, 4, 5, 6]   swap (0,1)
2   [1, 2, 3, 7, 4, 5, 6]   swap (3,4)
3   [1, 2, 3, 4, 7, 5, 6]   swap (4,5)
4   [1, 2, 3, 4, 5, 7, 6]   swap (5,6)
5   [1, 2, 3, 4, 5, 6, 7]
It took  swaps to sort the array.

Function Description

Complete the function minimumSwaps in the editor below. It must return an integer representing the minimum number of swaps to sort the array.

minimumSwaps has the following parameter(s):

arr: an unordered array of integers
Input Format

The first line contains an integer, , the size of .
The second line contains  space-separated integers .

Constraints
1 <= n <= 10^5
1 <= arr[i] <= n

Output Format

Return the minimum number of swaps to sort the given array.

Sample Input 0

4
4 3 1 2
Sample Output 0

3
Explanation 0

Given array arr:[4,3,1,2]
After swapping (0,2) we get [1,3,4,2]
After swapping (1,2) we get [1,4,3,2]
After swapping (1,3) we get [1,2,3,4]
So, we need a minimum of 3 swaps to sort the array in ascending order

Sample Input 1

5
2 3 4 1 5

Sample Output 1

3
Explanation 1

Given array arr:[2,3,4,1,5]
After swapping (2,3) we get [2,3,1,4,5]
After swapping (0,1) we get [3,2,1,4,5]
After swapping (0,2) we get [1,2,3,4,5]
So, we need a minimum of 3 swaps to sort the array in ascending order
 */