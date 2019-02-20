package countdownlatche;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Processor implements Runnable {
    private CountDownLatch cl;

    public Processor(CountDownLatch cl) {
        this.cl = cl;
    }

    @Override
    public void run() {
        System.out.println("Started...");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
        }
        cl.countDown();
    }
}

public class App {
    public static void main(String[] args) {
        CountDownLatch cl = new CountDownLatch(3);
        ExecutorService es = Executors.newFixedThreadPool(3);

        for (int i = 0; i < 3; i++) {
            es.submit(new Processor(cl));
        }

        try {
            cl.await();
        } catch (InterruptedException e) {
        }
        System.out.println("Completed");
    }
}
