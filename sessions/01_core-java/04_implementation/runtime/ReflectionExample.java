import java.lang.reflect.Method;

public class ReflectionExample {

    static class HelloService {
        private String hello(String name) {
            return "hello " + name;
        }
    }

    public static void main(String[] args) throws Exception {
        Class<?> clazz = HelloService.class;
        Object obj = clazz.getDeclaredConstructor().newInstance();

        Method m = clazz.getDeclaredMethod("hello", String.class);
        m.setAccessible(true); // 캡슐화 깨짐 위험 포인트
        Object result = m.invoke(obj, "jiyeon");

        System.out.println(result);
    }
}
