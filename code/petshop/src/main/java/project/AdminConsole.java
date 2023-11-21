package project;

import java.util.Scanner;

public class AdminConsole extends Console {
    final static Scanner scanner = new Scanner(System.in);

    User user = new User(null, null, 0);

    @Override
    public void loginSystem() {
        System.out.println("Admin login");
        System.out.println("Username:");
        String username = scanner.nextLine();
        user.setUsername(username);
        System.out.println(user);
        spacing();
    }

    @Override
    public void displayMainMenu() {
        System.out.println("Menu:");
        System.out.println("1. Manage inventory");
        System.out.println("2. Manage promo code");
        System.out.println("3. Exit");
        spacing();
    }
}
