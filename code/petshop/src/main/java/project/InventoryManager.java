package project;

import java.util.ArrayList;
import java.util.List;

public class InventoryManager {

    private List<Animal> animals;

    public InventoryManager() {
        this.animals = new ArrayList<>(); // Initialize the animals list
    }

    public void loadAnimals(List<Animal> animals) {
        this.animals.clear();
        this.animals.addAll(animals);
    }

    public void addAnimal(Animal animal) {
        this.animals.add(animal);
    }

    public void updateAnimal(String oldName, Animal newAnimal) {
        for (int i = 0; i < animals.size(); i++) {
            if (animals.get(i).getName().equals(oldName)) {
                animals.set(i, newAnimal);
                break;
            }
        }
    }

    public boolean removeAnimal(String name) {
        for (Animal animal : animals) {
            if (animal.getName().equals(name)) {
                animals.remove(animal);
                return true;
            }
        }
        return false;
    }

    public void viewAnimal(Animal animal) {
        if (this.animals.contains(animal)) {
            System.out.println(animal);
        } else {
            System.out.println("Animal not found in inventory.");
        }
    }

    public void viewAllAnimals() {
        if (animals.isEmpty()) {
            System.out.println("No animals in inventory.");
        } else {
            System.out.println("All Animals in Inventory:\n");
            for (Animal animal : this.animals) {
                System.out.println(animal);
            }
        }
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public Animal getAnimalByName(String name) {
        for (Animal animal : animals) {
            if (animal.getName().equalsIgnoreCase(name)) {
                return animal;
            }
        }
        return null; // Animal not found
    }

    // Additional method for searching animals by species
    public void searchAnimals(String species) {
        for (Animal animal : animals) {
            if (animal.getSpecies().equalsIgnoreCase(species)) {
                System.out.println(animal);
            }
        }
    }
}
