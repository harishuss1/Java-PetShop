package project;

import java.io.IOException;
import java.util.Scanner;

public class AdminConsole extends Console {
    final static Scanner scanner = new Scanner(System.in);
    String path = "code/petshop/src/main/resources/promo.csv";
    FileHandler fileHandler = new FileHandler();

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
    public void displayMainMenu() throws IOException {
        System.out.println("Menu:");
        System.out.println("1. Manage inventory");
        System.out.println("2. Manage promo code");
        System.out.println("3. Manage admins");
        System.out.println("4. Exit");
        spacing();

        int choice = getUserChoice();
        // scanner.nextLine();
        switch ((choice)) {
            case 1:
                spacing();
                ManageInventory();
                displayMainMenu();
                break;
            case 2:
                spacing();
                ManagePromoCodes();
                displayMainMenu();
                break;
            case 3:
                spacing();
                ManageAdmins();
                displayMainMenu();
                break;
            case 4:
                spacing();
                System.out.println("Exiting the virtual petShop. See you next time!");
                break;
            default:
                spacing();
                System.out.println("Invalid choice. Please try again.");
                displayMainMenu();
                break;
        }
    }

    public void ManageInventory() throws IOException {
        System.out.println("Managing Inventory:");
        System.out.println("1. Add an Animal");
        System.out.println("2. Update an Animal");
        System.out.println("3. Remove an Animal");
        System.out.println("4. View Animals");
        System.out.println("5. Return to Menu");

        int choice = getUserChoice();
        switch (choice) {
            case 1:
                spacing();
                addAnimal();
                break;
            case 2:
                spacing();
                updateAnimal();
                break;
            case 3:
                spacing();
                removeAnimal();
                break;
            case 4:
                spacing();
                InventoryManager inventoryManager = new InventoryManager();
                inventoryManager.viewAllAnimals();
                break;
            case 5:
                spacing();
                displayMainMenu();
                break;
            default:
                spacing();
                System.out.println("Invalid choice. Please try again.");
                ManageInventory();
                break;
        }
    }

    public void ManagePromoCodes() throws IOException {
        System.out.println("Managing Promocode:");
        System.out.println("1. Add a Promocode");
        System.out.println("2. Update a Promocode");
        System.out.println("3. Remove a Promocode");
        System.out.println("4. View Promos");
        System.out.println("5. Return to Menu");

        int choice = getUserChoice();
        switch (choice) {
            case 1:
                spacing();
                addPromoCode();
                break;
            case 2:
                spacing();
                // update promo
                break;
            case 3:
                spacing();
                System.out.println("Which code: ");
                String codeToDelete = scanner.nextLine();

                break;
            case 4:
                spacing();
                fileHandler.prntPromo(path);
                spacing();
                break;
            case 5:
                spacing();
                // displayMainMenu();
                break;
            default:
                spacing();
                System.out.println("Invalid choice. Please try again.");
                ManagePromoCodes();
                break;
        }
    }

    public void ManageAdmins() {
        System.out.println("Managing Admins:");
        System.out.println("1. Add an admin");
        System.out.println("2. Update an admin");
        System.out.println("3. Remove an admin");
        System.out.println("4. Return to Menu");

        int choice = getUserChoice();
        switch (choice) {
            case 1:
                spacing();
                // add admin
                break;
            case 2:
                spacing();
                // update admin
                break;
            case 3:
                spacing();
                // remove admin
                break;
            case 4:
                spacing();
                break;
            default:
                spacing();
                System.out.println("Invalid choice. Please try again.");
                ManageAdmins();
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

    private void addAnimal() throws IOException {
        Animal addedAnimal = getAnimalDetailsFromUser();

        inventoryManager.addAnimal(addedAnimal);
        System.out.println("Animal added successfully!");

        spacing();
        ManageInventory();
    }

    private void updateAnimal() throws IOException {
        System.out.println("Updating an Animal:");
        System.out.println("Enter the name of the animal to update:");
        String oldName = scanner.nextLine();

        Animal newAnimal = getAnimalDetailsFromUser(); // Gather updated information
        inventoryManager.updateAnimal(oldName, newAnimal);

        System.out.println("Animal updated successfully!");

        spacing();
        ManageInventory();
    }

    private void removeAnimal() throws IOException {
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

    private void addPromoCode() throws IOException {
        System.out.println("New code: ");
        String codeToAdd = scanner.nextLine();

        System.out.println("Discount: ");
        int discount = scanner.nextInt();

        fileHandler.writePromoCode(codeToAdd, discount, path);

        spacing();
        ManagePromoCodes();
    }

}
