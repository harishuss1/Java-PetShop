package project;

public class Parrot extends Animal {

    private String featherColor;

    public Parrot(String name, String species,int age, double price, String featherColor) {
        super(name,species, age, price);
        this.featherColor = featherColor;
    }

    public String getFeatherColor() {
        return featherColor;
    }

    public void setFeatherColor(String featherColor) {
        this.featherColor = featherColor;
    }

    @Override
    public String toString() {
        return super.toString() + "Feather Color: " + featherColor+"\n";
    }
}
