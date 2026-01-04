import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class EqualsHashCodeTest {

    static class User {
        String email;

        User(String email) { this.email = email; }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof User)) return false;
            User user = (User) o;
            return Objects.equals(email, user.email);
        }

        @Override
        public int hashCode() {
            return Objects.hash(email);
        }
    }

    public static void main(String[] args) {
        Set<User> set = new HashSet<>();
        set.add(new User("a@test.com"));
        set.add(new User("a@test.com"));

        System.out.println("Set size = " + set.size()); // 1
    }
}
