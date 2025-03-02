public class Student {
    
    private String name;
    private int age;

    public Student(String name, int age)
    {
        this.name = name;
        this.age = age;
    }

    public String getName()
    {
        return name;
    }
    
    public int getAge()
    {
        return age;
    }

    public String toString()
    {
        return "The name of the student is " + name + ". The student is " + age + " years old.";
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setAge(int age)
    {
        if(age < 16) {
            System.out.println("The university does not accept students below 16");
        }
        if(age > 99) {
            System.out.println("The university does not accept students that are older than 99");
        }
        else {
            this.age = age;
        }
    }  
}
