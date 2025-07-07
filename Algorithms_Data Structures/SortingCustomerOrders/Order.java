public class Order {
    int id; String customer; double price;
    public Order(int id, String customer, double price) {
        this.id = id; this.customer = customer; this.price = price;
    }
    public String toString() { return id + ": " + customer + " ₹" + price; }
}