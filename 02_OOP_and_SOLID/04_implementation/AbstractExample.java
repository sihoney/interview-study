public class AbstractExample {

    static abstract class Animal {
        void breathe() {
            System.out.println("breathe");
        }
        abstract void sound();
    }

    static class Dog extends Animal {
        @Override
        void sound() {
            System.out.println("bark");
        }
    }

    public static void main(String[] args) {
        Animal a = new Dog();
        a.breathe();
        a.sound();
    }
}
