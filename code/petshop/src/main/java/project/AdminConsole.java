package project;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class AdminConsole extends Console {
    final static Scanner scanner = new Scanner(System.in);
    String promoPath = "code/petshop/src/main/resources/promo.csv";
    String adminPath = "code/petshop/src/main/resources/admin.csv";
    String animalPath = "code/petshop/src/main/resources/animals.csv";
    FileHandler fileHandler = new FileHandler();
    Helper helper = new Helper();
    InventoryManager inventoryManager = new InventoryManager();

    User user = new User(null, null, 0);

    @Override
    public void loginSystem() throws IOException {
        System.out.println("Admin login");
        helper.adminLogin();
        spacing();
    }

    @Override
    public void displayMainMenu() throws IOException {
        System.out.println("Menu:");
        System.out.println("1. Manage inventory");
        System.out.println("2. Manage promo code");
        System.out.println("3. Manage admins");
        System.out.println("4. Exit");
        spacing();

        int choice = getUserChoice();
        // scanner.nextLine();
        switch ((choice)) {
            case 1:
                spacing();
                ManageInventory();
                displayMainMenu();
                break;
            case 2:
                spacing();
                ManagePromoCodes();
                displayMainMenu();
                break;
            case 3:
                spacing();
                ManageAdmins();
                displayMainMenu();
                break;
            case 4:
                spacing();
                System.out.println("Exiting the virtual petShop. See you next time!");
                break;
            default:
                spacing();
                System.out.println("Invalid choice. Please try again.");
                displayMainMenu();
                break;
        }
    }

    public void ManageInventory() throws IOException {
        System.out.println("Managing Inventory:");
        System.out.println("1. Add an Animal");
        System.out.println("2. Update an Animal");
        System.out.println("3. Remove an Animal");
        System.out.println("4. View Animals");
        System.out.println("5. Return to Menu");

        inventoryManager.loadAnimals(fileHandler.loadAnimals());

        int choice = getUserChoice();
        switch (choice) {
            case 1:
                spacing();
                helper.addAnimal();
                break;
            case 2:
                spacing();
                helper.updateAnimal();
                break;
            case 3:
                spacing();
                helper.removeAnimal();
                break;
            case 4:
                spacing();
                helper.viewAllAnimals();
                break;
            case 5:
                spacing();
                displayMainMenu();
                break;
            default:
                spacing();
                System.out.println("Invalid choice. Please try again.");
                ManageInventory();
                break;
        }
    }

    public void ManagePromoCodes() throws IOException {
        System.out.println("Managing Promocode:");
        System.out.println("1. Add a Promocode");
        System.out.println("2. Update a Promocode");
        System.out.println("3. Remove a Promocode");
        System.out.println("4. View Promos");
        System.out.println("5. Return to Menu");

        int choice = getUserChoice();
        switch (choice) {
            case 1:
                spacing();
                helper.addPromoCode();
                break;
            case 2:
                spacing();
                helper.updateDiscountPromoCode();
                break;
            case 3:
                spacing();
                helper.removePromoCode();
                break;
            case 4:
                spacing();
                helper.viewPromoCode();
                spacing();
                break;
            case 5:
                spacing();
                break;
            default:
                spacing();
                System.out.println("Invalid choice. Please try again.");
                ManagePromoCodes();
                break;
        }
    }

    public void ManageAdmins() throws IOException {
        System.out.println("Managing Admins:");
        System.out.println("1. Add an admin");
        System.out.println("2. Update an admin");
        System.out.println("3. Remove an admin");
        System.out.println("4: View all admins");
        System.out.println("5. Return to Menu");

        int choice = getUserChoice();
        switch (choice) {
            case 1:
                spacing();
                helper.addAdmin();
                break;
            case 2:
                spacing();
                helper.updateAdmin();
                break;
            case 3:
                spacing();
                helper.removeAdmin();
                break;
            case 4:
                spacing();
                helper.viewAdmin();
                spacing();
                break;
            case 5:
                spacing();
                break;
            default:
                spacing();
                System.out.println("Invalid choice. Please try again.");
                ManageAdmins();
                break;
        }
    }

}

    private Animal getAnimalDetailsFromUser(String species) {
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

    private void addAnimal() throws IOException {
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
        ManageInventory();
    }

    private void updateAnimal() throws IOException {
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
        ManageInventory();
    }

    private void removeAnimal() throws IOException {
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
        ManageInventory();
    }

    private void viewAllAnimals() throws IOException {
        // inventoryManager.loadAnimals(fileHandler.loadAnimals());
        inventoryManager.viewAllAnimals();
    }

    private void addPromoCode() throws IOException {
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

    private void updateDiscountPromoCode() throws IOException {
        System.out.println("Update code: ");
        String codeToUpdate = scanner.nextLine();

        System.out.println("Updated Discount: ");
        int discount = validDiscount();

        // fix
        scanner.nextLine();

        fileHandler.updatePromoCode(codeToUpdate, discount, promoPath);

        spacing();
    }

    private void removePromoCode() throws IOException {
        System.out.println("Delete code: ");
        String codeToDelete = scanner.nextLine();

        fileHandler.deletePromoCode(codeToDelete, promoPath);

        spacing();
    }

    private void viewPromoCode() throws IOException {
        fileHandler.prntPromo(promoPath);
    }

    private int validDiscount() {
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

    private void addAdmin() throws IOException {
        System.out.println("New admin: ");
        String adminToAdd = scanner.nextLine();

        System.out.println("Password: ");
        String password = scanner.nextLine();

        fileHandler.writeAdmin(adminToAdd, password, adminPath);

        System.out.println("Admin added sucessfully!");

        spacing();
    }

    private void updateAdmin() throws IOException {
        System.out.println("Update admin: ");
        String adminToUpdate = scanner.nextLine();

        System.out.println("Updated Password: ");
        String newPassword = scanner.nextLine();

        fileHandler.updateAdmin(adminToUpdate, newPassword, adminPath);

        spacing();
    }

    private void removeAdmin() throws IOException {
        System.out.println("Delete admin: ");
        String adminToDelete = scanner.nextLine();

        fileHandler.deleteAdmin(adminToDelete, adminPath);

        spacing();
    }

    private void viewAdmin() throws IOException {
        fileHandler.prntAdmin(adminPath);
    }

    private void adminLogin() throws IOException {
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
