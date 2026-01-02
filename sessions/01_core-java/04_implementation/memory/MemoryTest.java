import java.util.ArrayList;
import java.util.List;

/**
 * 목적:
 * - 힙을 빠르게 채워 GC 압박을 만들고, 결국 OOM까지 유도 가능
 *
 * 실행 예:
 * javac MemoryTest.java
 * java -Xms256m -Xmx256m -Xlog:gc* MemoryTest
 */
public class MemoryTest {
    public static void main(String[] args) throws Exception {
        List<byte[]> holder = new ArrayList<>();
        int mb = 0;

        while (true) {
            holder.add(new byte[1024 * 1024]); // 1MB
            mb++;
            if (mb % 50 == 0) {
                System.out.println("Allocated ~ " + mb + " MB");
                Thread.sleep(100);
            }
        }
    }
}
