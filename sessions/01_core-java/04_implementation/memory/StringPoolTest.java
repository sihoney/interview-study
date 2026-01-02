/**
 * 목적:
 * - "" 리터럴은 String Pool 공유
 * - new String("x") 는 Heap에 별도 객체
 * - intern()으로 pool 등록 가능
 */
public class StringPoolTest {
    public static void main(String[] args) {
        String a = "hello";
        String b = "hello";

        System.out.println("a == b (pool shared): " + (a == b)); // true

        String c = new String("hello");
        String d = new String("hello");

        System.out.println("c == d (heap distinct): " + (c == d)); // false
        System.out.println("c.equals(d): " + c.equals(d)); // true

        String ci = c.intern();
        System.out.println("a == ci (after intern): " + (a == ci)); // true
    }
}
