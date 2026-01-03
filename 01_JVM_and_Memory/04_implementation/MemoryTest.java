import java.util.ArrayList;
import java.util.List;

public class MemoryTest {
    public static void main(String[] args) {
        List<byte[]> list = new ArrayList<>();
        int mb = 0;

        try {
            while (true) {
                list.add(new byte[1024 * 1024]); // 1MB
                mb++;
                if (mb % 50 == 0) {
                    System.out.println("Allocated: " + mb + "MB");
                }
            }
        } catch (OutOfMemoryError e) {
            System.out.println("OOM after allocating about " + mb + "MB");
            throw e;
        }
    }
}
