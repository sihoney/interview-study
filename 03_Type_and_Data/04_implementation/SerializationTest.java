import java.io.*;

public class SerializationTest {

    static class User implements Serializable {
        private static final long serialVersionUID = 1L;
        String name;
        User(String name) { this.name = name; }
    }

    public static void main(String[] args) throws Exception {
        User u1 = new User("Jiyeon");

        // 직렬화
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("user.dat"))) {
            out.writeObject(u1);
        }

        // 역직렬화
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("user.dat"))) {
            User u2 = (User) in.readObject();
            System.out.println(u2.name);
        }
    }
}
