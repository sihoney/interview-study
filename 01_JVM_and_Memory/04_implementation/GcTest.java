import java.util.ArrayList;
import java.util.List;

public class GcTest {

    private static void busyAllocate() throws InterruptedException {
        for (int round = 1; round <= 30; round++) {
            List<byte[]> temp = new ArrayList<>();
            for (int i = 0; i < 200; i++) {
                temp.add(new byte[1024 * 256]); // 256KB * 200 = 50MB 정도
            }

            // 참조 끊기 → 다음 라운드에서 temp는 GC 대상
            temp = null;

            System.out.println("Round " + round + " done. (temp released)");
            Thread.sleep(200);
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Start GC test");
        busyAllocate();
        System.out.println("End GC test");
    }
}
