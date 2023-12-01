package project;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class AdminConsole extends Console {
    final static Scanner scanner = new Scanner(System.in);
    String promoPath = "code/petshop/src/main/resources/promo.csv";
    String adminPath = "code/petshop/src/main/resources/admin.csv";
    String animalPath = "code/petshop/src/main/resources/animals.csv";
    FileHandler fileHandler = new FileHandler();
    Helper helper = new Helper();
    InventoryManager inventoryManager = new InventoryManager();

    User user = new User(null, null, 0);

    @Override
    public void loginSystem() throws IOException {
        System.out.println("Admin login");
        helper.adminLogin();
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

        // inventoryManager.loadAnimals(fileHandler.loadAnimals());

        int choice = getUserChoice();
        switch (choice) {
            case 1:
                spacing();
                helper.addAnimal();
                break;
            case 2:
                spacing();
                helper.updateAnimal();
                break;
            case 3:
                spacing();
                helper.removeAnimal();
                break;
            case 4:
                spacing();
                helper.viewAllAnimals();
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
                helper.addPromoCode();
                break;
            case 2:
                spacing();
                helper.updateDiscountPromoCode();
                break;
            case 3:
                spacing();
                helper.removePromoCode();
                break;
            case 4:
                spacing();
                helper.viewPromoCode();
                spacing();
                break;
            case 5:
                spacing();
                break;
            default:
                spacing();
                System.out.println("Invalid choice. Please try again.");
                ManagePromoCodes();
                break;
        }
    }

    public void ManageAdmins() throws IOException {
        System.out.println("Managing Admins:");
        System.out.println("1. Add an admin");
        System.out.println("2. Update an admin");
        System.out.println("3. Remove an admin");
        System.out.println("4: View all admins");
        System.out.println("5. Return to Menu");

        int choice = getUserChoice();
        switch (choice) {
            case 1:
                spacing();
                helper.addAdmin();
                break;
            case 2:
                spacing();
                helper.updateAdmin();
                break;
            case 3:
                spacing();
                helper.removeAdmin();
                break;
            case 4:
                spacing();
                helper.viewAdmin();
                spacing();
                break;
            case 5:
                spacing();
                break;
            default:
                spacing();
                System.out.println("Invalid choice. Please try again.");
                ManageAdmins();
                break;
        }
    }

}
