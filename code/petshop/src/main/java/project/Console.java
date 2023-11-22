package project;

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
