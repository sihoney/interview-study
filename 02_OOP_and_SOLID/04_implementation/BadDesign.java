public class BadDesign {

    static class Order {
        final String paymentType; // "CARD", "KAKAO", "NAVER"
        final int amount;
        Order(String paymentType, int amount) {
            this.paymentType = paymentType;
            this.amount = amount;
        }
    }

    static class PaymentService {
        void pay(Order order) {
            if ("CARD".equals(order.paymentType)) {
                System.out.println("Pay by CARD: " + order.amount);
            } else if ("KAKAO".equals(order.paymentType)) {
                System.out.println("Pay by KAKAO: " + order.amount);
            } else if ("NAVER".equals(order.paymentType)) {
                System.out.println("Pay by NAVER: " + order.amount);
            } else {
                throw new IllegalArgumentException("Unknown payment type: " + order.paymentType);
            }
        }
    }

    public static void main(String[] args) {
        PaymentService service = new PaymentService();
        service.pay(new Order("CARD", 10000));
        service.pay(new Order("KAKAO", 20000));

        // 새로운 결제수단 추가하려면 pay()를 수정해야 함 → OCP 위반
        // service.pay(new Order("TOSS", 30000));
    }
}
