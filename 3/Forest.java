import java.util.ArrayList;
import java.util.Iterator;

public class Forest {
   

private ArrayList <Tree> trees;

public Forest()
{
trees = new ArrayList<>();
}

public void addTree(int growthPct)
{
    trees.add(new Tree(growthPct));
    
}

public String toString()
{
    String x = "Forest(";
    Iterator <Tree> itr = trees.iterator();
    String y;
    while (itr.hasNext()){
        y = itr.next().toString(); 
        x=x+y;
}
return x+")";
}

public void growOneYear()
 {
    for (Tree trees : trees){
        trees.growOneYear();
    }
 }

}