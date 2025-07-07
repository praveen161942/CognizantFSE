public class SlackNotifier extends NotifierDecorator {
    public SlackNotifier(Notifier notifier) {
        super(notifier);
    }

    public void send() {
        super.send();
        System.out.println("Slack message sent.");
    }
}