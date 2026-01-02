import java.util.Optional;

public class OptionalExample {

    static String findNickname(Long memberId) {
        if (memberId == null) return null;
        if (memberId == 1L) return "jiyeon";
        return null;
    }

    public static void main(String[] args) {
        Optional<String> nick = Optional.ofNullable(findNickname(1L));
        System.out.println(nick.orElse("guest"));

        Optional<String> missing = Optional.ofNullable(findNickname(2L));
        System.out.println(missing.orElse("guest"));
    }
}
