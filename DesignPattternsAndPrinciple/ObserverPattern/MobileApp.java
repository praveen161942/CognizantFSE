public class MobileApp implements Observer {
    public void update(String stockUpdate) {
        System.out.println("Mobile App: Stock updated to " + stockUpdate);
    }
}