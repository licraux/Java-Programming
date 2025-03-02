import java.util.List;
import java.util.ArrayList;

public class Pizza extends Food{
    protected List<String> toppings;

    public Pizza() {
        super("Pizza", 45);
        toppings = new ArrayList<>();
    }
    
    public void addTopping(String topping){
        toppings.add(topping);
        price += 10;
    }

    @Override
    public void display() {
        // not finished, have to fix formatting
        super.display();
        System.out.println("{ ");
        for (String t : toppings){
            if (toppings.get(toppings.size()-1).equals(t)) {
                System.out.println(t);
            }
            else {
                System.out.println(t + ", ");
            }
            
        }
        System.out.println(" }");
    }

    public void setName(String name){
        this.name = name;
    }

}
