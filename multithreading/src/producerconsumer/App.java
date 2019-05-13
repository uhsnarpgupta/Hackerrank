package producerconsumer;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class App {
    private static BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);

    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    producer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    consumer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void producer() throws InterruptedException {
        Random random = new Random();

        while (true) {
            queue.put(random.nextInt());
        }
    }

    private static void consumer() throws InterruptedException {
        Random random = new Random();

        while (true) {
            Thread.sleep(100);
            if (random.nextInt(10) == 0) {
                Integer value = queue.take();
                System.out.println("Taken value: " + value + " Queue Size: " + queue.size());
            }
        }
    }


}
/*
BlockingQueue Methods
A BlockingQueue has 4 different sets of methods for inserting, removing and examining the elements in the queue.
Each set of methods behaves differently in case the requested operation cannot be carried out immediately.
Here is a table of the methods:

 	        Throws Exception	Special Value	Blocks	    Times Out
Insert	:   add(o)	            offer(o)	    put(o)	    offer(o, timeout, timeunit)
Remove	:   remove(o)	        poll()	        take()	    poll(timeout, timeunit)
Examine	:   element()	        peek()

The 4 different sets of behaviour means this:

Throws Exception:
If the attempted operation is not possible immediately, an exception is thrown.
Special Value:
If the attempted operation is not possible immediately, a special value is returned (often true / false).
Blocks:
If the attempted operation is not possible immedidately, the method call blocks until it is.
Times Out:
If the attempted operation is not possible immedidately, the method call blocks until it is, but waits no longer
than the given timeout. Returns a special value telling whether the operation succeeded or not (typically true / false).
It is not possible to insert null into a BlockingQueue. If you try to insert null, the BlockingQueue will throw a
NullPointerException.
 */