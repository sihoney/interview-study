import java.lang.annotation.*;
import java.lang.reflect.*;
import java.util.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface Component {}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface Autowired {}

@Component
class Engine {
    public void start() {
        System.out.println("Engine started");
    }
}

@Component
class Car {

    @Autowired
    Engine engine;

    public void drive() {
        engine.start();
        System.out.println("Car driving");
    }
}

public class MiniDIContainer {

    static Map<Class<?>, Object> container = new HashMap<>();

    public static void main(String[] args) throws Exception {

        List<Class<?>> classes = List.of(Engine.class, Car.class);

        // 1. 객체 생성
        for (Class<?> clazz : classes) {
            if (clazz.isAnnotationPresent(Component.class)) {
                Object instance = clazz.getDeclaredConstructor().newInstance();
                container.put(clazz, instance);
            }
        }

        // 2. 의존성 주입
        for (Object obj : container.values()) {
            for (Field field : obj.getClass().getDeclaredFields()) {
                if (field.isAnnotationPresent(Autowired.class)) {
                    Object dependency = container.get(field.getType());
                    field.setAccessible(true);
                    field.set(obj, dependency);
                }
            }
        }

        // 3. 실행
        Car car = (Car) container.get(Car.class);
        car.drive();
    }
}
