import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ThreadPoolExample {

    public static void main(String[] args) throws Exception {
        ExecutorService pool = Executors.newFixedThreadPool(4);

        List<Future<Integer>> futures = new ArrayList<>();

        for (int i = 1; i <= 10; i++) {
            final int taskId = i;
            futures.add(pool.submit(() -> {
                Thread.sleep(200);
                System.out.println("Task " + taskId + " done by " + Thread.currentThread().getName());
                return taskId * 10;
            }));
        }

        int sum = 0;
        for (Future<Integer> f : futures) {
            sum += f.get();
        }

        pool.shutdown();
        System.out.println("Sum = " + sum);
    }
}
