package project;

public class Cat extends Animal {

    private boolean hasClaws;

    public Cat(String name, String species,int age, double price, boolean hasClaws) {
        super(name, species, age, price);
        this.hasClaws = hasClaws;
    }

    public boolean hasClaws() {
        return hasClaws;
    }

    public void setHasClaws(boolean hasClaws) {
        this.hasClaws = hasClaws;
    }

    @Override
    public String toString() {
        return super.toString() + "Has Claws: " + hasClaws()+"\n";
    }
}
