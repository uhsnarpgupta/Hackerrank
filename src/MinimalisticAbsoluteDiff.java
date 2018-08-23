import java.net.Inet4Address;
import java.util.Arrays;
import java.util.Scanner;

public class MinimalisticAbsoluteDiff {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int num = scanner.nextInt();
        int [] arr = new int[num];
        for(int i = 0; i < num; i++){
            arr[i] = scanner.nextInt();
        }
        System.out.println(minimumAbsoluteDifference(arr));
    }
    static int minimumAbsoluteDifference(int[] arr) {
        Arrays.sort(arr);
        int min = Integer.MAX_VALUE;
        for(int k = 1; k < arr.length ; k++){
            min = Math.min(min, Math.abs(arr[k] - arr[k-1]));
        }
        return min;
    }
}
