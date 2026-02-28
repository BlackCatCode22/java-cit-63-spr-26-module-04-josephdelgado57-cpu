package Animals;

public class Bear extends Animal {
    private String furColor;

    public Bear(String name, int age, String furColor) {
        super(name, age, "Bear");
    }

    public String getFurColor() { return furColor; }
    public  void  setFurColor(String furColor) { this.furColor = furColor; }
}
