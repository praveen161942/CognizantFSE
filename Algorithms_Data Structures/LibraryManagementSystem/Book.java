public class Book {
    int id; String title; String author;
    public Book(int id,String title,String author){
        this.id=id; this.title=title; this.author=author;
    }
    public String toString(){ return id+": "+title+" by "+author; }
}