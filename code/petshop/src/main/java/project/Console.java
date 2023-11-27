package project;

import java.io.IOException;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public abstract class Console {
    final static Scanner scanner = new Scanner(System.in);

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

    public static void displayLoginMenu() {
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
                UserConsole userCSL = new UserConsole();
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

    public static void spacing() {
        System.out.println("===========================");
    }

    abstract void displayMainMenu();

    abstract void loginSystem();

}
