package project;

import java.io.IOException;
import java.util.List;

/**
 * An interface for importing and managing data related to animals, promo codes, and admins.
 */
public interface Importer {

    // ANIMAL

    /**
     * Loads a list of Animal objects from a specified path.
     *
     * @return a list of Animal objects.
     * @throws Exception if an error occurs during loading.
     */
    List<Animal> loadAnimals() throws Exception;

    /**
     * Creates an Animal object based on the provided columns.
     *
     * @param columns an array of strings representing the columns of an Animal.
     * @return the created Animal object.
     */
    Animal createAnimal(String[] columns);

    /**
     * Prints details of animals loaded from the specified path.
     *
     * @param path the path from which animals are loaded.
     * @throws IOException if an I/O error occurs.
     */
    void printAnimals(String path) throws IOException;

    /**
     * Writes an Animal object to a specified path.
     *
     * @param animal the Animal object to be written.
     * @param path   the path to which the Animal is written.
     * @throws IOException if an I/O error occurs.
     */
    void writeAnimal(Animal animal, String path) throws IOException;

    /**
     * Deletes an Animal from the specified path based on its name.
     *
     * @param name the name of the Animal to be deleted.
     * @param path the path from which the Animal is deleted.
     * @throws IOException if an I/O error occurs.
     */
    void deleteAnimal(String name, String path) throws IOException;

    // PROMOCODE

    /**
     * Loads a list of PromoCode objects from a specified path.
     *
     * @param path the path from which promo codes are loaded.
     * @return a list of PromoCode objects.
     * @throws IOException if an I/O error occurs.
     */
    List<PromoCode> loadPromoCodes(String path) throws IOException;

    /**
     * Writes a new PromoCode to a specified path.
     *
     * @param code  the promo code to be written.
     * @param value the value associated with the promo code.
     * @param path  the path to which the promo code is written.
     * @throws IOException if an I/O error occurs.
     */
    void writePromoCode(String code, double value, String path) throws IOException;

    /**
     * Updates the value of an existing promo code at the specified path.
     *
     * @param code    the promo code to be updated.
     * @param newValue the new value associated with the promo code.
     * @param path    the path from which the promo code is updated.
     * @throws IOException if an I/O error occurs.
     */
    void updatePromoCode(String code, double newValue, String path) throws IOException;

    /**
     * Deletes a promo code from the specified path based on its code.
     *
     * @param code the code of the promo code to be deleted.
     * @param path the path from which the promo code is deleted.
     * @throws IOException if an I/O error occurs.
     */
    void deletePromoCode(String code, String path) throws IOException;

    /**
     * Prints details of promo codes loaded from the specified path.
     *
     * @param path the path from which promo codes are loaded.
     * @throws IOException if an I/O error occurs.
     */
    void prntPromo(String path) throws IOException;

    // ADMIN

    /**
     * Loads a list of Admin objects from a specified path.
     *
     * @param path the path from which admins are loaded.
     * @return a list of Admin objects.
     * @throws IOException if an I/O error occurs.
     */
    List<Admin> loadAdmins(String path) throws IOException;

    /**
     * Writes a new Admin to a specified path.
     *
     * @param user     the username of the admin.
     * @param password the password of the admin.
     * @param path     the path to which the admin is written.
     * @throws IOException if an I/O error occurs.
     */
    void writeAdmin(String user, String password, String path) throws IOException;

    /**
     * Updates the password of an existing admin at the specified path.
     *
     * @param user         the username of the admin to be updated.
     * @param newPassword the new password for the admin.
     * @param path         the path from which the admin is updated.
     * @throws IOException if an I/O error occurs.
     */
    void updateAdmin(String user, String newPassword, String path) throws IOException;

    /**
     * Deletes an admin from the specified path based on its username.
     *
     * @param user the username of the admin to be deleted.
     * @param path the path from which the admin is deleted.
     * @throws IOException if an I/O error occurs.
     */
    void deleteAdmin(String user, String path) throws IOException;

    /**
     * Prints details of admins loaded from the specified path.
     *
     * @param path the path from which admins are loaded.
     * @throws IOException if an I/O error occurs.
     */
    void prntAdmin(String path) throws IOException;

    /**
     * Checks if the provided username and password match any admin credentials.
     *
     * @param username the username to be checked.
     * @param password the password to be checked.
     * @param path     the path from which admin credentials are checked.
     * @return true if the provided username and password match any admin, false otherwise.
     * @throws IOException if an I/O error occurs.
     */
    boolean matchingAdmin(String username, String password, String path) throws IOException;
}
