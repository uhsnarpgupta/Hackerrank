package demo1;

import java.util.concurrent.*;

public class PlayingWithCallablesAndFutures {
    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
       /* Runnable task = () -> {
            System.out.println("I am in thread "+Thread.currentThread().getName());
        };*/

        Callable<String> task = () -> {
            //Thread.sleep(300);
            //return "I am in thread " + Thread.currentThread().getName();

            throw new IllegalStateException("I throw an exception in thread " + Thread.currentThread().getName());
        };

        //ExecutorService service = Executors.newSingleThreadExecutor();
        ExecutorService executor = Executors.newFixedThreadPool(4);

        try {
            for (int i = 0; i < 10; i++) {
                //new Thread(task).start();
                Future<String> future = executor.submit(task);
                System.out.println("I get: " + future.get(100, TimeUnit.MILLISECONDS));
            }
        } finally {
            executor.shutdown();
        }
    }
}
