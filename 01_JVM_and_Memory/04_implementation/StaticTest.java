public class StaticTest {

    static int staticCounter = 0; // Method Area(개념적으로), 클래스 공유

    int instanceCounter = 0;

    void inc() {
        staticCounter++;
        instanceCounter++;
    }

    public static void main(String[] args) {
        StaticTest a = new StaticTest();
        StaticTest b = new StaticTest();

        a.inc();
        a.inc();
        b.inc();

        System.out.println("staticCounter (shared) = " + StaticTest.staticCounter);
        System.out.println("a.instanceCounter = " + a.instanceCounter);
        System.out.println("b.instanceCounter = " + b.instanceCounter);
    }
}
