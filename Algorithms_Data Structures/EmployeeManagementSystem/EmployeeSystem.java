public class EmployeeSystem {
    static Employee[] list=new Employee[10];
    static int count=0;

    public static void add(Employee e){ list[count++]=e; }
    public static void delete(int id){
        for(int i=0;i<count;i++)
            if(list[i].id==id){ list[i]=list[--count]; break; }
    }
    public static void display(){
        for(int i=0;i<count;i++) System.out.println(list[i]);
    }
    public static void main(String[] args){
        add(new Employee(101,"David","Manager",60000));
        add(new Employee(102,"Eve","Clerk",25000));
        display();
        delete(101);
        display();
    }
}