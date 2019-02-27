import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SalePriceFaker {
    public static void main(String[] args) {
        List<String> origItems = Arrays.asList("Rice", "Sugar", "Chocolate", "Cheese");
        List<Float> origPrice = Arrays.asList(312.19F, 40F, 127.99F, 99.12F);

        List<String> items = Arrays.asList("Rice", "Cheese", "Chocolate");
        List<Float> price = Arrays.asList(312.9F, 40F, 127.99F);

        System.out.println(suspectedCount(origItems, origPrice, items, price));
    }

    private static int suspectedCount(List<String> origItems, List<Float> origPrice, List<String> items, List<Float> price) {
        Map<String, Float> map = new HashMap<>();
        for (int i = 0; i < origItems.size(); i++) {
            map.put(origItems.get(i), origPrice.get(i));
        }
        Map<String, Float> saleMap = new HashMap<>();
        for (int i = 0; i < items.size(); i++) {
            saleMap.put(items.get(i), price.get(i));
        }
        int count = 0;
        for (String key : saleMap.keySet()) {
            if ((float) saleMap.get(key) != (float) map.get(key)) {
                count++;
            }
        }
        return count;
    }
}
