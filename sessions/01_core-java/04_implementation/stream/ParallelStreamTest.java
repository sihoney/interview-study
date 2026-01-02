import java.util.ArrayList;
import java.util.List;

public class ParallelStreamTest {
    public static void main(String[] args) {
        List<Integer> data = new ArrayList<>();
        for (int i = 1; i <= 5_000_000; i++) data.add(i);

        long t1 = System.currentTimeMillis();
        long sum1 = data.stream().mapToLong(x -> (long) x * x).sum();
        long t2 = System.currentTimeMillis();

        long t3 = System.currentTimeMillis();
        long sum2 = data.parallelStream().mapToLong(x -> (long) x * x).sum();
        long t4 = System.currentTimeMillis();

        System.out.println("stream ms=" + (t2 - t1) + ", sum=" + sum1);
        System.out.println("parallel ms=" + (t4 - t3) + ", sum=" + sum2);
    }
}
