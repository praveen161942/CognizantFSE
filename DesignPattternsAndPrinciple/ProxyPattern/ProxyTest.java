public class ProxyTest {
    public static void main(String[] args) {
        Image img = new ProxyImage("pic.jpg");
        img.display(); 
        img.display(); 
    }
}