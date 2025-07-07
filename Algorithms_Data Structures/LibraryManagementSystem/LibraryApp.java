import java.util.*;
public class LibraryApp {
    public static void main(String[] args){
        Book[] books={
            new Book(1,"Algorithms","Cormen"),
            new Book(2,"Java Basics","James"),
            new Book(3,"Data Structures","Sahni")
        };
        Arrays.sort(books, Comparator.comparing(b->b.title));
        System.out.println(binarySearch(books,"Algorithms"));
    }
    static Book binarySearch(Book[] arr,String title){
        int l=0,r=arr.length-1;
        while(l<=r){
            int m=(l+r)/2;
            int cmp=title.compareTo(arr[m].title);
            if(cmp==0)return arr[m];
            else if(cmp<0)r=m-1;
            else l=m+1;
        }
        return null;
    }
}