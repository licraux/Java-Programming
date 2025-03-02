public class Main{

public static void main(String[] args) 
{
    Forest Forest1 = new Forest();
    Forest1.addTree(5000);
    Forest1.addTree(200);
    Forest1.addTree(180);


    System.out.println(Forest1.toString());
    Forest1.growOneYear();
    System.out.println(Forest1.toString());
    Forest1.growOneYear();
    System.out.println(Forest1.toString());
}
}