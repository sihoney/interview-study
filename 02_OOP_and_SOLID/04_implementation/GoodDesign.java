public class GoodDesign {

    static class Order {
        final int amount;
        Order(int amount) { this.amount = amount; }
    }

    interface Payment {
        void pay(Order order);
    }

    static class CardPayment implements Payment {
        @Override
        public void pay(Order order) {
            System.out.println("Pay by CARD: " + order.amount);
        }
    }

    static class KakaoPayment implements Payment {
        @Override
        public void pay(Order order) {
            System.out.println("Pay by KAKAO: " + order.amount);
        }
    }

    static class PaymentService {
        private final Payment payment; // DIP: 구현체가 아니라 추상화에 의존
        PaymentService(Payment payment) { this.payment = payment; }

        void pay(Order order) {
            payment.pay(order); // 다형성
        }
    }

    public static void main(String[] args) {
        Order order = new Order(15000);

        PaymentService cardService = new PaymentService(new CardPayment());
        cardService.pay(order);

        PaymentService kakaoService = new PaymentService(new KakaoPayment());
        kakaoService.pay(order);

        // 결제수단 추가 시 기존 코드 수정 없이 클래스 추가만 하면 됨 → OCP 만족
    }
}
