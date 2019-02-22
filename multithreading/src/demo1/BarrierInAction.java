package demo1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class BarrierInAction {
    public static void main(String[] args) {
        class Friend implements Callable<String> {
            private CyclicBarrier barrier;

            public Friend(CyclicBarrier barrier) {
                this.barrier = barrier;
            }

            @Override
            public String call() throws Exception {
                try {
                    Random random = new Random();
                    Thread.sleep(random.nextInt(20) * 100 + 100);
                    System.out.println("I just arrived, waiting for others...");
                    barrier.await(5, TimeUnit.SECONDS);
                    System.out.println("Let's go to the cinema");
                    return "ok";
                }catch (InterruptedException e){
                    System.out.println("Interrupted");
                }
                return "not ok";
            }
        }

        ExecutorService service = Executors.newFixedThreadPool(2);
        CyclicBarrier barrier = new CyclicBarrier(4, () -> System.out.println("Barrier opening..."));
        List<Future> futures = new ArrayList<>();
        try {
            for (int i = 0; i < 4; i++) {
                Friend friend = new Friend(barrier);
                futures.add(service.submit(friend));
            }
            futures.forEach(future -> {
                try{
                    future.get();
                    //future.get(500, TimeUnit.MILLISECONDS);
                }catch (InterruptedException | ExecutionException e){
                    System.out.println(e.getMessage());
                    //future.cancel(true);
                }
            });
        } finally {
            service.shutdown();
        }
    }
}

/*
CyclicBarrier :
A tool to synchronize several threads between them, and let them continue when they reach a common point
Can be reset
Useful for parallel computations

CountDownLatch:
A tool to check that different threads did their task
And synchronize the beginning of subsequent tasks on the last one to complete
Once open countdown latch cannot be closed
Useful for starting an application on the completion of different initializations
 */