import java.io.IOException;

public class ExceptionDesign {

    static void checkedExample() throws IOException {
        throw new IOException("Checked exception example");
    }

    static void uncheckedExample() {
        throw new IllegalArgumentException("Unchecked exception example");
    }

    public static void main(String[] args) {
        try {
            checkedExample();
        } catch (IOException e) {
            System.out.println("Handled checked exception: " + e.getMessage());
        }

        try {
            uncheckedExample();
        } catch (RuntimeException e) {
            System.out.println("Handled unchecked exception: " + e.getMessage());
        }

        // Error 예시(보통 잡지 않는다): StackOverflowError, OutOfMemoryError 등
    }
}
