package project;

/**
 * This class represents a Fish, which is a type of Animal.
 * It has an additional attribute color.
 */
public class Fish extends Animal {

    private String color;

    /**
     * Constructs a new Fish with the given parameters.
     *
     * @param name the name of the fish
     * @param species the species of the fish
     * @param age the age of the fish
     * @param price the price of the fish
     * @param color the color of the fish
     */
    public Fish(String name,String species,int age, double price, String color) {
        super(name, species, age, price);
        this.color = color;
    }

    /**
     * Returns the color of the fish.
     *
     * @return the color of the fish
     */
    public String getColor() {
        return color;
    }

    /**
     * Sets the color of the fish.
     *
     * @param color the new color of the fish
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Returns a string representation of the fish.
     *
     * @return a string representation of the fish
     */
    @Override
    public String toString() {
        return super.toString() + "Color: " + color +"\n";
    }
}