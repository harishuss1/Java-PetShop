// package project;

// import static org.junit.Assert.*;

// import org.junit.Test;
// import java.util.ArrayList;
// import java.util.List;

// public class UserTest {

//     @Test
//     public void testGetUsername() {
//         List<Animal> cart = new ArrayList<>();
//         User user = new User("tester", cart, 10.0);

//         // get right username
//         assertEquals("tester", user.getUsername());

//         // get wrong username
//         assertNotEquals("notTester", user.getUsername());
//     }

//     @Test
//     public void testSetUsername() {
//         List<Animal> cart = new ArrayList<>();
//         User user = new User("tester", cart, 10.0);

//         user.setUsername("newTester");

//         // get right username
//         assertEquals("newTester", user.getUsername());

//         // get old username
//         assertNotEquals("tester", user.getUsername());
//     }

//     @Test
//     public void testGetCart() {
//         List<Animal> cart = new ArrayList<>();
//         Animal dog = new Dog("Cupcake", "dog", 3, 100.0);
//         cart.add(dog);
//         User user = new User("tester", cart, 10.0);

//         // get right cart
//         assertEquals(cart, user.getCart());

//         // get wrong cart
//         List<Animal> emptyCart = new ArrayList<>();
//         assertNotEquals(emptyCart, user.getCart());
//     }

//     @Test
//     public void testSetCart() {
//         List<Animal> cart = new ArrayList<>();
//         Animal dog = new Mammal("Cupcake", "Dog", 3, 100.0);
//         cart.add(dog);

//         User user = new User("tester", cart, 10.0);

//         List<Animal> newCart = new ArrayList<>();
//         Animal cat = new Mammal("Ice spice", "Cat", 2, 150.0);
//         newCart.add(cat);

//         user.setCart(newCart);

//         // get right cart
//         assertEquals(newCart, user.getCart());

//         // get old cart
//         assertNotEquals(cart, user.getCart());
//     }

//     // @Test
//     // public void testAddToCart(){
//     // List<Animal> cart = new ArrayList<>();
//     // Animal dog = new Mammal("Cupcake", "dog", 3, 100.0);
//     // cart.add(dog);
//     // User user = new User("tester", cart, 10.0);

//     // Animal cat = new Mammal("Ice spice", "Cat", 2, 150.0);
//     // cart.add(cat);

//     // cart.addToCart(cart);

//     // assertEquals(cart, user.getCart());
//     // }
// }