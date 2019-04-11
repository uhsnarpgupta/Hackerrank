package dynamicprogram;

public class CountPaths {
    static int n = 8;
    static int m = 8;

    public static void main(String[] args) {

        boolean[][] grid = new boolean[n][m];
        grid[1][2] = true;
        grid[2][5] = true;
        grid[3][4] = true;
        grid[4][6] = true;
        grid[5][7] = true;
        System.out.println(countPaths(grid, n, m));
    }

    static int countPaths(boolean[][] grid, int row, int col) {
        if (!validSquare(grid, row, col)) return 0;
        if (isAtEnd(grid, row, col)) return 1;
        return countPaths(grid, row + 1, col) + countPaths(grid, row, col + 1);
    }

    private static boolean isAtEnd(boolean[][] grid, int row, int col) {
        return row == n - 1 && col == m - 1;
    }

    private static boolean validSquare(boolean[][] grid, int row, int col) {
        return !grid[row - 1][col - 1];
    }

    static int countPaths(boolean[][] grid, int row, int col, int[][] paths) {
        if (!validSquare(grid, row, col)) return 0;
        if (isAtEnd(grid, row, col)) return 1;
        if (paths[row][col] == 0) {
            paths[row][col] = countPaths(grid, row + 1, col) + countPaths(grid, row, col + 1);
        }
        return paths[row][col];
    }
}
