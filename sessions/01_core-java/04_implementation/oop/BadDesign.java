/**
 * 나쁜 설계 예:
 * - 하나의 클래스가 "검증 + 할인 + 결제 + 영수증"을 다 함 (SRP 위반)
 * - 요구사항 추가마다 if/else 폭발 (OCP 위반)
 */
public class BadDesign {

    static class OrderService {
        public int pay(String userGrade, int price, String paymentType) {
            // validate
            if (price <= 0) throw new IllegalArgumentException("price");

            // discount
            int discounted = price;
            if ("VIP".equals(userGrade)) discounted = (int) (price * 0.9);
            else if ("NORMAL".equals(userGrade)) discounted = price;

            // pay
            if ("CARD".equals(paymentType)) {
                System.out.println("Pay by CARD: " + discounted);
            } else if ("CASH".equals(paymentType)) {
                System.out.println("Pay by CASH: " + discounted);
            } else {
                throw new IllegalArgumentException("paymentType");
            }

            // receipt
            System.out.println("Receipt issued");
            return discounted;
        }
    }

    public static void main(String[] args) {
        OrderService s = new OrderService();
        s.pay("VIP", 10000, "CARD");
    }
}
