package Animals;

public class Hyena extends Animal {

    private String laughstyle;

    public Hyena(String name, int age, String laughstyle) {
        super(name, age, "Hyena");
        this.laughstyle = laughstyle;
    }

    public String getLaughstyle() { return laughstyle; }
}
