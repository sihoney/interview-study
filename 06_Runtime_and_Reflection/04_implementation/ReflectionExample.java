import java.lang.reflect.*;

class Person {
    private String name;

    public Person() {}

    public void setName(String name) {
        this.name = name;
    }

    public void hello() {
        System.out.println("Hello, " + name);
    }
}

public class ReflectionExample {

    public static void main(String[] args) throws Exception {

        Class<?> clazz = Class.forName("Person");

        Object obj = clazz.getDeclaredConstructor().newInstance();

        Method setName = clazz.getMethod("setName", String.class);
        setName.invoke(obj, "Jiyeon");

        Method hello = clazz.getMethod("hello");
        hello.invoke(obj);
    }
}
