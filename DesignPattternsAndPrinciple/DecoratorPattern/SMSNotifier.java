public class SMSNotifier extends NotifierDecorator {
    public SMSNotifier(Notifier notifier) {
        super(notifier);
    }

    public void send() {
        super.send();
        System.out.println("SMS sent.");
    }
}