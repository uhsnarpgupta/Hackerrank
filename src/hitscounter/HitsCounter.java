package hitscounter;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;

public class HitsCounter {
    private final static Queue<Integer> queue = new ConcurrentLinkedDeque<>();
    private static final HitsCounter INSTANCE = new HitsCounter();

    private HitsCounter() {
    }

    public static HitsCounter getInstance() {
        return INSTANCE;
    }


    synchronized void hit(int timestamp) {
        queue.add(timestamp);
    }

    synchronized int getHits(int timestamp) {
        while (!queue.isEmpty() && timestamp - queue.peek() >= 300) {
            queue.poll();
        }
        return queue.size();
    }
}
