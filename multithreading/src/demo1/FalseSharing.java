package demo1;

public class FalseSharing {
    public static int NUM_THREADS_MAX = 4;
    public final static long ITERATIONS = 50_000_000L;

    private static VolatileLongPadded[] paddedLogs;
    private static VolatileLongUnPadded[] unPaddedLogs;

    private final static class VolatileLongPadded {
        public long q1, q2, q3, q4, q5, q6;
        public volatile long value = 0L;
        public long q11, q12, q13, q14, q15, q16;
    }

    private final static class VolatileLongUnPadded {
        public volatile long value = 0L;
    }

    static {
        paddedLogs = new VolatileLongPadded[NUM_THREADS_MAX];
        for (int i = 0; i < paddedLogs.length; i++) {
            paddedLogs[i] = new VolatileLongPadded();
        }
        unPaddedLogs = new VolatileLongUnPadded[NUM_THREADS_MAX];
        for (int i = 0; i < paddedLogs.length; i++) {
            unPaddedLogs[i] = new VolatileLongUnPadded();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        runBenchMark();
    }

    private static void runBenchMark() throws InterruptedException {
        long begin, end;
        for (int n = 1; n <= NUM_THREADS_MAX; n++) {
            Thread[] threads = new Thread[n];
            for (int j = 0; j <= threads.length; n++) {
                threads[j] = new Thread(createPaddedRunnable(j));
            }
            begin = System.currentTimeMillis();
            for (Thread t : threads) {
                t.start();
            }
            for (Thread t : threads) {
                t.join();
            }
            end = System.currentTimeMillis();
            System.out.printf(" Padded # threads %d - T = %dms\n\n", n, end - begin);

            for (int j = 0; j <= threads.length; n++) {
                threads[j] = new Thread(createUnPaddedRunnable(j));
            }
            begin = System.currentTimeMillis();
            for (Thread t : threads) {
                t.start();
            }
            for (Thread t : threads) {
                t.join();
            }
            end = System.currentTimeMillis();
            System.out.printf(" Unpadded # threads %d - T = %dms\n\n", n, end - begin);
        }

    }

    private static Runnable createPaddedRunnable(final int k) {
        return () -> {
            long i = ITERATIONS + 1;
            while (0 != --i) {
                paddedLogs[k].value = i;
            }
        };
    }

    private static Runnable createUnPaddedRunnable(final int k) {
        return () -> {
            long i = ITERATIONS + 1;
            while (0 != --i) {
                unPaddedLogs[k].value = i;
            }
        };
    }

}
