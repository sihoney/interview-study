/**
 * SOLID 핵심만 압축 예시:
 * - ISP: 큰 인터페이스 대신 작은 인터페이스
 * - LSP: 하위 타입이 상위 타입 규약을 깨지 않음
 */
public class SolidExample {

    interface Printable { void print(); }
    interface Scannable { void scan(); }

    static class SimplePrinter implements Printable {
        public void print() { System.out.println("print"); }
    }

    static class MultiFunctionMachine implements Printable, Scannable {
        public void print() { System.out.println("print"); }
        public void scan() { System.out.println("scan"); }
    }

    static void doPrint(Printable p) { p.print(); } // LSP: Printable이면 교체 가능

    public static void main(String[] args) {
        doPrint(new SimplePrinter());
        doPrint(new MultiFunctionMachine());
    }
}
