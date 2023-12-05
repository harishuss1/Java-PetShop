package project;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import static project.Console.*;

/**
 * Helper class for various operations in the virtual pet shop.
 */
public class Helper {

    final static Scanner scanner = new Scanner(System.in);
    String promoPath = "code/petshop/src/main/resources/promo.csv";
    String adminPath = "code/petshop/src/main/resources/admin.csv";
    String animalPath = "code/petshop/src/main/resources/animals.csv";
    FileHandler fileHandler = new FileHandler();
    InventoryManager inventoryManager = new InventoryManager();
    Validation valid = new Validation();
    User user = new User(null, null, 0);
    /**
     * This method gets the details of an animal from the user.
     * It checks if an animal with the same name already exists.
     * If it does, it asks the user to enter a different name.
     * It then asks the user to enter the age and price of the animal.
     * Depending on the species of the animal, it asks the user to enter additional details.
     *
     * @param species the species of the animal
     * @return the new animal
     */
    public Animal getAnimalDetailsFromUser(String species) {
        String name = valid.getStringInput("Enter new name:");

        if (inventoryManager.animalExists(name)) {
            System.out.println("An animal with the same name already exists. Please choose a different name.");
            return getAnimalDetailsFromUser(species);
        }

        int age = valid.getPositiveInteger("Enter new age:");
        double price = valid.getPositiveDouble("Enter new price:");

        if (species.equals("Dog")) {
            // System.out.println("Enter new breed:");
            String breed = valid.getStringInput("Enter new breed:");
            return new Dog(name, species, age, price, breed);
        } else if (species.equals("Cat")) {
            // System.out.println("Does the cat have claws? (true/false)");
            boolean hasClaws = valid.getValidBoolean("Does the cat have claws? (true/false)");
            return new Cat(name, species, age, price, hasClaws);
        } else if (species.equals("Fish")) {
            // System.out.println("Enter new color:");

            String color = valid.getStringInput("Enter new color:");
            return new Fish(name, species, age, price, color);
        } else if (species.equals("Parrot")) {
            // System.out.println("Enter new feather color:");

            String featherColor = valid.getStringInput("Enter new feather color:");
            return new Parrot(name, species, age, price, featherColor);
        } else {
            return new Animal(name, species, age, price);
        }
    }
     /**
     * This method adds a new animal to the inventory.
     * It asks the user to select the type of animal to add.
     * It then gets the details of the animal from the user and adds the animal to the inventory.
     * It also writes the details of the animal to a file.
     *
     * @throws IOException if an I/O error occurs
     */
    public void addAnimal() throws IOException {
        System.out.println("Select the type of animal to add:");
        System.out.println("1. Dog");
        System.out.println("2. Cat");
        System.out.println("3. Fish");
        System.out.println("4. Parrot");
        int choice = scanner.nextInt();

        // scanner.nextLine();

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
    /**
     * This method updates the details of an existing animal in the inventory.
     * It asks the user to enter the name of the animal to update.
     * It then gets the new details of the animal from the user and updates the animal in the inventory.
     * It also updates the details of the animal in the file.
     *
     * @throws IOException if an I/O error occurs
     */
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

        Animal newAnimal = getAnimalDetailsFromUser(species);

        inventoryManager.updateAnimal(oldName, newAnimal);
        fileHandler.deleteAnimal(oldName, animalPath);
        fileHandler.writeAnimal(newAnimal, animalPath);

        System.out.println("Animal updated successfully!");

        spacing();
        // ManageInventory();
    }
    /**
     * Removes an animal from the inventory and the data file.
     *
     * @throws IOException if an I/O error occurs.
     */
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
     /**
     * Displays details of all animals in the inventory.
     *
     * @throws IOException if an I/O error occurs.
     */
    public void viewAllAnimals() throws IOException {
        inventoryManager.viewAllAnimals();
    }
    /**
     * Removes animals from the inventory and the data file based on the user's cart.
     *
     * @param user the User object containing the cart information.
     * @throws IOException if an I/O error occurs.
     */
    public void removeCartAnimal(User user) throws IOException {
        List<Animal> cartList = user.getCart();

        for (Animal pet : cartList) {
            fileHandler.deleteAnimal(pet.getName(), animalPath);
        }
    }
    /**
     * Adds a new promo code to the data file.
     *
     * @throws IOException if an I/O error occurs.
     */
    public void addPromoCode() throws IOException {
        System.out.println("New code: ");
        String codeToAdd = scanner.nextLine();

        System.out.println("Discount: ");
        int discount = validDiscount();

        // fix
        scanner.nextLine();

        fileHandler.writePromoCode(codeToAdd, discount, promoPath);

        spacing();
    }
    /**
     * Updates an existing promo code in the data file.
     *
     * @throws IOException if an I/O error occurs.
     */
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
    /**
     * Removes a promo code from the data file.
     *
     * @throws IOException if an I/O error occurs.
     */
    public void removePromoCode() throws IOException {
        System.out.println("Delete code: ");
        String codeToDelete = scanner.nextLine();

        fileHandler.deletePromoCode(codeToDelete, promoPath);

        spacing();
    }
    /**
     * Displays details of all promo codes in the data file.
     *
     * @throws IOException if an I/O error occurs.
     */
    public void viewPromoCode() throws IOException {
        fileHandler.prntPromo(promoPath);
    }
    
    /**
     * Validates and retrieves a discount value from the user.
     *
     * @return the validated discount value.
     */
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
    
    /**
     * Checks if the provided promo code is valid and applies the discount to the user's cart.
     *
     * @param inputPromo the promo code provided by the user.
     * @param user the User object associated with the cart.
     * @throws IOException if an I/O error occurs.
     */
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
    /**
     * Adds a new admin to the data file.
     *
     * @throws IOException if an I/O error occurs.
     */
    public void addAdmin() throws IOException {
        System.out.println("New admin: ");
        String adminToAdd = scanner.nextLine();

        System.out.println("Password: ");
        String password = scanner.nextLine();

        fileHandler.writeAdmin(adminToAdd, password, adminPath);

        spacing();
    }
    /**
     * Updates the password of an existing admin in the data file.
     *
     * @throws IOException if an I/O error occurs.
     */
    public void updateAdmin() throws IOException {
        System.out.println("Update admin: ");
        String adminToUpdate = scanner.nextLine();

        System.out.println("Updated Password: ");
        String newPassword = scanner.nextLine();

        fileHandler.updateAdmin(adminToUpdate, newPassword, adminPath);

        spacing();
    }
    /**
     * Removes an admin from the data file.
     *
     * @throws IOException if an I/O error occurs.
     */
    public void removeAdmin() throws IOException {
        System.out.println("Delete admin: ");
        String adminToDelete = scanner.nextLine();

        fileHandler.deleteAdmin(adminToDelete, adminPath);

        spacing();
    }
    /**
     * Displays details of all admins in the data file.
     *
     * @throws IOException if an I/O error occurs.
     */
    public void viewAdmin() throws IOException {
        fileHandler.prntAdmin(adminPath);
    }
    /**
     * Allows an admin to log in with a username and password.
     *
     * @throws IOException if an I/O error occurs.
     */
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
