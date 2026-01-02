import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * 목적: Fork/Join - 큰 작업을 분할하고 결과를 Join
 */
public class ForkJoinExample {

    static class SumTask extends RecursiveTask<Long> {
        private final long[] arr;
        private final int start, end;
        private static final int THRESHOLD = 50_000;

        SumTask(long[] arr, int start, int end) {
            this.arr = arr; this.start = start; this.end = end;
        }

        @Override
        protected Long compute() {
            int len = end - start;
            if (len <= THRESHOLD) {
                long s = 0;
                for (int i = start; i < end; i++) s += arr[i];
                return s;
            }
            int mid = start + len / 2;
            SumTask left = new SumTask(arr, start, mid);
            SumTask right = new SumTask(arr, mid, end);
            left.fork();
            long r = right.compute();
            long l = left.join();
            return l + r;
        }
    }

    public static void main(String[] args) {
        long[] arr = new long[2_000_000];
        for (int i = 0; i < arr.length; i++) arr[i] = 1;

        ForkJoinPool pool = ForkJoinPool.commonPool();
        long result = pool.invoke(new SumTask(arr, 0, arr.length));
        System.out.println("result=" + result);
    }
}
