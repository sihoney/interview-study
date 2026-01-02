/**
 * 목적:
 * - 짧은 생명주기 객체를 대량 생성 -> Young GC 빈번
 * - 주기적으로 큰 객체 생성 -> Old로 승격/압박
 *
 * 실행 예:
 * javac GcTest.java
 * java -Xms256m -Xmx256m -Xlog:gc* GcTest
 */
public class GcTest {
    public static void main(String[] args) {
        long sum = 0;

        for (int i = 1; i <= 2_000_000; i++) {
            // short-lived objects
            String s = "num=" + i; // 매번 새 객체 유도(컴파일러 최적화가 덜 타게)
            sum += s.length();

            // 주기적으로 큰 객체 생성
            if (i % 50_000 == 0) {
                byte[] big = new byte[10 * 1024 * 1024]; // 10MB
                big[0] = 1;
                System.out.println("Checkpoint i=" + i + ", sum=" + sum);
            }
        }

        System.out.println("Done. sum=" + sum);
    }
}
