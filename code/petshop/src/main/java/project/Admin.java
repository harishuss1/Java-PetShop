package project;

/**
 * The Admin class represents an administrative user with a username and password.
 * It provides methods to get and set the username and password, as well as a
 * toString method for displaying information about the admin.
 */
public class Admin {

    private String user;
    private String password;

    /**
     * Constructs a new Admin object with the specified username and password.
     *
     * @param user     The username of the admin.
     * @param password The password of the admin.
     */
    public Admin(String user, String password) {
        this.user = user;
        this.password = password;
    }

    /**
     * Gets the username of the admin.
     *
     * @return The username of the admin.
     */
    public String getUser() {
        return this.user;
    }

    /**
     * Sets the username of the admin.
     *
     * @param user The new username to set.
     */
    public void setUser(String user) {
        this.user = user;
    }

    /**
     * Gets the password of the admin.
     *
     * @return The password of the admin.
     */
    public String getPassword() {
        return this.password;
    }

    /**
     * Sets the password of the admin.
     *
     * @param password The new password to set.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Returns a string representation of the Admin object.
     *
     * @return A string containing the admin's username and password.
     */
    public String toString() {
        return "Admin: " + user + ", " + "Password: " + password;
    }
}
