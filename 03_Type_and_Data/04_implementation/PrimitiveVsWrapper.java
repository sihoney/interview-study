public class PrimitiveVsWrapper {
    public static void main(String[] args) {
        int p = 10;
        Integer w = 10;

        System.out.println("Primitive: " + p);
        System.out.println("Wrapper: " + w);

        System.out.println("Equals: " + w.equals(p)); // auto-unboxing
    }
}
