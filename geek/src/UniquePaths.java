import java.io.IOException;
import java.util.Scanner;

public class UniquePaths {
    private static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(scan.nextLine());
        //scan.nextLine();
        while (n-- > 0) {
            int M = scan.nextInt();
            int N = scan.nextInt();
            //findUniquePaths(M, N);
            System.out.println(numberOfPaths(M, N));
            System.out.println(numberOfPathsRecursive(M, N));
        }
    }

    private static int findUniquePaths(int M, int N) {
        int i = 0, j = 0;
        int[][] matrix = new int[M][N];
        while (i < M || j < N) {
            if (i < M)
                matrix[i][j] = matrix[i + 1][j];
            else
                matrix[i][j] = matrix[i][j + 1];
        }
        return 0;
    }

    // Returns count of possible paths to reach
    // cell at row number m and column number n from
    //  the topmost leftmost cell (cell at 1, 1)
    static int numberOfPaths(int m, int n) {
        // Create a 2D table to store results
        // of subproblems
        int count[][] = new int[m][n];

        // Count of paths to reach any cell in
        // first column is 1
        for (int i = 0; i < m; i++)
            count[i][0] = 1;

        // Count of paths to reach any cell in
        // first column is 1
        for (int j = 0; j < n; j++)
            count[0][j] = 1;

        // Calculate count of paths for other
        // cells in bottom-up manner using
        // the recursive solution
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++)
                // By uncommenting the last part the
                // code calculates the total possible paths
                // if the diagonal Movements are allowed
                count[i][j] = count[i - 1][j] + count[i][j - 1]; //+ count[i-1][j-1];
        }
        return count[m - 1][n - 1];
    }

    // Returns count of possible paths to reach
    // cell at row number m and column number n
    // from the topmost leftmost cell (cell at 1, 1)
    static int numberOfPathsRecursive(int m, int n) {
        // If either given row number is first or
        // given column number is first
        if (m == 1 || n == 1)
            return 1;

        // If diagonal movements are allowed then
        // the last addition is required.
        return numberOfPaths(m - 1, n) + numberOfPaths(m, n - 1);
        // + numberOfPaths(m-1,n-1);
    }
}

/*
Given a M X N matrix with your initial position at top-left cell, find the number of possible unique paths to reach the bottom right cell of the matrix from the initial position.

Note: Possible moves can be either down or right at any point in time, i.e., we can move to matrix[i+1][j] or matrix[i][j+1] from matrix[i][j].

Input:
The first line contains an integer T, depicting total number of test cases.
Then following T lines contains an two integers A and B depicting the size of the grid.

Output:
Print the number of unique paths to reach bottom-right cell from the top-left cell.

Constraints:
1 ≤ T ≤ 30
1 ≤ M ≤ 15
1 ≤ N ≤ 15

Example:
Input
2
2 2
3 4
Output
2
10
 */