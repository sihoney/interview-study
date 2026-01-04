public class InterfaceExample {

    interface Readable {
        String read();
    }

    interface Writable {
        void write(String data);
    }

    static class FileStorage implements Readable, Writable {
        private String value = "";

        @Override
        public String read() {
            return value;
        }

        @Override
        public void write(String data) {
            value = data;
        }
    }

    public static void main(String[] args) {
        FileStorage storage = new FileStorage();
        storage.write("hello");
        System.out.println(storage.read());
    }
}
