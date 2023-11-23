package project;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class PromoCodeFileHandler implements IPromoCodeImporter {

    public List<PromoCode> loadPromoCodes(String path) throws IOException {

        Path p = Paths.get(path);

        List<String> promoCodesInfo = Files.readAllLines(p);
        List<PromoCode> promoCodes = new ArrayList<>();

        for (String promo : promoCodesInfo) {
            String[] pieces = promo.split(",");
            String code = pieces[0];
            double value = Double.parseDouble(pieces[1]);
            promoCodes.add(new PromoCode(code, value));
        }

        // test print
        for (int i = 0; i < promoCodes.size(); i++) {
            System.out.println(promoCodes.get(i));
        }

        return promoCodes;
    }

    public void writePromoCode(String code, double value) throws IOException {
        List<PromoCode> promoCodesList = new ArrayList<>();
        promoCodesList = loadPromoCodes("promo.csv");
        promoCodesList.add(new PromoCode(code, value));

        List<String> PromoCodeStrings = new ArrayList<>();
        for (PromoCode promo : promoCodesList) {
            PromoCodeStrings.add(promo.getCode() + "," + promo.getValue());
        }

        Files.write(Paths.get("promo.csv"), PromoCodeStrings);
    }

    public void deletePromoCode(String code) throws IOException {
        List<PromoCode> promoCodesList = new ArrayList<>();
        promoCodesList = loadPromoCodes("promo.csv");

        int index = 0;

        System.out.println(code);

        for (PromoCode promo : promoCodesList) {
            System.out.println(promo.getCode());
            String oldcode = promo.getCode();
            if (oldcode.equals(code)) {
                System.out.println("they are equal");
                promoCodesList.remove(index);
                break;
            }
            index++;
        }

        List<String> PromoCodeStrings = new ArrayList<>();
        for (PromoCode promo : promoCodesList) {
            PromoCodeStrings.add(promo.getCode() + "," + promo.getValue());
        }

        Files.write(Paths.get("promo.csv"), PromoCodeStrings);

    }

}
