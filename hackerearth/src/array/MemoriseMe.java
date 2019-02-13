package array;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MemoriseMe {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int freq[] = new int[100000];
        int arr[] = new int[n];
        String input = br.readLine();
        String[] inputArray = input.split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(inputArray[i]);
            freq[arr[i]]++;
        }
        int q = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < q; i++) {
            int query = Integer.parseInt(br.readLine());
            if (freq[query] != 0) {
                sb.append(freq[query]);
            } else {
                sb.append("NOT PRESENT");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}

/*
In this Game , your team will be shown N numbers for few minutes . You will have to memorize these numbers.

Now, the questioner will ask you Q queries, in each query He will give you a number , and you have to tell him the total number of occurrences of that number in the array of numbers shown to your team . If the number is not present , then you will have to say “NOT PRESENT” (without quotes).

INPUT And OUTPUT

The first line of input will contain N, an integer, which is the total number of numbers shown to your team.

The second line of input contains N space separated integers .

The third line of input contains an integer Q , denoting the total number of integers.

The Next Q lines will contain an integer denoting an integer,  , for which you have to print the number of occurrences of that number () in those N numbers on a new line.

If the number  isn’t present then Print “NOT PRESENT” (without quotes) on a new line.

CONSTRAINTS
1 <= N <= 10^5
0 <= Bi <= 1000
1 <= Q <= 10^5


SAMPLE INPUT
6
1 1 1 2 2 0
6
1
2
1
0
3
4

SAMPLE OUTPUT
3
2
3
1
NOT PRESENT
NOT PRESENT

 */