package project;

public class Dog extends Animal {

    private String breed;

    public Dog(String name,String species, int age, double price, String breed) {
        super(name, species, age, price);
        this.breed = breed;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    @Override
    public String toString() {
        return super.toString() + "\nBreed: " + breed;
    }
}
