public class StrategyTest {
    public static void main(String[] args) {
        PaymentContext ctx = new PaymentContext();

        ctx.setPaymentStrategy(new CreditCardPayment());
        ctx.executePayment(500);

        ctx.setPaymentStrategy(new PayPalPayment());
        ctx.executePayment(300);
    }
}