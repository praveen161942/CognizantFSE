public class WebApp implements Observer {
    public void update(String stockUpdate) {
        System.out.println("Web App: Stock updated to " + stockUpdate);
    }
}