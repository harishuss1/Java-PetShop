package project;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileHandler {
    
    public List<Animal> loadAnimals (String Path){
        try{
            Path p = Paths.get(Path);
            List<String> rows = Files.readAllLines(p);

            for(String row : rows){
                String[] columns
            }

        }
    }

}
