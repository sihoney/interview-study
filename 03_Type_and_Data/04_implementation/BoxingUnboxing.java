public class BoxingUnboxing {
    public static void main(String[] args) {
        Integer a = 100;
        Integer b = 100;

        System.out.println(a == b);      // true (캐시 범위)
        System.out.println(a.equals(b)); // true

        Integer x = 200;
        Integer y = 200;

        System.out.println(x == y);      // false
        System.out.println(x.equals(y)); // true
    }
}
