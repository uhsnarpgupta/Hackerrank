package puzzle;

import java.util.Scanner;

public class GhostLegs {
    static Scanner in = new Scanner(System.in);


/*
    public static void main(String args[]) {
        int W = in.nextInt();
        int H = in.nextInt();
        if (in.hasNextLine()) {
            in.nextLine();
        }
        char[] start = new char[W / 2];

        char[][] mArray = new char[W + 1][H + 1];
        int k = 0;
        for (int i = 0; i < H; i++) {
            String line = in.nextLine();
            mArray[i] = line.toCharArray();

        }
        int p = 0;
        int q = 0;
       */
/* for (int i = 0, j = 0; i < H && j < W; i++, j++) {
            char c = mArray[i][j];

        }*//*

        int l = -1;
        char m = ' ';
        q = 3;
        do {
            while (q < H) {
                char c = mArray[p][q];
                if (c == ' ') {
                    if (q - 4 >= 0 && mArray[p][q - 2] == '-') {
                        q -= 4;
                        m = mArray[H - 1][q];
                    }
                    p++;
                } else if (c == '-') {
                    q += 2;
                    if (q >= H) {
                        q -= 4;
                        p++;
                    }
                    m = mArray[H - 1][q];
                } else {
                    q++;
                }
            }
            p++;
            q -= 2;
        } while (p < W);

        System.out.println(m);
        // Write an action using System.out.println()
        // To debug: System.err.println("Debug messages...");
    }
*/

    public static void main(String[] args) {
        String[] line = in.nextLine().split(" ");
        int W = Integer.parseInt(line[0]);
        int H = Integer.parseInt(line[1]);

        //Read top labels and create start indices.
        String[] T = in.nextLine().split("  ");
        int[] Ti = new int[T.length];

        for (int i = 0; i < Ti.length; i++) {
            Ti[i] = i;
        }

        //Read diagram lines.
        for (int i = 0; i < H - 2; i++) {
            line = in.nextLine().split("\\|");

            //Search for horizontal lines.
            for (int j = 0; j < line.length; j++) {
                if (line[j].equals("--")) {
                    //Check where the horizontal line is and change indices.
                    for (int k = 0; k < Ti.length; k++) {
                        if (Ti[k] == j - 1) {
                            Ti[k] += 1;
                        } else if (Ti[k] == j) {
                            Ti[k] -= 1;
                        }
                    }
                }
            }
        }

        //Read bottom labels.
        String[] B = in.nextLine().split("  ");

        //Print result.
        for (int i = 0; i < T.length; i++) {
            System.out.println(T[i] + B[Ti[i]]);
        }
    }
}

/*
INPUT:

7 7
A  B  C
|  |  |
|--|  |
|  |--|
|  |--|
|  |  |
1  2  3

OUTPUT:

A2
B1
C3
 */
