import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class EqualsHashCodeTest {

    static class User {
        private final long id;
        private final String name;

        User(long id, String name) { this.id = id; this.name = name; }

        @Override public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof User)) return false;
            User user = (User) o;
            return id == user.id && Objects.equals(name, user.name);
        }

        @Override public int hashCode() {
            return Objects.hash(id, name);
        }
    }

    public static void main(String[] args) {
        Set<User> set = new HashSet<>();
        set.add(new User(1, "A"));
        set.add(new User(1, "A"));
        System.out.println("size=" + set.size()); // 1
    }
}
