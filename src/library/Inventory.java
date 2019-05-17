package library;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Inventory<T> {
    private HashMap<T, Integer> map = new HashMap<>();
    private static final int TOTAL_BOOK_INSTANCE = 5;

    public int getCount(T item) {
        return map.get(item);
    }

    public void putItem(T item) {
        map.put(item, map.get(item) + 1);
    }

    public void removeItem(T item) {
        map.put(item, map.get(item) - 1);
    }

    public int availableInstances(T item) {
        return TOTAL_BOOK_INSTANCE - map.get(item);
    }

    public List<T> getItems() {
        List<T> list = new ArrayList<>();
        for (HashMap.Entry<T, Integer> entry : map.entrySet()) {
            list.add(entry.getKey());
        }
        return list;
    }
}
