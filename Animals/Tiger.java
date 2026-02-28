package Animals;

public class Tiger  extends Animal {
    private int numberofStripes;

    public Tiger(String name, int age, int numberofStripes) {
        super(name, age, "Tiger");
        this.numberofStripes = numberofStripes;
    }

    public int getNumberofStripes() { return numberofStripes; }
    public void setNumberofStripes(int numberofStripes) { this.numberofStripes = numberofStripes; }
}
