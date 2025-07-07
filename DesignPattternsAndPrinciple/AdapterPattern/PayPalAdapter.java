public class PayPalAdapter implements PaymentProcessor {
    private PayPalGateway gateway;

    public PayPalAdapter(PayPalGateway g) {
        this.gateway = g;
    }

    public void processPayment() {
        gateway.sendMoney();
    }
}