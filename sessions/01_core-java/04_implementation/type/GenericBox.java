public class GenericBox<T> {
    private T value;

    public void set(T value) { this.value = value; }
    public T get() { return value; }

    public static void main(String[] args) {
        GenericBox<Integer> b = new GenericBox<>();
        b.set(10);
        System.out.println(b.get());
    }
}
