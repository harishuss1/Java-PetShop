package project;

import org.junit.Test;
import static org.junit.Assert.*;

public class InventoryManagerTest {

    @Test
    public void testAddAnimal() {
        InventoryManager inventoryManager = new InventoryManager();
        Animal animal = new Animal("Dog", "Mammal", 3, 50.0);
        inventoryManager.addAnimal(animal);

        assertEquals(1, inventoryManager.getAnimals().size());
        assertEquals(animal, inventoryManager.getAnimals().get(0));
    }

    @Test
    public void testUpdateAnimal() {
        InventoryManager inventoryManager = new InventoryManager();
        Animal oldAnimal = new Animal("Dog", "Mammal", 3, 50.0);
        Animal newAnimal = new Animal("Cat", "Mammal", 2, 30.0);
        inventoryManager.addAnimal(oldAnimal);
        inventoryManager.updateAnimal("Dog", newAnimal);

        assertEquals(1, inventoryManager.getAnimals().size());
        assertEquals(newAnimal, inventoryManager.getAnimals().get(0));
    }

    @Test
    public void testRemoveAnimal() {
        InventoryManager inventoryManager = new InventoryManager();
        Animal animal = new Animal("Dog", "Mammal", 3, 50.0);
        inventoryManager.addAnimal(animal);
        boolean removed = inventoryManager.removeAnimal("Dog");

        assertTrue(removed);
        assertTrue(inventoryManager.getAnimals().isEmpty());
    }

    @Test
    public void testRemoveNonexistentAnimal() {
        InventoryManager inventoryManager = new InventoryManager();
        boolean removed = inventoryManager.removeAnimal("Cat");

        assertFalse(removed);
        assertTrue(inventoryManager.getAnimals().isEmpty());
    }

    @Test
    public void testViewAnimal() {
        // Arrange
        InventoryManager inventoryManager = new InventoryManager();
        Animal animal = new Animal("Dog", "Mammal", 3, 50.0);
        inventoryManager.addAnimal(animal);

        inventoryManager.viewAnimal(animal);

        
        //checkConsole
    }

    @Test
    public void testViewAllAnimals() {
        InventoryManager inventoryManager = new InventoryManager();
        Animal animal1 = new Animal("Dog", "Mammal", 3, 50.0);
        Animal animal2 = new Animal("Cat", "Mammal", 2, 30.0);
        inventoryManager.addAnimal(animal1);
        inventoryManager.addAnimal(animal2);
        inventoryManager.viewAllAnimals();

        // Check console
    }

    @Test
    public void testGetAnimalByName() {
        InventoryManager inventoryManager = new InventoryManager();
        Animal animal = new Animal("Dog", "Mammal", 3, 50.0);
        inventoryManager.addAnimal(animal);
        Animal retrievedAnimal = inventoryManager.getAnimalByName("Dog");

        assertEquals(animal, retrievedAnimal);
    }

    @Test
    public void testGetNonexistentAnimalByName() {
        InventoryManager inventoryManager = new InventoryManager();
        Animal retrievedAnimal = inventoryManager.getAnimalByName("Cat");

        assertNull(retrievedAnimal);
    }

    @Test
    public void testSearchAnimals() {
        InventoryManager inventoryManager = new InventoryManager();
        Animal animal1 = new Animal("Dog", "Mammal", 3, 50.0);
        Animal animal2 = new Animal("Cat", "Mammal", 2, 30.0);
        Animal animal3 = new Animal("Parrot", "Bird", 1, 20.0);
        inventoryManager.addAnimal(animal1);
        inventoryManager.addAnimal(animal2);
        inventoryManager.addAnimal(animal3);

        inventoryManager.searchAnimals("Mammal");

        // Assert
        // Check console 
    }
}
