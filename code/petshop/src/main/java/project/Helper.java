package project;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import static project.Console.*;
import java.util.ArrayList;
import java.util.List;

public class Helper {

    final static Scanner scanner = new Scanner(System.in);
    String promoPath = "code/petshop/src/main/resources/promo.csv";
    String adminPath = "code/petshop/src/main/resources/admin.csv";
    String animalPath = "code/petshop/src/main/resources/animals.csv";
    FileHandler fileHandler = new FileHandler();
    InventoryManager inventoryManager = new InventoryManager();

    User user = new User(null, null, 0);

    public Animal getAnimalDetailsFromUser(String species) {
        scanner.nextLine();
        System.out.println("Enter new name:");
        String name = scanner.nextLine();
        System.out.println("Enter new age:");
        int age = scanner.nextInt();
        System.out.println("Enter new price:");
        double price = scanner.nextDouble();
        scanner.nextLine();

        if (species.equals("Dog")) {
            System.out.println("Enter new breed:");
            String breed = scanner.nextLine();
            return new Dog(name, species, age, price, breed);
        } else if (species.equals("Cat")) {
            System.out.println("Does the cat have claws? (true/false)");
            boolean hasClaws = scanner.nextBoolean();
            return new Cat(name, species, age, price, hasClaws);
        } else if (species.equals("Fish")) {
            System.out.println("Enter new color:");
            String color = scanner.nextLine();
            return new Fish(name, species, age, price, color);
        } else if (species.equals("Parrot")) {
            System.out.println("Enter new feather color:");
            String featherColor = scanner.nextLine();
            return new Parrot(name, species, age, price, featherColor);
        } else {
            return new Animal(name, species, age, price);
        }
    }

    public void addAnimal() throws IOException {
        System.out.println("Select the type of animal to add:");
        System.out.println("1. Dog");
        System.out.println("2. Cat");
        System.out.println("3. Fish");
        System.out.println("4. Parrot");
        int choice = scanner.nextInt();

        String type;
        switch (choice) {
            case 1:
                type = "Dog";
                break;
            case 2:
                type = "Cat";
                break;
            case 3:
                type = "Fish";
                break;
            case 4:
                type = "Parrot";
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                addAnimal();
                return;
        }

        Animal addedAnimal = getAnimalDetailsFromUser(type);

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

        Animal oldAnimal = inventoryManager.getAnimalByName(oldName);

        if (oldAnimal == null) {
            System.out.println("Animal not found. Please try again.");
            updateAnimal();
            return;
        }

        String species = oldAnimal.getSpecies();

        Animal newAnimal = getAnimalDetailsFromUser(species); // Gather updated information
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

    public void removeCartAnimal(User user) throws IOException {
        List<Animal> cartList = user.getCart();

        for (Animal pet : cartList) {
            fileHandler.deleteAnimal(pet.getName(), animalPath);
        }
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

    public int validDiscount() {
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

    public void matchingPromo(String inputPromo, User user) throws IOException {
        // if username and password match success is true otherwise incorrect

        if ((fileHandler.matchingPromoCode(inputPromo, promoPath) != 0)) {
            double value = fileHandler.matchingPromoCode(inputPromo, promoPath);
            user.setPromoCode(value);
            System.out.println("Valid promo: " + value + "% OFF");
        } else {
            System.out.println("Invalid promo");
        }
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
