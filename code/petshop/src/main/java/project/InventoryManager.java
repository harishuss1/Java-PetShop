package project;

import java.util.ArrayList;
import java.util.List;

public class InventoryManager {

   private List<Animal> animals;

   public InventoryManager() {
       this.animals = new ArrayList<>();
   }

   public void addAnimal(Animal animal) {
       this.animals.add(animal);
   }

   public void updateAnimal(Animal oldAnimal, Animal newAnimal) {
       int index = this.animals.indexOf(oldAnimal);
       if (index != -1) {
           this.animals.set(index, newAnimal);
       }
   }

   public void removeAnimal(Animal animal) {
       this.animals.remove(animal);
   }

   public void viewAnimal(Animal animal) {
       if (this.animals.contains(animal)) {
           System.out.println(animal);
       } else {
           System.out.println("Animal not found in inventory.");
       }
   }

   public void viewAllAnimals() {
       for (Animal animal : this.animals) {
           System.out.println(animal);
       }
   }
}
