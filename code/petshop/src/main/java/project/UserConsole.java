package project;

import java.io.IOException;
import java.util.Scanner;

public class UserConsole extends Console {

    private User user = new User(null, null, 0);
    // private InventoryManager inventoryManager;
    FileHandler fileHandler = new FileHandler();
    InventoryManager inventoryManager = new InventoryManager();

    // Constructor to set the InventoryManager
    public UserConsole(InventoryManager inventoryManager) {
        this.inventoryManager = inventoryManager;
    }

    @Override
    public void loginSystem() {
        System.out.println("Username:");
        String username = scanner.nextLine();
        user.setUsername(username);
        spacing();
    }

    @Override
    public void displayMainMenu() {
        System.out.println("Welcome to the Application, " + user.getUsername() + "!");
        System.out.println("1. View Our Animals");
        System.out.println("2. Search for inventory");
        System.out.println("3. Apply Promo Code");
        System.out.println("4. View Cart");
        System.out.println("5. Add to Cart");
        System.out.println("6. Exit");
        spacing();

        int choice = getUserChoice();
        try {
            inventoryManager.loadAnimals(fileHandler.loadAnimals());
        } catch (IOException e) {
            System.out.println("There's an issue with loading the animals");
        }
        switch (choice) {
            case 1:
                viewAnimals();
                break;
            case 2:
                searchInventory();
                break;
            case 3:
                applyPromoCode();
                break;
            case 4:
                viewCart();
                break;
            case 5:
                addToCart();
                break;
            case 6:
                System.exit(1);
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                displayMainMenu();
        }
    }

    private void viewAnimals() {
        System.out.println("Viewing Animals:");
        inventoryManager.viewAllAnimals();
        spacing();
        displayMainMenu();
    }

    private void searchInventory() {
        System.out.println("Searching for inventory:");
        System.out.println("Enter species to search:");
        scanner.nextLine();
        String species = scanner.nextLine();
        
        inventoryManager.searchAnimals(species);
        spacing();
        displayMainMenu();
    }

    private void applyPromoCode() {
        System.out.println("Applying Promo Code:");
        System.out.println("Enter promo code:");

        try {
            String promoCode = scanner.nextLine();
            user.setPromoCode(Double.parseDouble(promoCode));
            System.out.println("Promo code applied successfully!");
        } catch (NumberFormatException e) {
            System.out.println("Invalid promo code format. Please enter a valid numeric value.");
        }

        spacing();
        displayMainMenu();
    }

    private void viewCart() {
        System.out.println("Viewing Cart:");
        user.viewCart();
        spacing();
        displayMainMenu();
    }
    

    private void addToCart() {
        System.out.println("Adding to Shopping Cart:");
        scanner.nextLine();  // Consume the newline character
    
        System.out.println("Enter the name of the animal to add to your cart:");
        String animalName = scanner.nextLine();
    
        // Find the animal in the inventory by name
        Animal selectedAnimal = inventoryManager.getAnimalByName(animalName);
    
        if (selectedAnimal != null) {
            // Add the selected animal to the user's cart
            user.addToCart(selectedAnimal);
            System.out.println(animalName + " added to your cart!");
        } else {
            System.out.println("Animal not found in inventory.");
        }
    
        spacing();
        displayMainMenu();
    }
    

    
}
