public class Task {
    int id; String name; String status; Task next;
    public Task(int id,String name,String status){
        this.id=id; this.name=name; this.status=status;
    }
    public String toString(){ return id+": "+name+" ["+status+"]"; }
}