package project;

import java.util.Scanner;

public class AdminConsole extends Console {
    final static Scanner scanner = new Scanner(System.in);
    
    User user = new User(null, null, 0);

    protected InventoryManager inventoryManager;

    @Override
    public void loginSystem() {
        System.out.println("Admin login");
        System.out.println("Username:");
        String username = scanner.nextLine();
        user.setUsername(username);
        spacing();
    }

    @Override
    public void displayMainMenu() {
        System.out.println("Menu:");
        System.out.println("1. Manage inventory");
        System.out.println("2. Manage promo code");
        System.out.println("3. Exit");
        spacing();

        int choice = getUserChoice();
        scanner.nextLine();
        switch ((choice)) {
            case 1:
                ManageInventory();
                break;
            case 2:
                ManagePromoCodes();
                break;
            
            default:
                System.out.println("Invalid choice. Please try again.");
                displayMainMenu();
                break;
        }
    }

    public void ManageInventory() {
        System.out.println("Manging Inventory:");
        System.out.println("1. Add an Animal");
        System.out.println("2. Update an Animal");
        System.out.println("3. Remove an Animal");
        System.out.println("4. View Animals");
        System.out.println("5. Return to Menu");

        int choice = getUserChoice();
        switch (choice) {
            case 1:
                addAnimal();
                break;
            case 2:
                updateAnimal();
                break;
            case 3:
                removeAnimal();
                break;
            case 4:
                InventoryManager inventoryManager =  new InventoryManager();
                inventoryManager.viewAllAnimals();
                break;
            case 5:
                displayMainMenu();
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                ManageInventory();
                break;
        }
    }

    public void ManagePromoCodes() {
        System.out.println("Manging Inventory:");
        System.out.println("1. Add a Promocode");
        System.out.println("2. Update a Promocode");
        System.out.println("3. Remove a Promocode");
        System.out.println("4. View Promos");
        System.out.println("5. Return to Menu");

        int choice = getUserChoice();
        switch (choice) {
            case 1:
                
                break;
            case 2:

                break;
            case 3:

                break;
            case 4:

                break;
            default:
            
                break;
        }
    }

    private Animal getAnimalDetailsFromUser() {
        System.out.println("Enter new name:");
        String name = scanner.nextLine();
        System.out.println("Enter new species:");
        String species = scanner.nextLine();
        System.out.println("Enter new age:");
        int age = scanner.nextInt();
        System.out.println("Enter new price:");
        double price = scanner.nextDouble();
        scanner.nextLine(); 
    
        return new Animal(name, species, age, price);
    }
    
    private void addAnimal() {
        Animal addedAnimal = getAnimalDetailsFromUser();

        inventoryManager.addAnimal(addedAnimal);
        System.out.println("Animal added successfully!");
    
        spacing();
        ManageInventory();
    }
    
    private void updateAnimal() {
        System.out.println("Updating an Animal:");
        System.out.println("Enter the name of the animal to update:");
        String oldName = scanner.nextLine();
    
        Animal newAnimal = getAnimalDetailsFromUser(); // Gather updated information
        inventoryManager.updateAnimal(oldName, newAnimal);
    
        System.out.println("Animal updated successfully!");
    
        spacing();
        ManageInventory();
    }
    
    
    private void removeAnimal() {
        System.out.println("Removing an Animal:");
        System.out.println("Enter the name of the animal to remove:");
        String name = scanner.nextLine();
    
        boolean removed = inventoryManager.removeAnimal(name);
    
        if (removed) {
            System.out.println("Animal removed successfully!");
        } else {
            System.out.println("Animal not found in inventory.");
        }
    
        spacing();
        ManageInventory();
    }
    
}
