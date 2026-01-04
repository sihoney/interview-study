public class SyncTest {

    static class Inventory {
        int stock = 100000;

        synchronized void decrease() {
            stock--;
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
