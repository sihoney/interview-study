/**
 * 개선 설계:
 * - SRP: Validator / DiscountPolicy / PaymentProcessor 분리
 * - OCP: 결제수단 추가 시 PaymentProcessor 구현만 추가
 * - DIP: OrderService는 인터페이스에 의존
 */
public class RefactoredDesign {

    interface Validator {
        void validate(int price);
    }

    static class PriceValidator implements Validator {
        @Override public void validate(int price) {
            if (price <= 0) throw new IllegalArgumentException("price");
        }
    }

    interface DiscountPolicy {
        int apply(String userGrade, int price);
    }

    static class DefaultDiscountPolicy implements DiscountPolicy {
        @Override public int apply(String userGrade, int price) {
            if ("VIP".equals(userGrade)) return (int) (price * 0.9);
            return price;
        }
    }

    interface PaymentProcessor {
        void pay(int amount);
    }

    static class CardPayment implements PaymentProcessor {
        public void pay(int amount) { System.out.println("Pay by CARD: " + amount); }
    }

    static class CashPayment implements PaymentProcessor {
        public void pay(int amount) { System.out.println("Pay by CASH: " + amount); }
    }

    static class OrderService {
        private final Validator validator;
        private final DiscountPolicy discountPolicy;

        OrderService(Validator validator, DiscountPolicy discountPolicy) {
            this.validator = validator;
            this.discountPolicy = discountPolicy;
        }

        public int checkout(String grade, int price, PaymentProcessor processor) {
            validator.validate(price);
            int discounted = discountPolicy.apply(grade, price);
            processor.pay(discounted);
            System.out.println("Receipt issued");
            return discounted;
        }
    }

    public static void main(String[] args) {
        OrderService service = new OrderService(new PriceValidator(), new DefaultDiscountPolicy());
        service.checkout("VIP", 10000, new CardPayment());
    }
}
