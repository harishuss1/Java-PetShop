package project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.Console;
import java.io.IOException;

/**
 * Manages interactions with a SQL database for animal-related operations.
 */
public class SqlHandler implements Importer {

    private String url;
    private String username;
    private String password;
    /**
     * Constructs a SqlHandler with the specified URL, username, and password for database connection.
     *
     * @param url      the URL for the database connection.
     * @param username the username for authentication.
     * @param password the password for authentication.
     */
    // public SqlHandler(String url, String username, String password) {
    // this.url = url;
    // this.username = username;
    // this.password = password;
    // }
    /**
     * Loads a list of animals from the connected SQL database.
     *
     * @return a list of Animal objects.
     * @throws SQLException if a database access error occurs.
     */
    public List<Animal> loadAnimals() throws SQLException {
        List<Animal> animals = new ArrayList<>();
        Connection conn = null;
        Scanner scan = new Scanner(System.in);
        Console console = System.console();
        System.out.println("Enter username: ");
        String username = scan.next();
        System.out.println("Enter password");
        char[] passwordChars = console.readPassword();
        String password = new String(passwordChars);

        String url = "jdbc:oracle:thin:@198.168.52.211: 1521/pdbora19c.dawsoncollege.qc.ca";
        conn = DriverManager.getConnection(url, username, password);
        System.out.println("Connected to database");

        try (Connection connection = DriverManager.getConnection(url, username, password);
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM animals")) {

            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String species = resultSet.getString("species");
                int age = resultSet.getInt("age");
                double price = resultSet.getDouble("price");

                Animal animal = new Animal(name, species, age, price);
                animals.add(animal);
            }
        }

        return animals;
    }
    /**
     * Adds an animal to the SQL database.
     *
     * @param animal the Animal object to be added.
     * @throws SQLException if a database access error occurs.
     */
    public void addAnimal(Animal animal) throws SQLException {
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String query = "INSERT INTO animals (name, species, age, price) VALUES (?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, animal.getName());
                preparedStatement.setString(2, animal.getSpecies());
                preparedStatement.setInt(3, animal.getAge());
                preparedStatement.setDouble(4, animal.getPrice());
                preparedStatement.executeUpdate();
            }
        }
    }
    /**
     * Updates an existing animal in the SQL database.
     *
     * @param oldAnimal the original Animal object.
     * @param newAnimal the updated Animal object.
     * @throws SQLException if a database access error occurs.
     */
    public void updateAnimal(Animal oldAnimal, Animal newAnimal) throws SQLException {
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String query = "UPDATE animals SET name=?, species=?, age=?, price=? WHERE name=?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, newAnimal.getName());
                preparedStatement.setString(2, newAnimal.getSpecies());
                preparedStatement.setInt(3, newAnimal.getAge());
                preparedStatement.setDouble(4, newAnimal.getPrice());
                preparedStatement.setString(5, oldAnimal.getName());
                preparedStatement.executeUpdate();
            }
        }
    }
     /**
     * Deletes an animal from the SQL database.
     *
     * @param animal the Animal object to be deleted.
     * @throws SQLException if a database access error occurs.
     */
    public void deleteAnimal(Animal animal) throws SQLException {
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String query = "DELETE FROM animals WHERE name=?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, animal.getName());
                preparedStatement.executeUpdate();
            }
        }
    }

    @Override
    public List<PromoCode> loadPromoCodes(String path) throws IOException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'loadPromoCodes'");
    }

    @Override
    public void writePromoCode(String code, double value, String path) throws IOException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'writePromoCode'");
    }

    @Override
    public void updatePromoCode(String code, double newValue, String path) throws IOException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updatePromoCode'");
    }

    @Override
    public void deletePromoCode(String code, String path) throws IOException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deletePromoCode'");
    }

    @Override
    public void prntPromo(String path) throws IOException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'prntPromo'");
    }

    @Override
    public List<Admin> loadAdmins(String path) throws IOException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'loadAdmins'");
    }

    @Override
    public void writeAdmin(String user, String password, String path) throws IOException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'writeAdmin'");
    }

    @Override
    public void updateAdmin(String user, String newPassword, String path) throws IOException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateAdmin'");
    }

    @Override
    public void deleteAdmin(String user, String path) throws IOException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteAdmin'");
    }

    @Override
    public void prntAdmin(String path) throws IOException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'prntAdmin'");
    }

    @Override
    public boolean matchingAdmin(String username, String password, String path) throws IOException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'matchingAdmin'");
    }

    @Override
    public Animal createAnimal(String[] columns) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createAnimal'");
    }

    @Override
    public void printAnimals(String path) throws IOException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'printAnimals'");
    }

    @Override
    public void writeAnimal(Animal animal, String path) throws IOException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'writeAnimal'");
    }

    @Override
    public void deleteAnimal(String name, String path) throws IOException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteAnimal'");
    }
}
