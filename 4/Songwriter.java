import java.util.Scanner;

public class Songwriter {
    
    private int number;
    private String container;
    private String stringOf;
    private String drink;

    public Songwriter(){

    }

    public void scScan(){
        Scanner input = new Scanner(System.in);
        this.number = input.nextInt();
        this.container = input.next();
        this.stringOf = input.next();
        this.drink = input.next();
        input.close();
    }

    public void singSong(){
        scScan();
        String song = " ";
        while (number > -1){
                
            if (number == 0){
                song = "No more " + container + " " + stringOf + " " + drink + " on the wall";
                System.out.println(song);
                --number;
            }
            else if (number == 1){
                song = "One " + container.substring(0, container.length()
                -1) + " " + stringOf + " " + drink + " on the wall";
                System.out.println(song);
                System.out.println("One " + container.substring(0, container.length()-1) + " " + stringOf + " " + drink);
                System.out.println("Take one down, pass it around");
                --number;
                
            }
            else {
                System.out.println(number + " " + container + " " + stringOf + " " + drink + " on the wall");
                System.out.println(number + " " + container + " " + stringOf + " " + drink + "");
                System.out.println("Take one down, pass it around");
                --number;
                if (number == 1){
                    System.out.println("One " + container.substring(0, container.length()
                    -1) + " " + stringOf + " " + drink + " on the wall\n");
                }
                else{
                    System.out.println(number + " " + container + " " + stringOf + " " + drink + " on the wall\n");
                }
                
            }

            }
            

            
        }
    }