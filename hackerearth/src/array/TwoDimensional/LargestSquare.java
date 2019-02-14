package array.TwoDimensional;

public class LargestSquare {
    public static void main(String[] args) {
    }
}
/*
You are given N points on the infinite 2-D plane. You need to find 4 such points among these N points, such that,
they form a square with positive side length and whose sides are parallel to the x and y axis.

If there are multiple choices of 4 such points, choose those which form the square of largest side. If there are still
multiple choices of 4 such points, choose those 4 points in which the bottom left point has a lower y co-ordinate.
If there are still multiple choices of 4 such points, choose those 4 points in which the bottom left point has a lower
x co-ordinate.

Input:

First line contains a single integer N, denoting the number of points on the 2-D plane. Each of the next N lines contain
2 space separated integers X and Y, these denote the x and y co-ordinates of the point.

Output:

Print 2 space separated integers, the co-ordinates of the bottom left point of the square found. If there are no
squares present, print -1.

Constraints:
1 ≤ N ≤ 2000
1 ≤ X,Y ≤ 10^9

SAMPLE INPUT:
6
1 1
3 1
5 1
1 3
3 3
5 3

SAMPLe OUTPUT:
1 1
 */