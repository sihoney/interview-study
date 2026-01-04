public class OverrideOverload {

    static class Parent {
        void hello() {
            System.out.println("Parent hello()");
        }
    }

    static class Child extends Parent {
        @Override
        void hello() { // 오버라이딩
            System.out.println("Child hello()");
        }

        void hello(String name) { // 오버로딩
            System.out.println("Child hello(" + name + ")");
        }
    }

    public static void main(String[] args) {
        Parent p = new Child();
        p.hello(); // 다형성(오버라이딩)

        Child c = new Child();
        c.hello("Jiyeon"); // 오버로딩
    }
}
