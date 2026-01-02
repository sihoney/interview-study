import java.util.concurrent.atomic.AtomicInteger;

/**
 * 목적: Atomic + CAS 기반으로 레이스 해결
 */
public class AtomicTest {
    public static void main(String[] args) throws Exception {
        AtomicInteger value = new AtomicInteger(0);

        Thread t1 = new Thread(() -> { for (int i=0;i<1_000_000;i++) value.incrementAndGet(); });
        Thread t2 = new Thread(() -> { for (int i=0;i<1_000_000;i++) value.incrementAndGet(); });

        t1.start(); t2.start();
        t1.join(); t2.join();

        System.out.println("Expected=2000000, Actual=" + value.get());
    }
}
