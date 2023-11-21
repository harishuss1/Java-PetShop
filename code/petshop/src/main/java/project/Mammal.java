package project;

public class Mammal extends Animal{

    private String furColor;

    public Mammal(String name, String species, int age, double price) {
        super(name, species, age, price);
        //TODO Auto-generated constructor stub
    }

    public String getFurColor() {
        return furColor;
    }
    public void setFurColor(String furColor) {
        this.furColor = furColor;
    }
    
}
