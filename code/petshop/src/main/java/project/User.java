package project;

import java.util.List;

public class User {
    private String username;
    private List<Animal> Cart;
    private double promoCode; // 10, 20, 30, etc...

    public User(String username, List<Animal> Cart, double promoCode) {
        this.username = username;
        this.Cart = Cart;
        this.promoCode = promoCode;
    }

    public String getUsername() {
        return username;
    }

    public List<Animal> getCart() {
        return Cart;
    }

    public double getPromoCode() {
        return promoCode;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setCart(List<Animal> cart) {
        Cart = cart;
    }

    public void setPromoCode(double promoCode) {
        this.promoCode = promoCode;
    }

    public String toString() {
        String promoCodeBuilder = "None";
        if (!(this.promoCode == 0)) {
            promoCodeBuilder = promoCode + "% off";
        }

        return "Username: " + this.username + "\n" +
                "Promo Code: " + promoCodeBuilder + "\n" +
                "Cart: " + this.Cart;
    }

}
