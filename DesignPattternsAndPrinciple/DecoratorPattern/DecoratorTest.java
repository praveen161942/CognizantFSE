public class DecoratorTest {
    public static void main(String[] args) {
        Notifier notifier = new SlackNotifier(new SMSNotifier(new EmailNotifier()));
        notifier.send();
    }
}