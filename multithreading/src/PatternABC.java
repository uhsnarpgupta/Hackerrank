public class PatternABC {
    static Object monitor = new Object();

    static boolean aTrue = true;
    static boolean bTrue = false;
    static boolean cTrue = false;

    public static void main(String[] args) {
        Thread t1 = new Thread(new SequenceDisplayImpl("A"));
        Thread t2 = new Thread(new SequenceDisplayImpl("B"));
        Thread t3 = new Thread(new SequenceDisplayImpl("C"));
        t1.start();
        t2.start();
        t3.start();

    }

    static class SequenceDisplayImpl implements Runnable {
        String threadId;

        SequenceDisplayImpl(String threadId) {
            this.threadId = threadId;
        }

        public void run() {
            print();
        }

        private void print() {
            try {
                while (true) {
                    Thread.sleep(500);
                    synchronized (monitor) {
                        if ("A" == threadId) {
                            if (!aTrue) {
                                monitor.wait();
                            } else {
                                System.out.println(threadId);
                                aTrue = false;
                                bTrue = true;
                                cTrue = false;
                                monitor.notifyAll();
                            }
                        }
                        if ("B" == threadId) {
                            if (!bTrue) {
                                monitor.wait();
                            } else {
                                System.out.println(threadId);
                                aTrue = false;
                                bTrue = false;
                                cTrue = true;
                                monitor.notifyAll();
                            }
                        }
                        if ("C" == threadId) {
                            if (!cTrue) {
                                monitor.wait();
                            } else {
                                System.out.println(threadId);
                                aTrue = true;
                                bTrue = false;
                                cTrue = false;
                                monitor.notifyAll();
                            }
                        }
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
