public class AdapterTest {
    public static void main(String[] args) {
        PaymentProcessor processor = new PayPalAdapter(new PayPalGateway());
        processor.processPayment();
    }
}