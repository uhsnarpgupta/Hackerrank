package demo1;

public class RaceCondition {
    public static void main(String[] args) throws InterruptedException {
        LongWrapper longWrapper = new LongWrapper(0L);
        Runnable runnable = () -> {
            for (int i = 0; i < 1_000; i++) {
                longWrapper.increamentValue();
            }
        };

        Thread[] threads = new Thread[1_000];
        for (int i = 0; i < 1_000; i++) {
            threads[i] = new Thread(runnable);
            threads[i].start();
        }
        for (int i = 0; i < threads.length; i++) {
            threads[i].join();
        }

        System.out.println("Value = " + longWrapper.getValue());
    }
}

class LongWrapper {
    private Long l;
    private Object key = new Object();

    public LongWrapper(Long l) {
        this.l = l;
    }

    public Long getValue() {
        synchronized (key) {
            return l;
        }
    }

    public void increamentValue() {
        synchronized (key) {
            l += 1;
        }
    }
}
