public class MVCTest {
    public static void main(String[] args) {
        Student s = new Student("Praveen", 101, "A");
        StudentView v = new StudentView();
        StudentController c = new StudentController(s, v);
        c.updateView();
    }
}