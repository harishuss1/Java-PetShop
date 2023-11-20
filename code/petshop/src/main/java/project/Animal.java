package project;


public class Animal {

    private String name;
    private String species;
    private int age;
    private double price;

    public Animal(String name, String species, int age, double price) {
        this.name = name;
        this.species = species;
        this.age = age;
        this.price = price;
    }


    public String getName() {
        return name;
    }
    public String getSpecies() {
        return species;
    }
    public int getAge() {
        return age;
    }
    public double getPrice() {
        return price;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    public void setSpecies(String species) {
        this.species = species;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setPrice(double price) {
        this.price = price;
    }

}
