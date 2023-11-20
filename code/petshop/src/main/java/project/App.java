package project;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
final static Scanner scanner =  new Scanner(System.in);

    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
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
                break;
            case 2:
                break;
            case 3:
                System.out.println("Exiting the virtual petShop. See you next time!");
                break;
            default:
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
}
