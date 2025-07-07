import java.util.*;
public class Inventory {
    HashMap<Integer, Product> items = new HashMap<>();
    public void add(Product p) { items.put(p.id, p); }
    public void update(int id, int qty) { if(items.containsKey(id)) items.get(id).qty = qty; }
    public void delete(int id) { items.remove(id); }
    public void show() { items.values().forEach(System.out::println); }
}