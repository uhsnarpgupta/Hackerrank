package javabase;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Scanner;

public class JavaDeque {
    /*public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Deque deque = new ArrayDeque<>();
        ArrayList<Integer> userList = new ArrayList<>();

        int n = in.nextInt();
        int m = in.nextInt();

        for (int i = 0; i < n; i++) {
            int num = in.nextInt();
            deque.push(num);
            userList.add(num);
        }

        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < deque.size(); i++) {
            for (int j = 0; j <= deque.size(); j++) {
                ArrayList<Integer> list = new ArrayList<>();
                for (int k = i; k < j; k++) {
                    list.add(userList.get(k));
                }
                lists.add(list);
            }
        }

        ArrayList<Integer> listSet = new ArrayList<>();

        lists.forEach(lt -> {

            Set<Integer> set = new HashSet<>();
            lt.forEach(item -> set.add(item));
            listSet.add(set.size());
            //lt.forEach(System.out::print);
            //System.out.println();
        });
        int largest = listSet.get(0);
        for (int p = 1; p < listSet.size(); p++) {
            largest = listSet.get(p) > largest ? listSet.get(p) : largest;
        }
        System.out.println(largest);
    }*/

    public static void main(String [] args){
        Scanner in = new Scanner(System.in);
        Deque<Integer> deque = new ArrayDeque<>();
        HashSet<Integer> set = new HashSet<>();

        int n = in.nextInt();
        int m = in.nextInt();
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            int input = in.nextInt();

            deque.add(input);
            set.add(input);

            if (deque.size() == m) {
                if (set.size() > max) max = set.size();
                int first = deque.remove();
                if (!deque.contains(first)) set.remove(first);
            }
        }

        System.out.println(max);
    }
}

/*
In computer science, a double-ended queue (dequeue, often abbreviated to deque, pronounced deck) is an abstract data type that generalizes a queue, for which elements can be added to or removed from either the front (head) or back (tail).

Deque interfaces can be implemented using various types of collections such as LinkedList or ArrayDeque classes. For example, deque can be declared as:

Deque deque = new LinkedList<>();
or
Deque deque = new ArrayDeque<>();
You can find more details about Deque here.

In this problem, you are given  integers. You need to find the maximum number of unique integers among all the possible contiguous subarrays of size .

Note: Time limit is  second for this problem.

Input Format

The first line of input contains two integers  and : representing the total number of integers and the size of the subarray, respectively. The next line contains  space separated integers.

Constraints




The numbers in the array will range between .

Output Format

Print the maximum number of unique integers among all possible contiguous subarrays of size .
 */