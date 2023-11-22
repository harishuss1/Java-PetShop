package project;

import java.util.Scanner;

public class UserConsole extends Console {
    final static Scanner scanner = new Scanner(System.in);

    User user = new User(null, null, 0);

    @Override
    public void loginSystem() {
        System.out.println("Username:");
        String username = scanner.nextLine();
        user.setUsername(username);
        spacing();
    }

    @Override
    public void displayMainMenu() {
        System.out.println("Welcome to the Application!");
        System.out.println("1. View Our Animals");
        System.out.println("2. Search for inventory");
        System.out.println("3. Apply Promo Code");
        System.out.println("4. View Cart");
        System.out.println("5. Exit");
        spacing();

        int choice = getUserChoice();

        switch (choice) {
            case 1:
                // Call view Inventory
                break;
            case 2:
                // Call a searchinventory method
                break;
            case 3:
                // Call viewPromos.
                break;
            case 4:
                System.out.println(user);
                break;
            case 5:
                System.exit(1);
                break;

            default:
                System.out.println("Invalid choice. Please try again.");
                displayMainMenu();
        }
    }

}
