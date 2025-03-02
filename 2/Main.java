public class Main {
    public static void main (String[] args) {
        Student student = new Student("Henri", 42);
		student.setAge(15);
        student.setName("Alonso");
        System.out.println(student.getName());
		System.out.println(student.getAge());
        System.out.println(student.toString());
       
    }
    
}
