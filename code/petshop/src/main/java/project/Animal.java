package project;

/**
 * The Animal class represents a generic animal with basic attributes such as name, species, age, and price.
 * It provides methods to get and set these attributes and a toString method for displaying detailed information.
 */
public class Animal {

    private String name;
    private String species;
    private int age;
    private double price;
    /**
     * Constructs an Animal object with the specified name, species, age, and price.
     *
     * @param name    the name of the animal.
     * @param species the species of the animal.
     * @param age     the age of the animal.
     * @param price   the price of the animal.
     */
    public Animal(String name, String species, int age, double price) {
        this.name = name;
        this.species = species;
        this.age = age;
        this.price = price;
    }


    /**
     * Gets the name of the animal.
     *
     * @return the name of the animal.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the species of the animal.
     *
     * @return the species of the animal.
     */
    public String getSpecies() {
        return species;
    }

    /**
     * Gets the age of the animal.
     *
     * @return the age of the animal.
     */
    public int getAge() {
        return age;
    }

    /**
     * Gets the price of the animal.
     *
     * @return the price of the animal.
     */
    public double getPrice() {
        return price;
    }

    /**
     * Sets the name of the animal.
     *
     * @param name the new name for the animal.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the species of the animal.
     *
     * @param species the new species for the animal.
     */
    public void setSpecies(String species) {
        this.species = species;
    }

    /**
     * Sets the age of the animal.
     *
     * @param age the new age for the animal.
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Sets the price of the animal.
     *
     * @param price the new price for the animal.
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Returns a string representation of the Animal object, including detailed information
     * such as name, species, age, and price.
     *
     * @return a string representation of the Animal object.
     */
    public String toString() {
        return "Animal Details:\n" +
                "Name: " + name + "\n" +
                "Species: " + species + "\n" +
                "Age: " + age + " years\n" +
                "Price: $" + price +
                "\n";
    }
}