package project;

public class Fish extends Animal {

    private String color;

    public Fish(String name,String species,int age, double price, String color) {
        super(name, species, age, price);
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return super.toString() + "Color: " + color +"\n";
    }
}
