import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * 목적: 운영에서는 Thread 직접 생성 대신 ExecutorService
 */
public class ThreadPoolExample {
    public static void main(String[] args) throws Exception {
        ExecutorService pool = Executors.newFixedThreadPool(4);
        List<Future<Integer>> futures = new ArrayList<>();

        for (int i = 1; i <= 20; i++) {
            final int n = i;
            futures.add(pool.submit(() -> n * n));
        }

        int sum = 0;
        for (Future<Integer> f : futures) sum += f.get();

        pool.shutdown();
        System.out.println("sum=" + sum);
    }
}
