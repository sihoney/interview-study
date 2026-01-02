import java.util.ArrayList;
import java.util.List;

/**
 * 목적: loop vs stream 감각 비교 (정확한 벤치마크는 JMH 권장)
 */
public class StreamVsLoop {
    public static void main(String[] args) {
        List<Integer> data = new ArrayList<>();
        for (int i = 1; i <= 1_000_000; i++) data.add(i);

        long t1 = System.currentTimeMillis();
        long sum1 = 0;
        for (int x : data) if (x % 2 == 0) sum1 += x;
        long t2 = System.currentTimeMillis();

        long t3 = System.currentTimeMillis();
        long sum2 = data.stream().filter(x -> x % 2 == 0).mapToLong(x -> x).sum();
        long t4 = System.currentTimeMillis();

        System.out.println("loop sum=" + sum1 + ", ms=" + (t2 - t1));
        System.out.println("stream sum=" + sum2 + ", ms=" + (t4 - t3));
    }
}
