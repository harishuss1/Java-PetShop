package project;

import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class fileHandlerTest {

    @Test
    public void testLoadWrongPath() {
        // Arrange
        FileHandler fileHandler = new FileHandler();

        // With wrong path
        try {
            fileHandler.loadPromoCodes("target/classes/wrongpath.csv");
            fail("path is supposed to be wrong");
        } catch (IOException e) {
            // IOException caught
            assertTrue(true);
        }
    }

    // PROMO SECTION

    @Test
    public void testWritePromo() {
        // Arrange
        FileHandler fileHandler = new FileHandler();
        String path = "target/classes/promo.csv";
        String code = "Test10";
        double value = 10.0;

        // With correct code and value
        try {
            fileHandler.writePromoCode(code, value, path);

            List<String> list = Files.readAllLines(Paths.get(path));

            // does it contain newly added promo code?
            assertTrue(list.contains(code + "," + value));
        } catch (IOException e) {
            fail("IOException not expected here");
        }
    }

    @Test
    public void testPromoLoadRightPath() {
        // Arrange
        FileHandler fileHandler = new FileHandler();

        // With right path
        try {
            fileHandler.loadPromoCodes("target/classes/promo.csv");
            assertTrue(true);
        } catch (IOException e) {
            // IOException caught
            fail("IOException not expected here");
        }
    }

    @Test
    public void testDeletePromoCode() {
        // Arrange
        FileHandler fileHandler = new FileHandler();
        String path = "target/classes/promo.csv";
        String codeToDelete = "Test11";
        double valueToDelete = 11.0;

        // With correct name
        try {
            // Add a promo code to the file
            fileHandler.writePromoCode(codeToDelete, valueToDelete, path);

            // Delete the promo code
            fileHandler.deletePromoCode(codeToDelete, path);

            List<String> list = Files.readAllLines(Paths.get(path));

            // does it contain the deleted code?
            assertFalse(list.contains(codeToDelete + "," + valueToDelete));
        } catch (IOException e) {
            fail("IOException not expected here");
        }
    }

    @Test
    public void testUpdatePromoCode() {
        // Arrange
        FileHandler fileHandler = new FileHandler();
        String path = "target/classes/promo.csv";
        String codeToUpdate = "Test12";
        double oldValue = 11.0;
        double newValue = 12.0;

        try {
            // Add a promo code to the file
            fileHandler.writePromoCode(codeToUpdate, oldValue, path);

            // Update the promo code
            fileHandler.updatePromoCode(codeToUpdate, newValue, path);

            List<String> list = Files.readAllLines(Paths.get(path));

            // should contain new value
            assertTrue(list.contains(codeToUpdate + "," + newValue));
        } catch (IOException e) {
            fail("IOException not expected here: " + e.getMessage());
        }
    }

    // ADMIN SECTION

    @Test
    public void testWriteAdmin() {
        // Arrange
        FileHandler fileHandler = new FileHandler();
        String path = "target/classes/admin.csv";
        String username = "tester1";
        String password = "test123";

        try {
            fileHandler.writeAdmin(username, password, path);
            List<String> lines = Files.readAllLines(Paths.get(path));

            // should contain the new username and password
            assertTrue(lines.contains(username + "," + password));
        } catch (IOException e) {
            fail("IOException not expected here");
        }
    }

    @Test
    public void testLoadAdminsRightPath() {
        // Arrange
        FileHandler fileHandler = new FileHandler();

        // With right path
        try {
            fileHandler.loadAdmins("target/classes/admin.csv");
            assertTrue(true);
        } catch (IOException e) {
            // IOException caught
            fail("IOException not expected here");
        }
    }

    @Test
    public void testDeleteAdmin() {
        // Arrange
        FileHandler fileHandler = new FileHandler();
        String path = "target/classes/admin.csv";
        String userToDelete = "tester2";
        String passwordToDelete = "test123";

        try {
            // Add an admin to the file
            fileHandler.writeAdmin(userToDelete, passwordToDelete, path);

            // Delete the admin
            fileHandler.deleteAdmin(userToDelete, path);

            List<String> list = Files.readAllLines(Paths.get(path));

            // does it contain the deleted admin?
            assertFalse(list.contains(userToDelete + "," + passwordToDelete));
        } catch (IOException e) {
            fail("IOException not expected here");
        }
    }

    @Test
    public void testUpdateAdmin() {
        // Arrange
        FileHandler fileHandler = new FileHandler();
        String filePath = "target/classes/admin.csv";
        String userToUpdate = "tester3";
        String oldPassword = "test123";
        String newPassword = "newTest123";

        try {
            // Add an admin to the file
            fileHandler.writeAdmin(userToUpdate, oldPassword, filePath);

            // Update the admin
            fileHandler.updateAdmin(userToUpdate, newPassword, filePath);

            List<String> list = Files.readAllLines(Paths.get(filePath));

            // should contain new admin and not old one
            assertTrue(list.contains(userToUpdate + "," + newPassword));
        } catch (IOException e) {
            fail("IOException not expected here");
        }
    }

    @Test
    public void testMatchingAdmin() {
        // Arrange
        FileHandler fileHandler = new FileHandler();
        String path = "target/classes/admin.csv";
        String username = "tester4";
        String password = "test123";

        try {
            // Add an admin to the file
            fileHandler.writeAdmin(username, password, path);

            // Check if matching admin credentials
            boolean match = fileHandler.matchingAdmin(username, password, path);

            // match?
            assertTrue(match);
        } catch (IOException e) {
            fail("IOException not expected here");
        }
    }

    @Test
    public void testNotMatchingUsernameAdmin() {
        // Arrange
        FileHandler fileHandler = new FileHandler();
        String path = "target/classes/admin.csv";
        String username = "notTester4"; // Wrong username
        String password = "test123";

        try {
            // Check if matching admin credentials
            boolean match = fileHandler.matchingAdmin(username, password, path);

            // match?
            assertFalse(match);
        } catch (IOException e) {
            fail("IOException not expected here");
        }
    }

    @Test
    public void testNotMatchingPasswordAdmin() {
        // Arrange
        FileHandler fileHandler = new FileHandler();
        String path = "target/classes/admin.csv";
        String username = "tester4";
        String password = "notTest123"; // Wrong password

        try {
            // Check if matching admin credentials
            boolean match = fileHandler.matchingAdmin(username, password, path);

            // match?
            assertFalse(match);
        } catch (IOException e) {
            fail("IOException not expected here");
        }
    }

}
