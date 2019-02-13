package array;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MostFrequent {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        int N = scan.nextInt();
        int[] A = new int[10001];
        while (N != 0) {
            A[scan.nextInt()]++;
            N--;
        }
        List<Integer> list = Arrays.stream(A).boxed().collect(Collectors.toList());
        List<Integer> newList = list.stream().filter(V -> V != 0).collect(Collectors.toList());
        System.out.print(newList.get(newList.size()));
    }
}
