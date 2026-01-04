import java.util.*;
import java.util.stream.*;

public class StreamVsLoop {

    public static void main(String[] args) {
        int size = 10_000_000;
        List<Integer> data = IntStream.range(0, size).boxed().toList();

        long start1 = System.currentTimeMillis();
        long sum1 = 0;
        for (int i : data) {
            if (i % 2 == 0) sum1 += i;
        }
        long end1 = System.currentTimeMillis();

        long start2 = System.currentTimeMillis();
        long sum2 = data.stream()
                .filter(i -> i % 2 == 0)
                .mapToLong(i -> i)
                .sum();
        long end2 = System.currentTimeMillis();

        System.out.println("Loop sum=" + sum1 + ", time=" + (end1 - start1));
        System.out.println("Stream sum=" + sum2 + ", time=" + (end2 - start2));
    }
}
