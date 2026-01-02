import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

/**
 * 매우 단순한 DI 컨테이너 흉내:
 * - 생성자 주입만 지원
 * - 타입을 키로 싱글턴처럼 캐싱
 */
public class MiniDIContainer {

    private final Map<Class<?>, Object> singletons = new HashMap<>();

    public <T> T get(Class<T> type) {
        if (singletons.containsKey(type)) return type.cast(singletons.get(type));
        try {
            Constructor<?>[] ctors = type.getDeclaredConstructors();
            Constructor<?> ctor = ctors[0];
            ctor.setAccessible(true);

            Class<?>[] paramTypes = ctor.getParameterTypes();
            Object[] params = new Object[paramTypes.length];
            for (int i = 0; i < paramTypes.length; i++) {
                params[i] = get(paramTypes[i]);
            }

            Object instance = ctor.newInstance(params);
            singletons.put(type, instance);
            return type.cast(instance);
        } catch (Exception e) {
            throw new RuntimeException("DI failed for: " + type.getName(), e);
        }
    }

    // demo classes
    static class Repo {
        String find() { return "data"; }
    }
    static class Service {
        private final Repo repo;
        Service(Repo repo) { this.repo = repo; }
        String run() { return "service->" + repo.find(); }
    }

    public static void main(String[] args) {
        MiniDIContainer c = new MiniDIContainer();
        Service s = c.get(Service.class);
        System.out.println(s.run());
    }
}
