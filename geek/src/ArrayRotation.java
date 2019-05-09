public class ArrayRotation {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int d = 2;
        System.out.println(leftRotate(arr, d, arr.length));
    }


    private static int[] leftRotate(int arr[], int d, int n) {
        for (int i = 0; i < d; i++) {
            leftRotatebyOne(arr, n);
        }
        return arr;
    }

    private static void leftRotatebyOne(int arr[], int n) {
        int i, temp;
        temp = arr[0];
        for (i = 0; i < n - 1; i++)
            arr[i] = arr[i + 1];
        arr[i] = temp;
    }
}
/*
Time complexity : O(n * d)
Auxiliary Space : O(1)

METHOD 1 (Using temp array)

Input arr[] = [1, 2, 3, 4, 5, 6, 7], d = 2, n =7
1) Store d elements in a temp array
   temp[] = [1, 2]
2) Shift rest of the arr[]
   arr[] = [3, 4, 5, 6, 7, 6, 7]
3) Store back the d elements
   arr[] = [3, 4, 5, 6, 7, 1, 2]


INPUT:
1 2 3 4 5 6 7

OUTPUT:
3 4 5 6 7 1 2
 */