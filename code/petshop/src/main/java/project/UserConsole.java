package project;

// import java.util.InputMismatchException;
import java.util.Scanner;

public class UserConsole extends Console {
    final static Scanner scanner = new Scanner(System.in);

    User user = new User(null, null, 0);

    @Override
    public void loginSystem() {
        System.out.println("Username:");
        String username = scanner.nextLine();
        user.setUsername(username);
        System.out.println(user);
        spacing();
    }

    @Override
    public void displayMainMenu() {
        System.out.println("Menu:");
        System.out.println("1. View all animals");
        System.out.println("2. View by category");
        System.out.println("3. View cart");
        System.out.println("4. Exit");
        spacing();
    }

}
