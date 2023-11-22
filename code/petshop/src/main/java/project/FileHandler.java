package project;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileHandler implements IAnimalImporter{

    public List<Animal> loadAnimals()  throws IOException{
        try {
            String path = "FileName";
            Path p = Paths.get(path);
            List<String> rows = Files.readAllLines(p);

            List<Animal> animals = new ArrayList<>();

            for (String row : rows) {
                String[] columns = row.split(",");
                Animal animal = createAnimal(columns);
                animals.add(animal);
            }

            return animals;
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public Animal createAnimal(String[] columns) {
        String name = columns[0].trim();
        String species = columns[1].trim();
        int age = Integer.parseInt(columns[2].trim());
        double price = Double.parseDouble(columns[3].trim());

        return new Animal(name, species, age, price);
    }

   

    
}
