package Animals;

public class Lion  extends Animal {
    private boolean hasMane;

    public Lion(String name, int age, boolean hasMane) {
        super(name, age, "Lion");
        this.hasMane = hasMane;
    }

    public boolean isHasMane() { return hasMane; }
    public void setHasMane(boolean hasMane) { this.hasMane = hasMane; }
}
