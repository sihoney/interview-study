public class StackHeapTest {

    static class Person {
        String name;
        Person(String name) { this.name = name; }
    }

    static void methodA() {
        int x = 10;                // Stack (primitive)
        Person p = new Person("J"); // p는 Stack, 객체는 Heap
        System.out.println("methodA x=" + x + ", p.name=" + p.name);
        methodB(p);
    }

    static void methodB(Person p) {
        // p는 새로운 Stack frame의 지역변수(참조)
        // 하지만 가리키는 Person 객체는 동일(Heap)
        p.name = "Changed";
        System.out.println("methodB p.name=" + p.name);
    }

    public static void main(String[] args) {
        methodA();
    }
}
