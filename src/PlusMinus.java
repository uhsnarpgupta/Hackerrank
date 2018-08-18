import java.util.Scanner;

public class PlusMinus {
    public static void main(String [] args){
        Scanner scan = new Scanner(System.in);
        int length = scan.nextInt();
        int [] arr = new int[length];
        for(int i = 0; i < length; i++) {
            arr[i] = scan.nextInt();
        }

        plusMinus(arr);
    }

    static void plusMinus(int[] arr) {
        int positiveCount = 0;
        int negativeCount = 0;
        int zeroCount = 0;
        for(int i = 0; i < arr.length; i++){
            if (arr[i] != 0) {
                if (arr[i] > 0) {
                    positiveCount++;
                } else {
                    negativeCount++;
                }
            } else {
                zeroCount++;
            }
        }
        System.out.println(positiveCount);
        System.out.println(negativeCount);
        System.out.println(zeroCount);

        System.out.println((double)positiveCount/arr.length);
        System.out.println((double)negativeCount/arr.length);
        System.out.println((double)zeroCount/arr.length);
    }
}
