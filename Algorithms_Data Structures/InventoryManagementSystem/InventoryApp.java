public class InventoryApp {
    public static void main(String[] args) {
        Inventory inv = new Inventory();
        inv.add(new Product(1, "Mouse", 50, 399));
        inv.update(1, 40);
        inv.show();
    }
}