package project;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import static project.Console.*;

public class Helper {

    final static Scanner scanner = new Scanner(System.in);
    String promoPath = "code/petshop/src/main/resources/promo.csv";
    String adminPath = "code/petshop/src/main/resources/admin.csv";
    String animalPath = "code/petshop/src/main/resources/animals.csv";
    FileHandler fileHandler = new FileHandler();
    InventoryManager inventoryManager = new InventoryManager();

    User user = new User(null, null, 0);

    public static Animal getAnimalDetailsFromUser() {
        System.out.println("Enter new name:");
        String name = scanner.nextLine();
        System.out.println("Enter new species:");
        String species = scanner.nextLine();
        System.out.println("Enter new age:");
        int age = scanner.nextInt();
        System.out.println("Enter new price:");
        double price = scanner.nextDouble();
        scanner.nextLine();

        return new Animal(name, species, age, price);
    }

    public void addAnimal() throws IOException {
        Animal addedAnimal = getAnimalDetailsFromUser();

        inventoryManager.addAnimal(addedAnimal);
        fileHandler.writeAnimal(addedAnimal, animalPath);

        System.out.println("Animal added successfully!");

        spacing();
        // ManageInventory();
    }

    public void updateAnimal() throws IOException {
        System.out.println("Updating an Animal:");
        System.out.println("Enter the name of the animal to update:");
        String oldName = scanner.nextLine();

        Animal newAnimal = getAnimalDetailsFromUser(); // Gather updated information
        inventoryManager.updateAnimal(oldName, newAnimal);
        fileHandler.deleteAnimal(oldName, animalPath);
        fileHandler.writeAnimal(newAnimal, animalPath);

        System.out.println("Animal updated successfully!");

        spacing();
        // ManageInventory();
    }

    public void removeAnimal() throws IOException {
        System.out.println("Removing an Animal:");
        System.out.println("Enter the name of the animal to remove:");
        String name = scanner.nextLine();

        boolean removed = inventoryManager.removeAnimal(name);

        if (removed) {
            fileHandler.deleteAnimal(name, animalPath);
            System.out.println("Animal removed successfully!");
        } else {
            System.out.println("Animal not found in inventory.");
        }

        spacing();
        // ManageInventory();
    }

    public void viewAllAnimals() throws IOException {
        // inventoryManager.loadAnimals(fileHandler.loadAnimals());
        inventoryManager.viewAllAnimals();
    }

    public void addPromoCode() throws IOException {
        System.out.println("New code: ");
        String codeToAdd = scanner.nextLine();

        System.out.println("Discount: ");
        int discount = validDiscount();

        // fix
        scanner.nextLine();

        fileHandler.writePromoCode(codeToAdd, discount, promoPath);

        System.out.println("Promocode added sucessfully!");

        spacing();
    }

    public void updateDiscountPromoCode() throws IOException {
        System.out.println("Update code: ");
        String codeToUpdate = scanner.nextLine();

        System.out.println("Updated Discount: ");
        int discount = validDiscount();

        // fix
        scanner.nextLine();

        fileHandler.updatePromoCode(codeToUpdate, discount, promoPath);

        spacing();
    }

    public void removePromoCode() throws IOException {
        System.out.println("Delete code: ");
        String codeToDelete = scanner.nextLine();

        fileHandler.deletePromoCode(codeToDelete, promoPath);

        spacing();
    }

    public void viewPromoCode() throws IOException {
        fileHandler.prntPromo(promoPath);
    }

    public static int validDiscount() {
        int discount = 0;
        boolean isValidInput = false;

        while (!isValidInput) {
            try {
                discount = scanner.nextInt();

                if (discount >= 1 && discount <= 99) {
                    isValidInput = true;
                } else {
                    System.out.println("Discount must be between 1 to 99. Please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.next();
            }
        }

        return discount;
    }

    public void addAdmin() throws IOException {
        System.out.println("New admin: ");
        String adminToAdd = scanner.nextLine();

        System.out.println("Password: ");
        String password = scanner.nextLine();

        fileHandler.writeAdmin(adminToAdd, password, adminPath);

        System.out.println("Admin added sucessfully!");

        spacing();
    }

    public void updateAdmin() throws IOException {
        System.out.println("Update admin: ");
        String adminToUpdate = scanner.nextLine();

        System.out.println("Updated Password: ");
        String newPassword = scanner.nextLine();

        fileHandler.updateAdmin(adminToUpdate, newPassword, adminPath);

        spacing();
    }

    public void removeAdmin() throws IOException {
        System.out.println("Delete admin: ");
        String adminToDelete = scanner.nextLine();

        fileHandler.deleteAdmin(adminToDelete, adminPath);

        spacing();
    }

    public void viewAdmin() throws IOException {
        fileHandler.prntAdmin(adminPath);
    }

    public void adminLogin() throws IOException {
        // variables
        boolean successfulLogin = false;
        int tries = 3;

        // while not successful username and password
        while (!successfulLogin) {
            if (tries > 0) {
                // ask the important questions
                System.out.println("Username:");
                String username = scanner.nextLine();
                System.out.println("Password: ");
                String password = scanner.nextLine();

                // if username and password match success is true otherwise incorrect
                if ((fileHandler.matchingAdmin(username, password, adminPath))) {
                    successfulLogin = true;
                } else {
                    // tries + 1
                    tries--;
                    spacing();
                    System.out.println("Incorrect, " + tries + " attempts left");
                }
            } else {
                System.out.println("You have been locked out");
                spacing();
                System.exit(1);
            }
        }
    }
}
