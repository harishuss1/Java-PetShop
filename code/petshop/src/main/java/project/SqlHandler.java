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

public class SqlHandler implements Importer {

    private String url;
    private String username;
    private String password;

    // public SqlHandler(String url, String username, String password) {
    // this.url = url;
    // this.username = username;
    // this.password = password;
    // }

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

    public void deleteAnimal(Animal animal) throws SQLException {
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String query = "DELETE FROM animals WHERE name=?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, animal.getName());
                preparedStatement.executeUpdate();
            }
        }
    }
}
