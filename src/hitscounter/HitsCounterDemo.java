package hitscounter;

import java.time.LocalDateTime;

public class HitsCounterDemo {
    public static void main(String[] args) {
        HitsCounter counter = HitsCounter.getInstance();

        Runner t1 = new Runner();
        Runner t2 = new Runner();
        Runner t3 = new Runner();

        t1.start();
        //t2.start();
        t3.start();

        try {
            t1.join();
            //t2.join();
            t3.join();
        } catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        }
        LocalDateTime time = LocalDateTime.now();

        counter.getHits(time.getSecond());

    }
}

class Runner extends Thread {
    LocalDateTime now = LocalDateTime.now();
    HitsCounter counter = HitsCounter.getInstance();

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            counter.hit(now.getSecond());
            System.out.println(counter.getHits(now.getSecond()));
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
