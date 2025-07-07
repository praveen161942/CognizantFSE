public class OrderApp {
    public static void main(String[] args) {
        Order[] orders = {
            new Order(1, "Arun", 5000),
            new Order(2, "Bala", 1500),
            new Order(3, "Chitra", 3000)
        };
        Sorter.quickSort(orders,0,orders.length-1);
        for(Order o:orders) System.out.println(o);
    }
}