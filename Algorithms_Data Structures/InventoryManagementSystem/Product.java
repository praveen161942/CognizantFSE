public class Product {
    int id; String name; int qty; double price;
    public Product(int id, String name, int qty, double price) {
        this.id = id; this.name = name; this.qty = qty; this.price = price;
    }
    public String toString() { return id + ": " + name + " Qty:" + qty + " ₹" + price; }
}