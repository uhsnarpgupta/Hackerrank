package array.OneDimensional;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MonkWelcome {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] input1 = br.readLine().trim().split("\\s");
        String[] input2 = br.readLine().trim().split("\\s");
        Integer[] sum = new Integer[N];
        for (int i = 0; i < N; i++) {
            sum[i] = Integer.parseInt(input1[i]) + Integer.parseInt(input2[i]);
            System.out.print(sum[i] + " ");
        }

        List<Integer> list = new ArrayList<>();
        list.get(0);

    }
}

/*
Having a good previous year, Monk is back to teach algorithms and data structures. This year he welcomes the learners
with a problem which he calls "Welcome Problem". The problem gives you two arrays A and B (each array of size N) and
asks to print new array C such that:
 ;
Now, Monk will proceed further when you solve this one. So, go on and solve it :)

Input:
First line consists of an integer N, denoting the size of A and B.
Next line consists of N space separated integers denoting the array A.
Next line consists of N space separated integers denoting the array B.

Output:
Print N space separated integers denoting the array C.

Sample Input:
5
1 2 3 4 5
4 5 3 2 10

Sample Output:
5 7 6 6 15
 */
