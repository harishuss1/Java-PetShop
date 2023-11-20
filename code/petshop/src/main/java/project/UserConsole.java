package project;

import java.util.Scanner;

public class UserConsole extends IConsole {
    final static Scanner scanner =  new Scanner(System.in);



    @Override

    public void displayMainMenu() {
       System.out.println("Welcome to the Application!");
       System.out.println("1. View Our Animals");
       System.out.println("2. Search for inventory");
       System.out.println("3. View Our Promos");
       System.out.println("4. Exit");

        

        int choice = getUserChoice();
        scanner.nextLine();
        switch (choice) {
            case 1:
                //Call view Inventory 

                break;
            case 2:
                //Call a searchinventory method
                break;
            case 3:
                //Call viewPromos.
                break;
            case 4:
                System.exit(1);
                break;

            default:
                System.out.println("Invalid choice. Please try again.");
                displayMainMenu();
        }
    }
    
    
}
