import java.util.*;
import java.util.stream.*;

public class ParallelStreamTest {

    public static void main(String[] args) {
        int size = 10_000_000;
        List<Integer> data = IntStream.range(0, size).boxed().toList();

        long start1 = System.currentTimeMillis();
        long sum1 = data.stream().mapToLong(i -> i).sum();
        long end1 = System.currentTimeMillis();

        long start2 = System.currentTimeMillis();
        long sum2 = data.parallelStream().mapToLong(i -> i).sum();
        long end2 = System.currentTimeMillis();

        System.out.println("Single stream time: " + (end1 - start1));
        System.out.println("Parallel stream time: " + (end2 - start2));
    }
}
