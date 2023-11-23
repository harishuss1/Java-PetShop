package project;

import java.io.IOException;
import java.util.List;

public interface IPromoCodeImporter {

    List<PromoCode> loadPromoCodes(String path) throws IOException;

    void writePromoCode(String code, double value) throws IOException;

    void deletePromoCode(String code) throws IOException;

}
