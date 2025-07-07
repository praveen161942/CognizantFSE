public class TaskList {
    Task head=null;
    public void add(Task t){
        if(head==null) head=t;
        else {
            Task temp=head;
            while(temp.next!=null) temp=temp.next;
            temp.next=t;
        }
    }
    public void delete(int id){
        if(head!=null && head.id==id){ head=head.next; return; }
        Task cur=head, prev=null;
        while(cur!=null && cur.id!=id){ prev=cur; cur=cur.next; }
        if(cur!=null) prev.next=cur.next;
    }
    public void display(){
        Task temp=head;
        while(temp!=null){ System.out.println(temp); temp=temp.next; }
    }
}