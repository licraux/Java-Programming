import java.util.List;
import java.util.ArrayList;

public class Order {
    protected List<Food> ordered;
    
    public Order(){
        ordered = new ArrayList<Food>();
    }

    public void addFood(Food food){
        ordered.add(food);
    }

    public int total(){
        int suma_total = 0;
        for (Food food : ordered) {
            suma_total += food.getPrice();
        }
        return suma_total;
    }
    
    public void display(){
        for (Food food : ordered) {
            food.display();
        }
        System.out.println(total() + " kr TOTAL");
    }

    public boolean payWith(CreditCard card){
        boolean y = card.withdraw(total());
        if (y == false) {
            System.out.println("ERROR: Payment failed");
            return y;
        }
        return y;
    }
}

