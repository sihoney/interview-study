public class FinalizeTest {

    static class Temp {
        private final int id;
        Temp(int id) { this.id = id; }

        @Override
        protected void finalize() throws Throwable {
            System.out.println("finalize called: " + id);
        }
    }

    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 5000; i++) {
            new Temp(i);
        }

        System.out.println("Objects created. Requesting GC...");
        System.gc();              // 요청일 뿐 보장 아님
        Thread.sleep(2000);

        System.out.println("Done.");
    }
}
