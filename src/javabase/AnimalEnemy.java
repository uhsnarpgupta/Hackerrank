package javabase;

import java.util.*;

public class AnimalEnemy {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3};
        int[] arr2 = {3, 3, 1};

        int[] arr3 = {1, 2, 3, 4};
        int[] arr4 = {3, 3, 1, 3};
        int[] arr5 = {1, 2, 3, 4, 5};
        int[] arr6 = {3, 5, 1, 3, 1};

        int[] arr7 = {1, 2};
        int[] arr8 = {3, 4};

        System.out.println(findFriendGroups(arr1, arr2));
        System.out.println(findFriendGroups(arr3, arr4));
        System.out.println(findFriendGroups(arr5, arr6));
        System.out.println(findFriendGroups(arr7, arr8));

    }

    private static int findFriendGroups(int[] arr1, int[] arr2) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < arr1.length; i++) {
            set.add(arr1[i]);
        }
        for (int i = 0; i < arr2.length; i++) {
            set.add(arr2[i]);
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr1.length; i++) {
            map.put(arr1[i], arr2[i]);
        }
        Set<Set<Integer>> finalSet = new HashSet<>();
        nextSet:
        for (Set<Integer> iSet : powerSet(set)) {
            Set<Integer> tempSet = null;
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (iSet.contains(entry.getKey()) && iSet.contains(entry.getValue())) {
                    continue nextSet;
                } else {
                    tempSet = iSet;
                }
            }
            if (tempSet != null) {
                finalSet.add(tempSet);
            }
        }

        return finalSet.size() - 1;
    }

    private static Set<Set<Integer>> powerSet(Set<Integer> inputSet) {
        Set<Set<Integer>> powerSet = new HashSet<>();
        if (inputSet.isEmpty()) {
            powerSet.add(new HashSet<>());
            return powerSet;
        }
        ArrayList<Integer> list = new ArrayList<>(inputSet);
        Integer head = list.get(0);
        Set<Integer> rest = new HashSet<>(list.subList(1, list.size()));

        for (Set<Integer> set : powerSet(rest)) {
            Set<Integer> newSet = new HashSet<>();
            newSet.add(head);
            newSet.addAll(set);
            powerSet.add(newSet);
            powerSet.add(set);
        }

        return powerSet;
    }
}
