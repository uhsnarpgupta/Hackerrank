public class SimpleThread {
    private static int i = 1;
    private static Object lock = new Object();
    private static boolean check = true;

    public static void main(String[] args) throws InterruptedException {
        A thread1 = new A();
        B thread2 = new B();
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
    }

    static class A extends Thread {
        public void run() {
            synchronized (lock) {
                try {
                    while (true) {
                        System.out.println(i + "");
                        i++;
                        lock.wait(50);
                    }
                } catch (Exception e) {
                } finally {
                    lock.notify();
                }
            }
        }
    }

    static class B extends Thread {
        public void run() {
            synchronized (lock) {
                try {
                    while (true) {
                        System.out.println(i + "");
                        i++;
                        lock.wait(50);
                    }
                } catch (Exception e) {
                } finally {
                    lock.notify();
                }
            }
        }
    }
}
