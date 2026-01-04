import java.util.concurrent.atomic.AtomicInteger;

public class AtomicTest {

    static class Counter {
        AtomicInteger count = new AtomicInteger(0);

        void inc() {
            count.incrementAndGet(); // CAS 기반
        }
    }

    public static void main(String[] args) throws Exception {
        Counter c = new Counter();

        int threads = 8;
        int perThread = 200000;

        Thread[] workers = new Thread[threads];

        for (int t = 0; t < threads; t++) {
            workers[t] = new Thread(() -> {
                for (int i = 0; i < perThread; i++) {
                    c.inc();
                }
            });
        }

        for (Thread w : workers) w.start();
        for (Thread w : workers) w.join();

        int expected = threads * perThread;
        System.out.println("Expected count = " + expected);
        System.out.println("Actual count   = " + c.count.get());
    }
}
