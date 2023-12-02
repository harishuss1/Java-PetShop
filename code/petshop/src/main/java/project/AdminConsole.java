package project;

import java.io.IOException;
import java.util.Scanner;

/**
 * The AdminConsole class represents the console interface for administrative tasks.
 * It extends the Console class and provides methods for admin login and managing
 * inventory, promo codes, and admins.
 */
public class AdminConsole extends Console {
    final static Scanner scanner = new Scanner(System.in);
    String promoPath = "code/petshop/src/main/resources/promo.csv";
    String adminPath = "code/petshop/src/main/resources/admin.csv";
    String animalPath = "code/petshop/src/main/resources/animals.csv";
    FileHandler fileHandler = new FileHandler();
    Helper helper = new Helper();
    InventoryManager inventoryManager = new InventoryManager();

    User user = new User(null, null, 0);

    /**
     * Overrides the loginSystem method from the Console class to provide admin login functionality.
     *
     * @throws IOException if an I/O error occurs.
     */
    @Override
    public void loginSystem() throws IOException {
        System.out.println("Admin login");
        helper.adminLogin();
        spacing();
    }
    /**
     * Overrides the displayMainMenu method from the Console class to display the main menu
     * for administrative tasks.
     *
     * @throws IOException if an I/O error occurs.
     */
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
    /**
     * Provides functionality to manage the inventory, including adding, updating, removing,
     * and viewing animals.
     *
     * @throws IOException if an I/O error occurs.
     */
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
                break;
            default:
                spacing();
                System.out.println("Invalid choice. Please try again.");
                ManageInventory();
                break;
        }
    }
    /**
     * Provides functionality to manage promo codes, including adding, updating, removing,
     * and viewing promo codes.
     *
     * @throws IOException if an I/O error occurs.
     */
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
/**
     * Provides functionality to manage admins, including adding, updating, removing,
     * and viewing admins.
     *
     * @throws IOException if an I/O error occurs.
     */
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
