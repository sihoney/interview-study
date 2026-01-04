import java.util.Optional;

public class OptionalExample {

    static class User {
        String name;
        User(String name) { this.name = name; }
    }

    public static void main(String[] args) {
        Optional<User> user = Optional.ofNullable(null);

        user.ifPresent(u -> System.out.println(u.name));

        String name = user.map(u -> u.name).orElse("Guest");
        System.out.println(name);
    }
}
