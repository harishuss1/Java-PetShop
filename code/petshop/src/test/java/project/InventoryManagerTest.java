package project;

import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;

public class InventoryManagerTest {

    @Test
    public void testAddAnimal() {
        // Arrange
        InventoryManager inventoryManager = new InventoryManager();
        Animal animal = new Animal("Dog", "Mammal", 3, 50.0);

        // Act
        inventoryManager.addAnimal(animal);

        // Assert
        assertEquals(1, inventoryManager.getAnimals().size());
        assertEquals(animal, inventoryManager.getAnimals().get(0));
    }

    @Test
    public void testUpdateAnimal() {
        // Arrange
        InventoryManager inventoryManager = new InventoryManager();
        Animal oldAnimal = new Animal("Dog", "Mammal", 3, 50.0);
        Animal newAnimal = new Animal("Cat", "Mammal", 2, 30.0);
        inventoryManager.addAnimal(oldAnimal);

        // Act
        inventoryManager.updateAnimal("Dog", newAnimal);

        // Assert
        assertEquals(1, inventoryManager.getAnimals().size());
        assertEquals(newAnimal, inventoryManager.getAnimals().get(0));
    }

    @Test
    public void testRemoveAnimal() {
        // Arrange
        InventoryManager inventoryManager = new InventoryManager();
        Animal animal = new Animal("Dog", "Mammal", 3, 50.0);
        inventoryManager.addAnimal(animal);

        // Act
        boolean removed = inventoryManager.removeAnimal("Dog");

        // Assert
        assertTrue(removed);
        assertTrue(inventoryManager.getAnimals().isEmpty());
    }

    @Test
    public void testRemoveNonexistentAnimal() {
        // Arrange
        InventoryManager inventoryManager = new InventoryManager();

        // Act
        boolean removed = inventoryManager.removeAnimal("Cat");

        // Assert
        assertFalse(removed);
        assertTrue(inventoryManager.getAnimals().isEmpty());
    }

    @Test
    public void testViewAnimal() {
        // Arrange
        InventoryManager inventoryManager = new InventoryManager();
        Animal animal = new Animal("Dog", "Mammal", 3, 50.0);
        inventoryManager.addAnimal(animal);

        // Act
        inventoryManager.viewAnimal(animal);

        // Assert
        // Check console output manually or use a testing library for console output
    }

    @Test
    public void testViewAllAnimals() {
        // Arrange
        InventoryManager inventoryManager = new InventoryManager();
        Animal animal1 = new Animal("Dog", "Mammal", 3, 50.0);
        Animal animal2 = new Animal("Cat", "Mammal", 2, 30.0);
        inventoryManager.addAnimal(animal1);
        inventoryManager.addAnimal(animal2);

        // Act
        inventoryManager.viewAllAnimals();

        // Assert
        // Check console output manually or use a testing library for console output
    }

    @Test
    public void testGetAnimalByName() {
        // Arrange
        InventoryManager inventoryManager = new InventoryManager();
        Animal animal = new Animal("Dog", "Mammal", 3, 50.0);
        inventoryManager.addAnimal(animal);

        // Act
        Animal retrievedAnimal = inventoryManager.getAnimalByName("Dog");

        // Assert
        assertEquals(animal, retrievedAnimal);
    }

    @Test
    public void testGetNonexistentAnimalByName() {
        // Arrange
        InventoryManager inventoryManager = new InventoryManager();

        // Act
        Animal retrievedAnimal = inventoryManager.getAnimalByName("Cat");

        // Assert
        assertNull(retrievedAnimal);
    }

    @Test
    public void testSearchAnimals() {
        // Arrange
        InventoryManager inventoryManager = new InventoryManager();
        Animal animal1 = new Animal("Dog", "Mammal", 3, 50.0);
        Animal animal2 = new Animal("Cat", "Mammal", 2, 30.0);
        Animal animal3 = new Animal("Parrot", "Bird", 1, 20.0);
        inventoryManager.addAnimal(animal1);
        inventoryManager.addAnimal(animal2);
        inventoryManager.addAnimal(animal3);

        // Act
        inventoryManager.searchAnimals("Mammal");

        // Assert
        // Check console output manually or use a testing library for console output
    }
}
