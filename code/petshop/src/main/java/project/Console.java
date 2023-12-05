package project;

import java.io.IOException;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * The abstract Console class serves as the base class for both AdminConsole and UserConsole,
 * providing common functionality for handling input, displaying menus, and greeting the user.
 */
public abstract class Console {
    /**
     * Scanner object for reading input from the user.
     */
    final static Scanner scanner = new Scanner(System.in);
    /**
     * Displays a greeting message when the application starts.
     */
    public static void greet() {
        System.out.println(" __       __            __                                             \r\n" + //
                "|  \\  _  |  \\          |  \\                                            \r\n" + //
                "| $$ / \\ | $$  ______  | $$  _______   ______   ______ ____    ______  \r\n" + //
                "| $$/  $\\| $$ /      \\ | $$ /       \\ /      \\ |      \\    \\  /      \\ \r\n" + //
                "| $$  $$$\\ $$|  $$$$$$\\| $$|  $$$$$$$|  $$$$$$\\| $$$$$$\\$$$$\\|  $$$$$$\\\r\n" + //
                "| $$ $$\\$$\\$$| $$    $$| $$| $$      | $$  | $$| $$ | $$ | $$| $$    $$\r\n" + //
                "| $$$$  \\$$$$| $$$$$$$$| $$| $$_____ | $$__/ $$| $$ | $$ | $$| $$$$$$$$\r\n" + //
                "| $$$    \\$$$ \\$$     \\| $$ \\$$     \\ \\$$    $$| $$ | $$ | $$ \\$$     \\\r\n" + //
                " \\$$      \\$$  \\$$$$$$$ \\$$  \\$$$$$$$  \\$$$$$$  \\$$  \\$$  \\$$  \\$$$$$$$");
        System.out.println();
    }
    /**
     * Displays the login menu for selecting whether to sign in as an admin, user, or exit the application.
     * Calls the appropriate login and main menu methods based on the user's choice.
     *
     * @throws IOException if an I/O error occurs.
     */
    public static void displayLoginMenu() throws IOException {
        System.out.println("Sign in:");
        System.out.println("1. Admin");
        System.out.println("2. User");
        System.out.println("3. Exit");

        int choice = getUserChoice();

        scanner.nextLine();
        switch (choice) {
            case 1:
                spacing();
                AdminConsole adminCSL = new AdminConsole();
                adminCSL.loginSystem();
                adminCSL.displayMainMenu();
                break;
            case 2:
                spacing();
                InventoryManager inventoryManager = new InventoryManager();
                UserConsole userCSL = new UserConsole(inventoryManager);
                userCSL.loginSystem();
                userCSL.displayMainMenu();
                break;
            case 3:
                spacing();
                System.out.println("Exiting the virtual petShop. See you next time!");
                break;
            default:
                spacing();
                System.out.println("Invalid choice. Please try again.");
                displayLoginMenu();
        }
    }
/**
     * Allows the user to choose the method to import animals, either through SQLHandler or FileHandler.
     * Calls the appropriate method based on the user's choice.
     *
     * @throws IOException  if an I/O error occurs.
     * @throws SQLException if a SQL-related error occurs.
     */
    public static void chooseImportMethod() throws IOException, SQLException {
        System.out.println("Choose the method to import animals:");
        System.out.println("1. SQLHandler");
        System.out.println("2. FileHandler");

        int choice = getUserChoice();

        switch (choice) {
            case 1:
                spacing();
                // Call SQLHandler to import animals
                SqlHandler sql = new SqlHandler();
                sql.loadAnimals();
                break;
            case 2:
                spacing();
                // Call FileHandler to import animals
                FileHandler fileHandler = new FileHandler();
                fileHandler.loadAnimals();
                break;
            default:
                spacing();
                System.out.println("Invalid choice. Please try again.");
                chooseImportMethod();
        }
    }
    /**
     * Gets the user's choice as an integer.
     *
     * @return the user's choice as an integer.
     */
    public static int getUserChoice() {
        int choice = 0;
        boolean isValidInput = false;

        while (!isValidInput) {
            try {
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();
                isValidInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();
            }
        }
        return choice;
    }
     /**
     * Prints a line to separate sections and improve readability.
     */
    public static void spacing() {
        System.out.println("===========================");
    }
    /**
     * Abstract method to be implemented by subclasses for displaying the main menu.
     *
     * @throws IOException if an I/O error occurs.
     */
    abstract void displayMainMenu() throws IOException;
    /**
     * Abstract method to be implemented by subclasses for handling the login process.
     *
     * @throws IOException if an I/O error occurs.
     */
    abstract void loginSystem() throws IOException;

}
