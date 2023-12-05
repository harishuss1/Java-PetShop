package project;

import java.io.IOException;

/**
 * Represents a user interface console for interacting with the Pet Shop application.
 */
public class UserConsole extends Console {

    private User user = new User(null, null, 0);
    FileHandler fileHandler = new FileHandler();
    InventoryManager inventoryManager = new InventoryManager();
    Helper helper = new Helper();

    /**
     * Constructs a UserConsole with a specified InventoryManager.
     *
     * @param inventoryManager the InventoryManager to be used by the console.
     */
    public UserConsole(InventoryManager inventoryManager) {
        this.inventoryManager = inventoryManager;
    }

    /**
     * Prompts the user to log in and displays a welcome message.
     */
    @Override
    public void loginSystem() {
        System.out.println("Username:");
        String username = scanner.nextLine();
        user.setUsername(username);
        spacing();
        System.out.println("Welcome to the Application, " + user.getUsername() + "!");
    }

    /**
     * Displays the main menu of the Pet Shop application and handles user choices.
     *
     * @throws IOException if there is an issue reading input or output.
     */
    @Override
    public void displayMainMenu() throws IOException {
        System.out.println("Main menu:");
        System.out.println("1. View Our Animals");
        System.out.println("2. Search for inventory");
        System.out.println("3. Apply Promo Code");
        System.out.println("4. View Cart");
        System.out.println("5. Add to Cart");
        System.out.println("6. Checkout");
        System.out.println("7. Exit");
        spacing();

        int choice = getUserChoice();

        inventoryManager.loadAnimals();

        switch (choice) {
            case 1:
                try {
                    helper.viewAllAnimals();
                } catch (IOException e) {
                    System.out.println("There is an issue viewing Animals");
                }
                spacing();
                displayMainMenu();
                break;
            case 2:
                spacing();
                searchInventory();
                break;
            case 3:
                spacing();
                applyPromoCode();
                break;
            case 4:
                spacing();
                viewCart();
                break;
            case 5:
                spacing();
                addToCart();
                break;
            case 6:
                spacing();
                checkout();
                break;
            case 7:
                System.exit(1);
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                displayMainMenu();
        }
    }

    /**
     * Searches the inventory based on the user's selection of animal type.
     *
     * @throws IOException if there is an issue reading input or output.
     */
    private void searchInventory() throws IOException {
        System.out.println("Searching for inventory:");
        System.out.println("Select the type of animal you are searching for:");
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
                searchInventory();
                return;
        }

        inventoryManager.searchAnimals(type);
        spacing();
        displayMainMenu();
    }

    /**
     * Applies a promo code based on user input.
     *
     * @throws IOException if there is an issue reading input or output.
     */
    private void applyPromoCode() throws IOException {
        System.out.println("Applying Promo Code:");
        System.out.println("Enter promo code:");

        scanner.nextLine();

        String inputPromo = scanner.nextLine();

        helper.matchingPromo(inputPromo, user);

        spacing();
        displayMainMenu();
    }

    /**
     * Displays the contents of the user's shopping cart.
     *
     * @throws IOException if there is an issue reading input or output.
     */
    private void viewCart() throws IOException {
        System.out.println("Viewing Cart:");
        user.viewCart();
        spacing();
        displayMainMenu();
    }

    /**
     * Handles the checkout process, calculating the total price and displaying a thank you message.
     *
     * @throws IOException if there is an issue reading input or output.
     */
    private void checkout() throws IOException {
        double finalPrice = user.calculateTotalPrice();
        if (finalPrice > 0) {
            System.out.println("Total Price: $" + finalPrice);
            System.out.println("Thank you for shopping at our Pet Shop!");
            helper.removeCartAnimal(user);
            System.exit(1);
        } else {
            System.out.println("Your cart is empty");
            spacing();
            displayMainMenu();
        }
    }

    /**
     * Adds an animal to the user's shopping cart based on user input.
     *
     * @throws IOException if there is an issue reading input or output.
     */
    private void addToCart() throws IOException {
        System.out.println("Adding to Shopping Cart:");
        scanner.nextLine(); 

        System.out.println("Enter the name of the animal to add to your cart:");
        String animalName = scanner.nextLine();

        Animal selectedAnimal = inventoryManager.getAnimalByName(animalName);

        if (selectedAnimal != null) {
            user.addToCart(selectedAnimal);
            System.out.println(animalName + " added to your cart!");
        } else {
            System.out.println("Animal not found in inventory.");
        }

        spacing();
        displayMainMenu();
    }
}
