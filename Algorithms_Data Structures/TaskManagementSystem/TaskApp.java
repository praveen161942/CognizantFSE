public class TaskApp {
    public static void main(String[] args){
        TaskList list=new TaskList();
        list.add(new Task(1,"Design UI","Pending"));
        list.add(new Task(2,"Test DB","Done"));
        list.display();
        list.delete(1);
        list.display();
    }
}