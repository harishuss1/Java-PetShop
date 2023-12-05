package project;

/**
 * The Dog class represents a specific type of Animal, namely a dog, and extends the Animal class.
 * It includes additional attributes specific to dogs, such as the breed.
 */
public class Dog extends Animal {

    /**
     * The breed of the dog.
     */
    private String breed;

    /**
     * Constructs a Dog object with the specified attributes, including the name, species, age, price, and breed.
     *
     * @param name    the name of the dog.
     * @param species the species of the dog.
     * @param age     the age of the dog.
     * @param price   the price of the dog.
     * @param breed   the breed of the dog.
     */
    public Dog(String name, String species, int age, double price, String breed) {
        super(name, species, age, price);
        this.breed = breed;
    }

    /**
     * Gets the breed of the dog.
     *
     * @return the breed of the dog.
     */
    public String getBreed() {
        return breed;
    }

    /**
     * Sets the breed of the dog.
     *
     * @param breed the new breed of the dog.
     */
    public void setBreed(String breed) {
        this.breed = breed;
    }

    /**
     * Returns a string representation of the Dog object, including its name, species, age, price, and breed.
     *
     * @return a string representation of the Dog object.
     */
    @Override
    public String toString() {
        return super.toString() + "Breed: " + breed + "\n";
    }
}
