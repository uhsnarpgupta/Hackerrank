package javabase;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class JavaHashSet {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        String[] pair_left = new String[t];
        String[] pair_right = new String[t];
        Set<String> setLeft = new HashSet<>(t);
        Set<String> setRight = new HashSet<>(t);

        for (int i = 0; i < t; i++) {
            pair_left[i] = s.next();
            setLeft.add(pair_left[i]);
            pair_right[i] = s.next();
            setRight.add(pair_right[i]);
        }

        s.close();
        Set<String> set = new HashSet<>(t);
        for (int i = 0; i < t; i++) {
            set.add(pair_left[i] + " " + pair_right[i]);
            System.out.println(set.size());
        }
    }
}
