import java.util.*;
public class SearchApp {
    public static void main(String[] args) {
        Product[] p = { new Product(1, "Camera"), new Product(2, "Fan"), new Product(3, "Laptop") };
        Arrays.sort(p, Comparator.comparing(prod -> prod.name));
        System.out.println(binarySearch(p, "Laptop"));
    }
    static Product binarySearch(Product[] p, String name) {
        int l=0,r=p.length-1;
        while(l<=r) {
            int m=(l+r)/2, cmp=name.compareTo(p[m].name);
            if(cmp==0)return p[m]; else if(cmp<0)r=m-1; else l=m+1;
        }
        return null;
    }
}