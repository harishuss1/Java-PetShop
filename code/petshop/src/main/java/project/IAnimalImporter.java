package project;

import java.io.IOException;
import java.util.List;

public interface IAnimalImporter {
    List<Animal> loadAnimals(String path) throws IOException;

}
