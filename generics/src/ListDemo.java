import java.util.*;

public class ListDemo {
    public static void main(String[] args) {
        BoundPair<Integer, Integer> o1 = new BoundPair<>(1, 5);
        BoundPair<Integer, Integer> o2 = new BoundPair<>(10, 15);
        BoundPair<Integer, Integer> o3 = new BoundPair<>(20, 25);
        BoundPair<Integer, Integer> o4 = new BoundPair<>(30, 35);

        List<BoundPair> l1 = new LinkedList<>();
        l1.add(o1);
        l1.add(o2);
        l1.add(o3);
        l1.add(o4);
        System.out.println("Initial List:---------------------");
        l1.stream().forEach(item -> System.out.print(item + " -> "));
        System.out.println();

        System.out.println("Processing List:---------------------");

        BoundPair<Integer, Integer> o5 = new BoundPair<>(6, 17);
        BoundPair<Integer, Integer> previousItem = o5;

        Set<BoundPair> set = new HashSet<>();
        int i = 0;
        int k = l1.size();
        while (i < k) {
            BoundPair<Integer, Integer> currentItem = l1.get(i);
            if (previousItem.upperBound < currentItem.lowerBound) {
                l1.add(i, previousItem);
                currentItem = l1.get(i - 1);
                previousItem = l1.get(i);
            } else if (previousItem.lowerBound > currentItem.upperBound) {
                l1.add(i + 1, previousItem);
                currentItem = l1.get(i);
                previousItem = l1.get(i + 1);
            } else {
                BoundPair<Integer, Integer> updatedItem = findUpdatedPair(currentItem, previousItem);
                System.out.println("bNew: " + updatedItem);

                System.out.println("b2: " + previousItem);
                if (updatedItem.equals(currentItem)) {
                    // k--;

                    break;
                }
                if (!updatedItem.equals(currentItem) && updatedItem.equals(previousItem)) {
                    l1.remove(currentItem);
                    l1.add(i, previousItem);
                    previousItem = l1.get(i);

                } else if (!updatedItem.equals(currentItem) && !updatedItem.equals(previousItem)) {
                    l1.remove(currentItem);
                    l1.add(i, updatedItem);
                    previousItem = l1.get(i);
                }
            }
            k = l1.size();

            System.out.println("b1: " + currentItem);
            l1.stream().forEach(item -> System.out.print(item + " -> "));
            System.out.println();
            i++;
        }

        l1.stream().forEach(item -> System.out.print(item + " -> "));
    }

    private static BoundPair findUpdatedPair(BoundPair<Integer, Integer> b1, BoundPair<Integer, Integer> b2) {
        //(1,5) (6,17)
        if (b2.lowerBound < b1.lowerBound && b2.upperBound > b1.upperBound) {
            return b2;
        } else if (b2.lowerBound >= b1.lowerBound && b2.upperBound <= b1.upperBound) {
            return b1;
        } else if (b2.lowerBound >= b1.lowerBound && b2.upperBound > b1.upperBound) {
            return new BoundPair(b1.lowerBound, b2.upperBound);
        } else if (b2.lowerBound < b1.lowerBound && b2.upperBound <= b1.upperBound) {
            return new BoundPair(b2.lowerBound, b1.upperBound);
        }/*else if(b2.lowerBound > b1.upperBound){
            return b2;
        }else if(b2.upperBound < b1.lowerBound){
            return b2;
        }*/
        return null;
    }
}

class BoundPair<K, V> {
    final K lowerBound;
    final V upperBound;

    public BoundPair(K lowerBound, V upperBound) {
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BoundPair<?, ?> boundPair = (BoundPair<?, ?>) o;
        return Objects.equals(lowerBound, boundPair.lowerBound) &&
                Objects.equals(upperBound, boundPair.upperBound);
    }

    @Override
    public String toString() {
        return "(" + lowerBound + "," + upperBound + ")";
    }
}
