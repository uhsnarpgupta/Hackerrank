package array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class HelpJarvis {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        outer:
        while (n-- > 0) {
            String input = br.readLine();
            int len = input.length();
            int array[] = new int[len];
            for (int i = 0; i < len; i++) {
                array[i] = Integer.parseInt(input.charAt(i) + "");
            }
            Arrays.sort(array);
            for (int i = 1; i < len; i++) {
                if (array[i] - 1 != array[i - 1]) {
                    System.out.println("NO");
                    continue outer;
                }
            }
            System.out.println("YES");
        }
    }
}

/*
Tony Stark is in the planet Titan crying for his friends are turning into ashes, and on earth mayhem has ensued since a lot of people are turning into ashes too. Some trains have been derailed in such a way that a lot of its coaches are thrown off in a random disarray like coach 3, 4 and 5 are thrown off in one place, coach 2 and 6 are thrown off in another place, etc.

S.H.I.E.L.D calls upon Hulk and jarvis to help them collect and connect some the thrown off coaches of those trains, but a train can only move if the collected coaches number are in a continuous manner (need not to be in order) ,like 1234, 2314, 4123, 2341  etc.

Help Jarvis write a program for hulk to decide whether collected coaches will move or not.

Input Format:

First ilne contains one number t , denoting the number of test cases.

Next t lines contain sequence of the collected coach numbers (n)

Output Format:

YES or NO (In capitals)

Input constraints:

1 <= t <= 10000

1<= n <= 1000000

SAMPLE INPUT:
6
2415
4231
4125
5142
4132
2143

SAMPLE OUTPUT:
NO
YES
NO
NO
YES
YES
 */