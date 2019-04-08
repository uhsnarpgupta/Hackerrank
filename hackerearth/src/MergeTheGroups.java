import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class MergeTheGroups {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());

        String[] array = br.readLine().split(" ");
        int[] intArr = new int[n];
        Set<Long>[] set = new Set[n];

        for (int i = 0; i < n; i++) {
            intArr[i] = Integer.parseInt(array[i]);
            set[i] = new HashSet<>();
            set[i].add(intArr[i]);
        }


        int q = Integer.parseInt(br.readLine());
        while (q-- > 0) {
            String[] input = br.readLine().split(" ");
            switch (Integer.parseInt(input[0])) {
                case 1:
                    int a = Integer.parseInt(input[1]);
                    int b = Integer.parseInt(input[2]);
                    set[a - 1].addAll(set[b - 1]);
                    set[b - 1].addAll(set[a - 1]);
                    break;
                case 2:
                    int p = Integer.parseInt(input[1]);
                    Set<Integer> lt = set[p - 1];
                    int max = Integer.MIN_VALUE;
                    int min = Integer.MAX_VALUE;

                    max = lt.stream()
                            .mapToInt(v -> v)
                            .max().getAsInt();

                    min = lt.stream()
                            .mapToInt(v -> v)
                            .min().getAsInt();

                    System.out.println(Math.abs(max - min));
                    break;
                default:
                    break;

            }

        }

    }
}
/*
Merge the groups
You are given an array  of  elements. Each element belongs to its own group initially.

You need to process the following two types of queries:

     - The array elements which are  at positions   and  in the array    merge their group.
   - Print the maximum absolute difference of the array values that belong to the group of  element of the array.

Note: It is possible that the elements  and  in the query of type  already be in the same group. You need to simply ignore that query.

Input
The first line contains an integer  as input that denotes the total number of elements of the array. The next line contains space separated integers that denote the elements of that array.
The next line of input contains an integer  that denotes the total number of queries.
The next  lines contain description of each query.
The description of each query begins with an integer  which is 1 for 1st type of queries and 2 for second type of queries.

Output
For each query of type , print the answer in a new line.

Constraints:

Subtask 1: 50 Points

1 <= N <= 10^3
|A[i]| <= 10^3
1 <= Q <= 10^3
1 <= X,Y <=N

Subtask 2: 50 Points

1 <= N <= 10^6
|A[i]| <= 10^9
1 <= Q <= 5 * 10^5
1 <= X,Y <=N

Sample Input
4
5 3 2 9
4
2 4
1 1 4
2 4
2 3

Sample Output
0
4
0
 */