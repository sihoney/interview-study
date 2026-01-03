public class StringPoolTest {
    public static void main(String[] args) {
        String a = "hello";
        String b = "hello";

        String c = new String("hello");
        String d = new String("hello");

        System.out.println("[Pool]");
        System.out.println("a == b : " + (a == b)); // true

        System.out.println("\n[Heap new String]");
        System.out.println("c == d : " + (c == d)); // false
        System.out.println("a == c : " + (a == c)); // false

        System.out.println("\n[intern()]");
        String e = c.intern();
        System.out.println("a == e : " + (a == e)); // true
    }
}
