package project;

/**
 * Represents a Parrot, a specific type of animal that extends the Animal class.
 */
public class Parrot extends Animal {

    private String featherColor;

    /**
     * Constructs a Parrot with the specified attributes.
     *
     * @param name         the name of the parrot.
     * @param species      the species of the parrot.
     * @param age          the age of the parrot.
     * @param price        the price of the parrot.
     * @param featherColor the color of the parrot's feathers.
     */
    public Parrot(String name, String species, int age, double price, String featherColor) {
        super(name, species, age, price);
        this.featherColor = featherColor;
    }

    /**
     * Gets the feather color of the parrot.
     *
     * @return the feather color of the parrot.
     */
    public String getFeatherColor() {
        return featherColor;
    }

    /**
     * Sets the feather color of the parrot.
     *
     * @param featherColor the new feather color to be set.
     */
    public void setFeatherColor(String featherColor) {
        this.featherColor = featherColor;
    }

    /**
     * Overrides the toString method to provide a string representation of the Parrot.
     *
     * @return a string representation of the Parrot, including its name, species, age, price, and feather color.
     */
    @Override
    public String toString() {
        return super.toString() + "Feather Color: " + featherColor + "\n";
    }
}

