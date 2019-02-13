package array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MicroArrayUpdate {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t != 0) {
            String[] nk = br.readLine().trim().split("\\s");
            int N = Integer.parseInt(nk[0]);
            int K = Integer.parseInt(nk[1]);

            String[] input = br.readLine().trim().split("\\s");
            Integer[] array = new Integer[N];

            for (int i = 0; i < N; i++) {
                array[i] = Integer.parseInt(input[i]);
            }

            List<Integer> list = Arrays.asList(array);
            Collections.sort(list);
            System.out.println(list.get(0) < K ? K - list.get(0) : 0);
            t--;
        }
    }
}

/*
Micro purchased an array A having N integer values. After playing it for a while, he got bored of it and decided to update value of its element. In one second he can increase value of each array element by 1. He wants each array element's value to become greater than or equal to K. Please help Micro to find out the minimum amount of time it will take, for him to do so.

Input:
First line consists of a single integer, T, denoting the number of test cases.
First line of each test case consists of two space separated integers denoting N and K.
Second line of each test case consists of N space separated integers denoting the array A.

Output:
For each test case, print the minimum time in which all array elements will become greater than or equal to K. Print a new line after each test case.

SAMPLE INPUT
2
3 4
1 2 5
3 2
2 5 5

SAMPLE OUTPUT
3
0
 */