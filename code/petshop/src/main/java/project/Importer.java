package project;

import java.io.IOException;
import java.util.List;

public interface Importer {

    // ANIMAL
    List<Animal> loadAnimals() throws Exception;

    Animal createAnimal(String[] columns);

    void printAnimals(String path) throws IOException;

    void writeAnimal(Animal animal, String path) throws IOException;

    void deleteAnimal(String name, String path) throws IOException;

    // PROMOCODE
    List<PromoCode> loadPromoCodes(String path) throws IOException;

    void writePromoCode(String code, double value, String path) throws IOException;

    void updatePromoCode(String code, double newValue, String path) throws IOException;

    void deletePromoCode(String code, String path) throws IOException;

    void prntPromo(String path) throws IOException;

    // ADMIN

    List<Admin> loadAdmins(String path) throws IOException;

    void writeAdmin(String user, String password, String path) throws IOException;

    void updateAdmin(String user, String newPassword, String path) throws IOException;

    void deleteAdmin(String user, String path) throws IOException;
    
    void prntAdmin(String path) throws IOException ;

    boolean matchingAdmin(String username, String password, String path) throws IOException;
} 
