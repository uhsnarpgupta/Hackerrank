import java.util.*;

public class Tester {
    static List<String> list = new ArrayList<String>();

    public static void main(String args[]) throws Exception {
        Map<Integer, String> m = new HashMap<>();
        Random r = new Random();
        while (true) {
            m.put(r.nextInt(), "randomValue");
        }
    }
}