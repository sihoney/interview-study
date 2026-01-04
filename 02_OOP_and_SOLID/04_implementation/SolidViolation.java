public class SolidViolation {

    static class UserService {
        // SRP 위반: 사용자 조회 + 이메일 발송 + 로그 기록을 한 클래스가 다함
        void registerUser(String email) {
            System.out.println("1) Save user to DB: " + email);
            System.out.println("2) Send welcome email: " + email);
            System.out.println("3) Write audit log");
        }
    }

    public static void main(String[] args) {
        new UserService().registerUser("test@example.com");
    }
}
