import java.io.*;

/**
 * 직렬화/역직렬화 실습
 */
public class SerializationTest {

    static class User implements Serializable {
        private static final long serialVersionUID = 1L;
        String name;
        int age;
        User(String name, int age) { this.name = name; this.age = age; }
        public String toString() { return "User{name=" + name + ", age=" + age + "}"; }
    }

    public static void main(String[] args) throws Exception {
        User u = new User("jiyeon", 20);

        // serialize
        byte[] bytes;
        try (ByteArrayOutputStream bos = new ByteArrayOutputStream();
             ObjectOutputStream out = new ObjectOutputStream(bos)) {
            out.writeObject(u);
            bytes = bos.toByteArray();
        }

        // deserialize
        try (ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
             ObjectInputStream in = new ObjectInputStream(bis)) {
            User restored = (User) in.readObject();
            System.out.println(restored);
        }
    }
}
