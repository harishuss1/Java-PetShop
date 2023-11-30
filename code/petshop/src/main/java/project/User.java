package project;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String username;
    private List<Animal> cart;
    private double promoCode; // 10, 20, 30, etc...

    public User(String username, List<Animal> cart, double promoCode) {
        this.username = username;
        this.cart =  new ArrayList<>(); // Initialize the cart if null
        this.promoCode = promoCode;
    }

    public String getUsername() {
        return username;
    }

    public List<Animal> getCart() {
        return cart;
    }

    public double getPromoCode() {
        return promoCode;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setCart(List<Animal> cart) {
        this.cart = cart;
    }

    public void setPromoCode(double promoCode) {
        this.promoCode = promoCode;
    }

    public void addToCart(Animal animal) {
        cart.add(animal);
        System.out.println("Added " + animal.getName() + " to your shopping cart.");
    }
    

    public void viewCart() {
        System.out.println("Your Shopping Cart:");
        for (Animal animal : cart) {
            System.out.println(animal);
        }
        System.out.println("Total Price: $" + calculateTotalPrice());
    }

    private double calculateTotalPrice() {
        double totalPrice = 0;
        for (Animal animal : cart) {
            totalPrice += animal.getPrice();
        }
        // Apply promo code
        totalPrice *= (1 - promoCode / 100.0);
        return totalPrice;
    }

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
