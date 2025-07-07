public class Employee {
    int id; String name; String position; double salary;
    public Employee(int id,String name,String pos,double sal){
        this.id=id; this.name=name; this.position=pos; this.salary=sal;
    }
    public String toString() { return id+": "+name+" "+position+" ₹"+salary; }
}