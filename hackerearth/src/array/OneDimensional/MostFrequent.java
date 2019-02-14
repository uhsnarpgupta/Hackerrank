package array.OneDimensional;

import java.util.*;
import java.util.stream.Collectors;

public class MostFrequent {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        int N = scan.nextInt();
        //int[] A = new int[10001];
        /*while (N != 0) {
            A[scan.nextInt()]++;
            N--;
        }
        List<Integer> list = Arrays.stream(A).boxed().collect(Collectors.toList());
        List<Integer> newList = list.stream().filter(V -> V != 0).collect(Collectors.toList());
        System.out.print(newList.get(newList.size()));*/

        HashMap<String, Integer> dMap = new HashMap<>();
        while (N != 0) {
            String key = scan.next();
            if (dMap.containsKey(key)) {
                dMap.put(key, dMap.get(key) + 1);
            } else {
                dMap.put(key, 1);
            }
            N--;
        }
        Integer max = dMap.entrySet()
                .stream()
                .max((entry1, entry2) -> entry1.getValue() > entry2.getValue() ? 1 : -1)
                .get()
                .getValue();

        List listOfMax = dMap.entrySet()
                .stream()
                .filter(entry -> entry.getValue() == max)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
        Collections.sort(listOfMax);

        System.out.println(listOfMax.get(0));
        /*System.out.println(Collections.max(dMap.entrySet(),
                Map.Entry.comparingByValue()).getKey());*/
    }
}
