package project;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a user in the system with a username, shopping cart, and a promo code for discounts.
 */
public class User {

    private String username;
    private List<Animal> cart;
    private double promoCode; // 10, 20, 30, etc...

    /**
     * Constructs a User with the specified username, an empty shopping cart, and a promo code.
     *
     * @param username  the username of the user.
     * @param cart      the shopping cart containing Animal objects.
     * @param promoCode the promo code percentage for discounts.
     */
    public User(String username, List<Animal> cart, double promoCode) {
        this.username = username;
        this.cart = new ArrayList<>(); // Initialize the cart if null
        this.promoCode = promoCode;
    }

    /**
     * Gets the username of the user.
     *
     * @return the username.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Gets the shopping cart of the user.
     *
     * @return the shopping cart containing Animal objects.
     */
    public List<Animal> getCart() {
        return cart;
    }

    /**
     * Gets the promo code percentage for discounts.
     *
     * @return the promo code percentage.
     */
    public double getPromoCode() {
        return promoCode;
    }

    /**
     * Sets the username of the user.
     *
     * @param username the new username.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Sets the shopping cart of the user.
     *
     * @param cart the new shopping cart containing Animal objects.
     */
    public void setCart(List<Animal> cart) {
        this.cart = cart;
    }

    /**
     * Sets the promo code percentage for discounts.
     *
     * @param promoCode the new promo code percentage.
     */
    public void setPromoCode(double promoCode) {
        this.promoCode = promoCode;
    }

    /**
     * Adds an animal to the user's shopping cart.
     *
     * @param animal the Animal object to be added.
     */
    public void addToCart(Animal animal) {
        cart.add(animal);
        System.out.println("Added " + animal.getName() + " to your shopping cart.");
    }

    /**
     * Displays the contents of the user's shopping cart along with the total price after applying discounts.
     */
    public void viewCart() {
        System.out.println("Your Shopping Cart:");
        for (Animal animal : cart) {
            System.out.println(animal);
        }
        System.out.println("Total Price: $" + calculateTotalPrice());
    }

    /**
     * Calculates the total price of the items in the user's shopping cart after applying discounts.
     *
     * @return the total price.
     */
    public double calculateTotalPrice() {
        double totalPrice = 0;
        for (Animal animal : cart) {
            totalPrice += animal.getPrice();
        }
        // Apply promo code
        totalPrice *= (1 - promoCode / 100.0);
        return totalPrice;
    }

    /**
     * Returns a string representation of the User object, including username, promo code, and shopping cart.
     *
     * @return the string representation.
     */
    public String toString() {
        String promoCodeBuilder = "None";
        if (promoCode != 0) {
            promoCodeBuilder = promoCode + "% off";
        }

        return "Username: " + username + "\n" +
                "Promo Code: " + promoCodeBuilder + "\n" +
                "Cart: " + cart;
    }
}
