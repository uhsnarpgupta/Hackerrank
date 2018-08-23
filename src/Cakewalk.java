import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Cakewalk {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        int calorie[] = new int[n];
        for (int i = 0; i < n; i++) {
            calorie[i] = scanner.nextInt();
        }
        System.out.println(marcsCakewalk(calorie));
    }

    static long marcsCakewalk(int[] calorie) {
        int [] p = calorie;
        Arrays.sort(p);
        long sum = 0;
        for(int k = p.length - 1; k >=0; k--){
            sum += p[k] * Math.pow(2,p.length-k-1);
        }
        return sum;
    }
}
