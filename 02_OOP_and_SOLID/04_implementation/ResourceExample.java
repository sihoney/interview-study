import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

public class ResourceExample {

    public static void main(String[] args) {
        String data = "line1\nline2\nline3";

        try (BufferedReader br = new BufferedReader(new StringReader(data))) {
            System.out.println(br.readLine());
            System.out.println(br.readLine());
        } catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
        }
        // 자동 close
    }
}
