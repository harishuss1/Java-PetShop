package project;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SqlHandler implements IAnimalImporter {

   private String url;
   private String username;
   private String password;

   public SqlHandler(String url, String username, String password) {
       this.url = url;
       this.username = username;
       this.password = password;
   }

    
    public List<Animal> loadAnimals() throws SQLException {
        List<Animal> animals = new ArrayList<>();
 
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
   
}


