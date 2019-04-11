package deadlock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SimpleDeadlockFix {
    public static Lock l1 = new ReentrantLock();
    public static Lock l2 = new ReentrantLock();

    private static void acquireLock(Lock l1, Lock l2) throws InterruptedException {
        boolean gotLock1 = false;
        boolean gotLock2 = false;
        try {
            gotLock1 = l1.tryLock();
            gotLock2 = l2.tryLock();
        } finally {
            if (gotLock1 && gotLock2) return;
            if (gotLock1) l1.unlock();
            if (gotLock2) l2.unlock();

            System.out.println("Still Acquiring lock 1 & lock 2");

            //Locks not acquired
            Thread.sleep(1);
        }
    }

    public static void main(String[] a) {
        Thread t1 = new Thread1();
        Thread t2 = new Thread2();
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException ex) {

        }
    }

    private static class Thread1 extends Thread {
        public void run() {
            try {
                acquireLock(l1, l2);
                System.out.println("Thread 1 : Acquired lock 1 & lock 2");
            } catch (InterruptedException ex) {
            } finally {
                l1.unlock();
                l2.unlock();
            }
        }
    }

    private static class Thread2 extends Thread {
        public void run() {
            try {
                Thread.sleep(10);
                acquireLock(l1, l2);
                System.out.println("Thread 1 : Acquired lock 1 & lock 2");
            } catch (InterruptedException e) {
            } finally {
                l1.unlock();
                l2.unlock();
            }
        }
    }
}
