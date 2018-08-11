import java.util.Scanner;

public class SubArray {
    static Scanner scan= new Scanner(System.in);
    public static void main(String[] args) {
        int n = scan.nextInt();
        int [] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = scan.nextInt();
        }

        int count = 0;

        for(int i = 0; i < n; i++){
            for(int j = i; j <= n; j++){
                int sum = 0;
                for (int k = i ; k < j; k++) {
                    System.out.print(arr[k] + " ");
                    sum += arr[k];
                }
                if(sum<0){
                    count++;
                }
                System.out.println();
            }
        }
        System.out.println(count);
    }
}
