public class SolidRefactor {

    interface EmailSender {
        void sendWelcome(String email);
    }

    static class SmtpEmailSender implements EmailSender {
        @Override
        public void sendWelcome(String email) {
            System.out.println("Send welcome email via SMTP: " + email);
        }
    }

    interface AuditLogger {
        void log(String message);
    }

    static class ConsoleAuditLogger implements AuditLogger {
        @Override
        public void log(String message) {
            System.out.println("AUDIT: " + message);
        }
    }

    static class UserRepository {
        void save(String email) {
            System.out.println("Save user to DB: " + email);
        }
    }

    static class UserService {
        private final UserRepository repo;
        private final EmailSender emailSender;
        private final AuditLogger auditLogger;

        UserService(UserRepository repo, EmailSender emailSender, AuditLogger auditLogger) {
            this.repo = repo;
            this.emailSender = emailSender;
            this.auditLogger = auditLogger;
        }

        void registerUser(String email) {
            repo.save(email);
            emailSender.sendWelcome(email);
            auditLogger.log("User registered: " + email);
        }
    }

    public static void main(String[] args) {
        UserService service = new UserService(
                new UserRepository(),
                new SmtpEmailSender(),
                new ConsoleAuditLogger()
        );
        service.registerUser("test@example.com");
    }
}
