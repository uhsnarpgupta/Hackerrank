import java.util.*;
import java.util.stream.Collectors;

public class EnemyPair {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3};
        int[] arr2 = {3, 3, 1};

        int[] arr3 = {1, 2, 3, 4};
        int[] arr4 = {3, 3, 1, 3};
        int[] arr5 = {1, 2, 3, 4, 5};
        int[] arr6 = {3, 5, 1, 3, 1};

        int[] arr7 = {1, 2};
        int[] arr8 = {3, 4};

        int[] arr9 = {2, 1, 2};
        int[] arr10 = {2, 3, 5};

        findEnemyPair(5, arr9, arr10);

        //findEnemyPair(arr3, arr4);
        //findEnemyPair(arr7, arr8);
    }

    private static int findEnemyPair(int m, int[] arr1, int[] arr2) {
        int n = arr1.length;
        int count = 0;
        //Map<Integer, Set<Integer>> map = new HashMap<>();

        Set<Integer> it = new HashSet<>();
        for (int j = 1; j <= m; j++) {
            it.add(j);
        }
        /*for(int j = 0; j < arr2.length; j++){
            it.add(arr2[j]);
        }*/
        Set<Integer> set = Arrays.stream(arr1).boxed().collect(Collectors.toSet());
        System.out.println("<------------POWERSET------------>");
        powerSet(it).forEach(st -> {
            st.forEach(System.out::print);
            System.out.println();
        });
        System.out.println("<------------POWERSET------------>");

        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Set<Integer>> mp = new HashMap<>();
        for (int i = 0; i < arr1.length; i++) {
            map.put(arr1[i], arr2[i]);
        }
        Set<Set<Integer>> newSet = new HashSet<>();
        moveon:
        for (Set<Integer> st : powerSet(set)) {
            Set<Integer> testSet = st;
            Set<Integer> addSet = null;

            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (testSet.contains(entry.getKey()) && testSet.contains(entry.getValue())) {
                    //addSet = null;
                    continue moveon;
                } else {
                    addSet = st;
                }
            }
            if (addSet != null) {
                newSet.add(addSet);
            }
        }

        /*powerSet(set).forEach(st -> {
            //st.contains(map.get(0)) && st.contains()
            Set<Integer> testSet = st;
            Set<Integer> addSet = null;
            for(Map.Entry<Integer,Integer> entry : map.entrySet()){
                if (testSet.contains(entry.getKey()) && testSet.contains(entry.getValue())) {
                    break;
                }
                else{
                    addSet = st;
                }
            }
            map.forEach((k, v) -> {
                if (testSet.contains(k) && testSet.contains(v)) {
                }
                else{
                    addSet = st;
                }
            });
            if(addSet!=null)newSet.add(addSet);
            *//*st.forEach(i -> {
                //if()
            });*//*
        });*/
        System.out.println("<------------NEWSET------------>");

        newSet.forEach(st -> {
            st.forEach(System.out::print);
            System.out.println();
        });
        System.out.println("<------------NEWSET------------>");

        System.out.println("Size: " + (newSet.size() - 1));

        /*Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        */
        /*for (Map.Entry<Integer, Set<Integer>> e : map.entrySet()) {
            Set<Integer> s = e.getValue();
            s.forEach(System.out::print);
            System.out.println();
        }*/
        HashMap<Integer, Integer> set1 = new HashMap<>();
        HashMap<Integer, Integer> set2 = new HashMap<>();
        HashMap<Integer, FoePair> mapped = new HashMap<>();


        Set<FoePair> pairs = new HashSet<>();
        for (int i = 0; i < arr1.length; i++) {
            set1.put(arr1[i], arr2[i]);
        }

        for (Integer s : set1.keySet()) {
            if (set2.containsKey(s))
                pairs.add(new FoePair(set1.get(s), set2.get(s)));
            else
                pairs.add(new FoePair(set1.get(s), null));
        }
        return 0;
    }

    public static Set<Set<Integer>> powerSet(Set<Integer> originalSet) {
        Set<Set<Integer>> sets = new HashSet<>();
        if (originalSet.isEmpty()) {
            sets.add(new HashSet<>());
            return sets;
        }
        List<Integer> list = new ArrayList<>(originalSet);
        Integer head = list.get(0);
        Set<Integer> rest = new HashSet<>(list.subList(1, list.size()));
        for (Set<Integer> set : powerSet(rest)) {
            Set<Integer> newSet = new HashSet<>();
            newSet.add(head);
            newSet.addAll(set);
            sets.add(newSet);
            sets.add(set);
        }
        return sets;
    }
}

class FoePair {
    Integer str1;
    Integer str2;

    FoePair(Integer s1, Integer s2) {
        str1 = s1;
        str2 = s2;
    }
}

/*
There are n animals in a straight line. Each animal is identified by a unique number
from a to n in order. There are m pairs(a[i], b[i] which imply that animals a[i] and
b[i] are enemies and should not kept in the same cabin. Pi is great at problem-solving
and came up with challenges count the number of different groups that do not contain
any pair such that they are enemies. A group is defined as an interval [x,y] such that
all animals in the range from x to y from a group. Determine the number of groups that can be formed according to Pi's challenge.

For example:
given n = 3 pairs of enemies, a= [1,2,3] and b = [3,3,1], animal 1 is the enemies of
animal 3, and animal 3 is the enemies of animal 1 and 2 because 3 is the enemies of
both 1 and 2 it must be in its own cabin, Animal 1 and 2 can be formed together or separately.
There are 4 possible groupings meeting the constraints [1,2],[1],[2],[3]. Note that the
intervals are along the original lines of animals numbered consecutively from 1 to n.
i.e. [1,2,3] in this case. They cannot be reordered.

INPUT:
4
2
1
2
2
3
4
 */

