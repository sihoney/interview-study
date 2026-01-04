import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ForkJoinExample {

    static class SumTask extends RecursiveTask<Long> {
        private final int[] arr;
        private final int start;
        private final int end;
        private static final int THRESHOLD = 50_000;

        SumTask(int[] arr, int start, int end) {
            this.arr = arr;
            this.start = start;
            this.end = end;
        }

        @Override
        protected Long compute() {
            int len = end - start;
            if (len <= THRESHOLD) {
                long sum = 0;
                for (int i = start; i < end; i++) sum += arr[i];
                return sum;
            }

            int mid = start + len / 2;
            SumTask left = new SumTask(arr, start, mid);
            SumTask right = new SumTask(arr, mid, end);

            left.fork();
            long rightResult = right.compute();
            long leftResult = left.join();

            return leftResult + rightResult;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[2_000_000];
        for (int i = 0; i < arr.length; i++) arr[i] = 1;

        ForkJoinPool pool = ForkJoinPool.commonPool();
        long result = pool.invoke(new SumTask(arr, 0, arr.length));

        System.out.println("Sum = " + result);
    }
}
