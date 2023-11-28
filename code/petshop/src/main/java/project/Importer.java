package project;

import java.io.IOException;
import java.util.List;

public interface Importer {

    // ANIMAL
    List<Animal> loadAnimals() throws Exception;

    // PROMOCODE
    List<PromoCode> loadPromoCodes(String path) throws IOException;

    void writePromoCode(String code, double value, String path) throws IOException;

    void updatePromoCode(String code, int newValue, String path) throws IOException;

    void deletePromoCode(String code, String path) throws IOException;

    void prntPromo(String path) throws IOException;

    // ADMIN

}
