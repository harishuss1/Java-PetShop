package project;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileHandler implements IAnimalImporter, IPromoCodeImporter {

    // ANIMAL SECTION
    public List<Animal> loadAnimals() throws IOException {
        try {
            String path = "code/petshop/src/main/resources/promo.csv";
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

    // PROMO CODE SECTION
    public List<PromoCode> loadPromoCodes(String path) throws IOException {

        Path p = Paths.get(path);

        List<String> promoCodesString = Files.readAllLines(p);
        List<PromoCode> promoCodes = new ArrayList<>();

        for (String promo : promoCodesString) {
            String[] pieces = promo.split(",");
            String code = pieces[0];
            double value = Double.parseDouble(pieces[1]);
            promoCodes.add(new PromoCode(code, value));
        }

        return promoCodes;
    }

    public void writePromoCode(String code, double value, String path) throws IOException {
        List<PromoCode> promoCodesList = new ArrayList<>();
        promoCodesList = loadPromoCodes(path);
        promoCodesList.add(new PromoCode(code, value));

        List<String> PromoCodeStrings = new ArrayList<>();
        for (PromoCode promo : promoCodesList) {
            PromoCodeStrings.add(promo.getCode() + "," + promo.getValue());
        }

        Files.write(Paths.get(path), PromoCodeStrings);
    }

    public void deletePromoCode(String code, String path) throws IOException {
        List<PromoCode> promoCodesList = new ArrayList<>();
        promoCodesList = loadPromoCodes(path);

        int index = 0;

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

        Files.write(Paths.get(path), PromoCodeStrings);
    }

    public void prntPromo(String path) throws IOException {
        List<PromoCode> promoCodesList = new ArrayList<>();
        promoCodesList = loadPromoCodes(path);

        for (int i = 0; i < promoCodesList.size(); i++) {
            System.out.println(promoCodesList.get(i));
        }

    }

    // ADMIN SECTION

}