public class Tree {
    
    private int age;
    private double height;
    private double growthPct;

public Tree (double growthPct)
{
    height = 0.25;
    age = 1;
    this.growthPct = growthPct;
}

public String toString()
{
return "Tree(age = " + age + ", height = " + height + ")";
}

public void growOneYear()
{
    age++;
    this.height = height * (1 + growthPct / 100);
    if (height > 20)
{
        height = 20;
}
}
}
