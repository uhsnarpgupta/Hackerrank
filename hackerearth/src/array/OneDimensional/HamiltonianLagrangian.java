package array.OneDimensional;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HamiltonianLagrangian {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().trim().split("\\s");
        int[] array = new int[N];
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(input[i]);
        }

        for(int i = 0; i < N ; i++){
            boolean flag = true;
            for(int j = i + 1 ; j < N ; j++)
            {
                if(array[j] > array[i])
                {
                    flag = false;
                    break;
                }
            }
            if(flag){
                System.out.print(array[i] + " ");
            }
        }
    }
}

/*
Students have become secret admirers of SEGP. They find the course exciting and the professors amusing. After a superb Mid Semester examination its now time for the results. The TAs have released the marks of students in the form of an array, where arr[i] represents the marks of the ith student.

Since you are a curious kid, you want to find all the marks that are not smaller than those on its right side in the array.

Input Format
The first line of input will contain a single integer n denoting the number of students.
The next line will contain n space separated integers representing the marks of students.

Output Format
Output all the integers separated in the array from left to right that are not smaller than those on its right side.

SAMPLE INPUT:
6
16 17 4 3 5 2

SAMPLE OUTPUR:
17 5 2
 */
