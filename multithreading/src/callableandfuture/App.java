package callableandfuture;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.*;

public class App {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        /*executor.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("Starting...");

                Random random = new Random();
                int duration = random.nextInt();
                try {
                    Thread.sleep(duration);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Finished.");
            }
        });*/

        Future<Integer> future = executor.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                System.out.println("Starting...");

                Random random = new Random();
                int duration = random.nextInt(4000);
                if (duration > 2000) {
                    throw new IOException("Sleeping for too long..");
                }
                try {
                    Thread.sleep(duration);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Finished.");
                return duration;
            }
        });

        executor.shutdown();
        //executor.awaitTermination(1, TimeUnit.DAYS);

        try {
            System.out.println("Result is: " + future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            IOException ex = (IOException) e.getCause();
            System.out.println(ex.getMessage());
        }
    }
}
