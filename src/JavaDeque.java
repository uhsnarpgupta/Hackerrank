import java.util.*;

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
