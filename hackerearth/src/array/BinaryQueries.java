package array;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BinaryQueries {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        /*
        ---------------------------------------------------------------------------------------------------------------
        MY SOLUTION
        ---------------------------------------------------------------------------------------------------------------
        String[] input = br.readLine().split(" ");
        int size = 0, n = 0, q = 0;
        n = Integer.parseInt(input[0]);
        q = Integer.parseInt(input[1]);

        String[] in = br.readLine().split(" ");
        int inLen = in.length;
        int[] array = new int[inLen];
        while (size < inLen) {
            array[size] = Integer.parseInt(in[size]);
            size++;
        }
        int[] sum = array;

        while (q != 0) {
            String[] query = br.readLine().split(" ");
            int qLen = query.length;
            int[] qArray = new int[qLen];
            for (int l = 0; l < qLen; l++) {
                qArray[l] = Integer.parseInt(query[l]);
            }
            if (qArray[0] == 1) {
                array[qArray[1]-1] = array[qArray[1]-1] ^ 1;
                sum = array;

            } else {
                int u = 0;
                int [] temp = new int[qArray[2]];
                for (int m = qArray[1]-1; m <= qArray[2]-1; m++) {
                    temp[u++] = array[m];
                }
                sum = temp;
            }
            q--;
        }
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < sum.length; t++) {
            sb.append(sum[t]);
        }
        System.out.println(Integer.parseInt(sb.toString(), 2) % 2 == 0 ? "EVEN" : "ODD");

        ---------------------------------------------------------------------------------------------------------------
        */

        /*
        String line = br.readLine();
        String[] input1 = line.trim().split("\\s+");
        int size = Integer.parseInt(input1[0]);
        int qSize = Integer.parseInt(input1[1]);
        int[] a = new int[size];
        line = br.readLine();
        String[] input2 = line.trim().split("\\s+");
        for( int i = 0; i<size; i++)
        {
            a[i] = Integer.parseInt(input2[i]);
        }
        while(qSize-- > 0)
        {
            line = br.readLine();
            String[] input3 = line.trim().split("\\s+");
            if(Integer.parseInt(input3[0]) == 0)
            {
                int lastIndex = Integer.parseInt(input3[2])-1;
                if(a[lastIndex] == 0)
                    System.out.println("EVEN");
                else
                    System.out.println("ODD");
            }
            else
            {
                int index = Integer.parseInt(input3[1]);
                if(a[index-1] == 0)
                {
                    a[index-1] = 1;
                }
                else
                {
                    a[index-1] = 0;
                }
            }
        }
        */

        StringBuilder output = new StringBuilder();
        String[] input = br.readLine().split("\\s");
        int N = Integer.parseInt(input[0]);
        int Q = Integer.parseInt(input[1]);

        String arr = br.readLine();
        int[] A = new int[N];
        int len = arr.length();
        int i=0;
        for (int n = 0; n < len; n += 2)
        {
            A[i++] = arr.charAt(n) == '0' ? 0 : 1;
        }

        for (int q = 0; q < Q; q++)
        {
            String[] qry = br.readLine().split("\\s");
            int t = Integer.parseInt(qry[0]);
            if (t == 0)
            {
                int R = Integer.parseInt(qry[2]);
                output.append(A[R - 1] == 0 ? "EVEN" : "ODD");
                output.append('\n');
            }
            else
            {
                int x = Integer.parseInt(qry[1]);
                A[x - 1] = 1 - A[x - 1];
            }
        }

        System.out.println(output);
    }
}

/*
Some problems appear hard though they are very easy. Today Aakash is stuck in a range query problem. He has been given an array with only numbers 0 and 1. There are two types of queries -

0 L R : Check whether the number formed from the array elements L to R is even or odd and print EVEN or ODD respectively. Number formation is the binary number from the bits status in the array L to R

1 X : Flip the Xth bit in the array

Indexing is 1 based

Input
First line contains a number N and Q as input. Next line contains N space separated 0 or 1. Next Q lines contain description of each query

Output
Output for only query type 0 L R whether the number in range L to R is "EVEN" or "ODD" (without quotes).

Constraints
1≤ N ≤ 10^6
1≤ L ≤ R ≤ 10^6
1≤ Q ≤ 10^6

1≤ X ≤ N

Sample Input:
5 2
1 0 1 1 0
1 2
0 1 4

Output:
ODD
 */
