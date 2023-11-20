package project;

import java.util.List;

public class User {
    private String name;
    private String userId; // Not sure if we want to add this.
    private List<Animal> Cart;

    public User(String name, String userid,List<Animal> Cart){
        this.name = name;
        this.userId =userid;
        this.Cart = Cart;
    }

    public String getName() {
        return name;
    }
    public String getUserId() {
        return userId;
    }
    public List<Animal> getCart() {
        return Cart;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
    public void setCart(List<Animal> cart) {
        Cart = cart;
    }

    
}
