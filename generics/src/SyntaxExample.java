import java.util.ArrayList;

public class SyntaxExample {
    public static void main(String[] args) {
        {
//        ArrayList a = new ArrayList();
//        a.add(15);
//        a.add("15");
//        Integer b = (Integer)a.get(1);
            ArrayList<Integer> a = new ArrayList<>();
            a.add(15);
            //a.add("15");
            Integer b = a.get(0);
            Pair<Integer, String> p1 = new OrderedPair<>(1, "apple");
            Pair<String, Integer> p2 = new OrderedPair<>("banana", 2);
            print(p1.getKey(), p1.getValue());
            print(p2.getKey(), p2.getValue());
            print("Happy", "Birthday");

            System.out.println("Sari".compareTo("Ram"));
            System.out.println("Hari".compareTo("Ram"));
        }
    }

    public static <K, V> void print(K key, V value) {
        System.out.println("key: " + key);
        System.out.println("value: " + value);
    }
}
