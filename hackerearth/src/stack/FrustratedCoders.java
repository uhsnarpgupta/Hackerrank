package stack;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class FrustratedCoders {
    static Scanner s = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int n = s.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = s.nextInt();
        }
        Arrays.sort(arr);
        int result = 0;
        int currentKiller = n - 1;
        for (int i = n - 1; i >= 0; i--) {
            if (arr[currentKiller] > arr[i]) {
                currentKiller--;
            } else {
                result += arr[i];
            }
        }
        System.out.println(result);
    }
    //List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
    //System.out.println(list.stream().filter(item -> item != null).mapToInt(l -> l).sum());
}

/*
There are N frustrated coders standing in a circle with a gun in their hands. Each coder has a skill value
S[ i ] and he can only kill those coders that have strictly less skill than him. One more thing, all the guns
have only 1 bullet. This roulette can take place in any random order. Fortunately, you have the time stone
(haaan wo harre wala) and you can see all possible outcomes of this scenario. Find the outcome where the total sum
of the remaining coder's skill is minimum. Print this sum.

INPUT
The first line contains N the no. of coders
The next line contains N  elements where the ith element is theS[ i ] of ith coder.

OUTPUT
Print a single line containing the minimum sum

CONSTRAINTS
1<= N <= 1000000
1<=S[ i ]<=1000

SAMPLE INPUT:
6
1 7 2 2 4 4

SAMPLe OUTPUT:
11
 */
