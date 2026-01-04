public class GenericBox<T> {
    private T value;

    public void set(T value) {
        this.value = value;
    }

    public T get() {
        return value;
    }

    public static void main(String[] args) {
        GenericBox<String> box = new GenericBox<>();
        box.set("hello");

        String s = box.get(); // 캐스팅 불필요
        System.out.println(s);
    }
}
