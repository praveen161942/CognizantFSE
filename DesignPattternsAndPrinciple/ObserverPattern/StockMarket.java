import java.util.*;
public class StockMarket implements Stock {
    private List<Observer> observers = new ArrayList<>();
    private String stockUpdate;

    public void register(Observer o) { observers.add(o); }
    public void deregister(Observer o) { observers.remove(o); }

    public void setStockUpdate(String update) {
        this.stockUpdate = update;
        notifyObservers();
    }

    public void notifyObservers() {
        for (Observer o : observers)
            o.update(stockUpdate);
    }
}