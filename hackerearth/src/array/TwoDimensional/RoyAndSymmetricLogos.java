package array.TwoDimensional;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RoyAndSymmetricLogos {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCaseCount = Integer.parseInt(br.readLine());

        while (testCaseCount-- > 0) {
            int size = Integer.parseInt(br.readLine());
            int[][] input = new int[size][size];
            for (int i = 0; i < size; i++) {
                String line1 = br.readLine().trim();
                for (int j = 0; j < size; j++) {
                    input[i][j] = Integer.parseInt(line1.charAt(j) + "", 10);
                }
            }
            boolean valid = true;
            for (int p = 0; p < size; p++) {
                for (int q = 0; q < size; q++) {
                    int x = size - (p + 1);
                    int y = size - (q + 1);
                    if (input[p][q] != input[x][q] || input[p][q] != input[p][y]) {
                        valid = false;
                        break;
                    }
                }
            }
            System.out.println(valid ? "YES" : "NO");
        }
    }
}

/*
Roy likes Symmetric Logos.

How to check whether a logo is symmetric?
Align the center of logo with the origin of Cartesian plane. Now if the colored pixels of the logo are symmetric about both X-axis and Y-axis, then the logo is symmetric.

You are given a binary matrix of size N x N which represents the pixels of a logo.
1 indicates that the pixel is colored and 0 indicates no color.

For instance: Take a 5x5 matrix as follows:

01110
01010
10001
01010
01110
Graphically it is represented as follows:

enter image description here

Observe that it is symmetric about both X-axis and Y-axis.

Let's take another example of 5x5 matrix:

00100
01010
10001
01010
01110
Graphically it is represented as follows:

enter image description here

Now this logo is symmetric about Y-axis but it is not symmetric about X-axis.

Your task is to output YES if the logo is symmetric else output NO.

Input:
First line contains T - number of test cases.
T test cases follow.
First line of each test case contains the N - size of matrix.
Next N lines contains binary strings of length N.

Output:
Print YES or NO in a new line for each test case

Constraints:
1 ≤ T ≤ 10
2 ≤ N ≤ 32

SAMPLE INPUT:
5
2
11
11
4
0101
0110
0110
0101
4
1001
0000
0000
1001
5
01110
01010
10001
01010
01110
5
00100
01010
10001
01010
01110

SAMPLE OUTPUT:
YES
NO
YES
YES
NO
 */