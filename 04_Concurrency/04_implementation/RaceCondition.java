public class RaceCondition {

    static class Inventory {
        int stock = 100000;

        void decrease() {
            stock--; // 임계영역 보호 없음
        }
    }

    public static void main(String[] args) throws Exception {
        Inventory inv = new Inventory();

        int threads = 8;
        int perThread = 20000;

        Thread[] workers = new Thread[threads];

        for (int t = 0; t < threads; t++) {
            workers[t] = new Thread(() -> {
                for (int i = 0; i < perThread; i++) {
                    inv.decrease();
                }
            });
        }

        for (Thread w : workers) w.start();
        for (Thread w : workers) w.join();

        int expected = 100000 - (threads * perThread);
        System.out.println("Expected stock = " + expected);
        System.out.println("Actual stock   = " + inv.stock);
    }
}
