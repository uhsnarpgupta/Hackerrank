public class ArrayRotation {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int d = 2;
        System.out.println(rotate(arr, d, arr.length));
    }

    private static int[] rotate(int[] arr, int d, int n) {
        int[] temp = new int[d];
        for (int i = 0; i < d; i++) {
            temp[i] = arr[i];
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[(i + d) * n];
        }
        return arr;
    }
}
