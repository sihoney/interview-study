public class VolatileTest {

    static class Counter {
        volatile int count = 0;

        void inc() {
            count++; // 원자적 연산이 아님 -> 여전히 깨짐
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
        System.out.println("Actual count   = " + c.count);
        System.out.println("volatile은 가시성은 보장하지만 ++ 같은 동시 수정은 못 막는다.");
    }
}
