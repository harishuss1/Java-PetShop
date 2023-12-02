package project;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/**
 * Manages the inventory of animals, providing methods to add, update, remove, and view animals.
 */
public class InventoryManager {

    private List<Animal> animals;
    private FileHandler fileHandler;
    /**
     * Constructs an InventoryManager and initializes the list of animals by loading data from a file.
     */
    public InventoryManager() {
        this.animals = new ArrayList<>();
        this.fileHandler = new FileHandler();
        loadAnimals();
    }
    /**
     * Loads animals from a file using the associated FileHandler.
     */
    public void loadAnimals() {
        try {
            this.animals = fileHandler.loadAnimals();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * Adds a new animal to the inventory.
     *
     * @param animal the animal to be added.
     */
    public void addAnimal(Animal animal) {
        this.animals.add(animal);
    }
    /**
     * Updates an existing animal in the inventory.
     *
     * @param oldName   the name of the animal to be updated.
     * @param newAnimal the updated animal.
     */
    public void updateAnimal(String oldName, Animal newAnimal) {
        for (int i = 0; i < animals.size(); i++) {
            if (animals.get(i).getName().equals(oldName)) {
                animals.set(i, newAnimal);
                break;
            }
        }
    }
    /**
     * Removes an animal from the inventory by its name.
     *
     * @param name the name of the animal to be removed.
     * @return true if the animal was successfully removed, false otherwise.
     */
    public boolean removeAnimal(String name) {
        for (Animal animal : animals) {
            if (animal.getName().equals(name)) {
                animals.remove(animal);
                return true;
            }
        }
        return false;
    }
    /**
     * Displays the details of a specific animal.
     *
     * @param animal the animal to be viewed.
     */
    public void viewAnimal(Animal animal) {
        if (this.animals.contains(animal)) {
            System.out.println(animal);
        } else {
            System.out.println("Animal not found in inventory.");
        }
    }
    /**
     * Displays the details of all animals in the inventory.
     */

    public void viewAllAnimals() {
        if (animals.isEmpty()) {
            System.out.println("No animals in inventory.");
        } else {
            System.out.println("All Animals in Inventory:");
            for (Animal animal : this.animals) {
                System.out.println(animal);
            }
        }
    }
    /**
     * Retrieves the list of animals in the inventory.
     *
     * @return the list of animals.
     */
    public List<Animal> getAnimals() {
        return animals;
    }
    /**
     * Retrieves an animal from the inventory based on its name.
     *
     * @param name the name of the animal to be retrieved.
     * @return the animal with the specified name, or null if not found.
     */
    public Animal getAnimalByName(String name) {
        for (Animal animal : animals) {
            if (animal.getName().equalsIgnoreCase(name)) {
                return animal;
            }
        }
        return null; // Animal not found
    }

    /**
     * Searches for and displays animals in the inventory based on their species.
     *
     * @param species the species of animals to be searched.
     */
    public void searchAnimals(String species) {
        for (Animal animal : animals) {
            if (animal.getSpecies().equalsIgnoreCase(species)) {
                System.out.println(animal);
            }
        }
    }
     /**
     * Checks if an animal with a specified name exists in the inventory.
     *
     * @param name the name of the animal to be checked.
     * @return true if the animal exists, false otherwise.
     */
    public boolean animalExists(String name) {
        for (Animal animal : animals) {
            if (animal.getName().equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }

}
