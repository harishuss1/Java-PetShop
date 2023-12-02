package project;

/**
 * The Cat class represents a specific type of animal - a cat.
 * It extends the Animal class and includes additional information
 * about whether the cat has claws or not.
 */
public class Cat extends Animal {

    /**
     * A boolean value indicating whether the cat has claws.
     */
    private boolean hasClaws;

    /**
     * Constructs a new Cat object with the specified attributes.
     *
     * @param name      the name of the cat.
     * @param species   the species of the cat.
     * @param age       the age of the cat.
     * @param price     the price of the cat.
     * @param hasClaws  a boolean value indicating whether the cat has claws.
     */
    public Cat(String name, String species, int age, double price, boolean hasClaws) {
        super(name, species, age, price);
        this.hasClaws = hasClaws;
    }

    /**
     * Retrieves whether the cat has claws or not.
     *
     * @return true if the cat has claws, false otherwise.
     */
    public boolean hasClaws() {
        return hasClaws;
    }

    /**
     * Sets the value indicating whether the cat has claws.
     *
     * @param hasClaws true if the cat has claws, false otherwise.
     */
    public void setHasClaws(boolean hasClaws) {
        this.hasClaws = hasClaws;
    }

    /**
     * Overrides the toString method to provide a string representation of the Cat object.
     *
     * @return a string representation of the Cat object, including information about claws.
     */
    @Override
    public String toString() {
        return super.toString() + "Has Claws: " + hasClaws() + "\n";
    }
}
