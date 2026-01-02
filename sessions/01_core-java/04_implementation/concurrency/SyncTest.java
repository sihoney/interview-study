/**
 * 목적: synchronized 로 레이스 해결
 */
public class SyncTest {

    static class Counter {
        int value = 0;
        synchronized void inc() { value++; }
    }

    public static void main(String[] args) throws Exception {
        Counter c = new Counter();

        Thread t1 = new Thread(() -> { for (int i=0;i<1_000_000;i++) c.inc(); });
        Thread t2 = new Thread(() -> { for (int i=0;i<1_000_000;i++) c.inc(); });

        t1.start(); t2.start();
        t1.join(); t2.join();

        System.out.println("Expected=2000000, Actual=" + c.value);
    }
}
