package project;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileHandler implements Importer {
    Validation validation = new Validation();

    // ANIMAL SECTION
    public List<Animal> loadAnimals() throws IOException {
        String path = "code/petshop/src/main/resources/animals.csv";
        Path animalsPath = Paths.get(path);
        List<String> animalLines = Files.readAllLines(animalsPath);

        List<Animal> animals = new ArrayList<>();

        for (String line : animalLines) {
            String[] columns = line.split(",");
            Animal animal = createAnimal(columns);
            animals.add(animal);
        }

        return animals;
    }

    public Animal createAnimal(String[] columns) {
        String name = columns[0].trim();
        String species = columns[1].trim();
        int age = Integer.parseInt(columns[2].trim());
        double price = Double.parseDouble(columns[3].trim());
        String additionalInfo = columns[4].trim();

        switch (species) {
            case "Dog":
                return new Dog(name, species, age, price, additionalInfo);
            case "Cat":
                return new Cat(name, species, age, price, Boolean.parseBoolean(additionalInfo));
            case "Fish":
                return new Fish(name, species, age, price, additionalInfo);
            case "Parrot":
                return new Parrot(name, species, age, price, additionalInfo);
            default:
                return new Animal(name, species, age, price);
        }
    }

    public void printAnimals(String path) throws IOException {
        List<Animal> animalsList = loadAnimals();

        for (int i = 0; i < animalsList.size(); i++) {
            System.out.println(animalsList.get(i));
        }
    }

    public void writeAnimal(Animal animal, String path) throws IOException {
        List<Animal> animalsList = new ArrayList<>();
        animalsList = loadAnimals();
        animalsList.add(animal);

        List<String> animalStrings = new ArrayList<>();
        for (Animal a : animalsList) {
            if (a instanceof Dog) {
                Dog dog = (Dog) a;
                animalStrings.add(a.getName() + "," + a.getSpecies() + "," + a.getAge() + "," + a.getPrice() + ","
                        + dog.getBreed());
            } else if (a instanceof Cat) {
                Cat cat = (Cat) a;
                animalStrings.add(a.getName() + "," + a.getSpecies() + "," + a.getAge() + "," + a.getPrice() + ","
                        + cat.hasClaws());
            } else if (a instanceof Fish) {
                Fish fish = (Fish) a;
                animalStrings.add(a.getName() + "," + a.getSpecies() + "," + a.getAge() + "," + a.getPrice() + ","
                        + fish.getColor());
            } else if (a instanceof Parrot) {
                Parrot parrot = (Parrot) a;
                animalStrings.add(a.getName() + "," + a.getSpecies() + "," + a.getAge() + "," + a.getPrice() + ","
                        + parrot.getFeatherColor());
            } else {
                animalStrings.add(a.getName() + "," + a.getSpecies() + "," + a.getAge() + "," + a.getPrice());
            }
        }

        Files.write(Paths.get(path), animalStrings);
    }

    public void deleteAnimal(String name, String path) throws IOException {
        List<Animal> animalsList = new ArrayList<>();
        animalsList = loadAnimals();

        int index = 0;

        for (Animal animal : animalsList) {
            if (animal.getName().equals(name)) {
                animalsList.remove(index);
                break;
            }
            index++;
        }

        List<String> animalStrings = new ArrayList<>();
        for (Animal a : animalsList) {
            if (a instanceof Dog) {
                Dog dog = (Dog) a;
                animalStrings.add(a.getName() + "," + a.getSpecies() + "," + a.getAge() + "," + a.getPrice() + ","
                        + dog.getBreed());
            } else if (a instanceof Cat) {
                Cat cat = (Cat) a;
                animalStrings.add(a.getName() + "," + a.getSpecies() + "," + a.getAge() + "," + a.getPrice() + ","
                        + cat.hasClaws());
            } else if (a instanceof Fish) {
                Fish fish = (Fish) a;
                animalStrings.add(a.getName() + "," + a.getSpecies() + "," + a.getAge() + "," + a.getPrice() + ","
                        + fish.getColor());
            } else if (a instanceof Parrot) {
                Parrot parrot = (Parrot) a;
                animalStrings.add(a.getName() + "," + a.getSpecies() + "," + a.getAge() + "," + a.getPrice() + ","
                        + parrot.getFeatherColor());
            } else {
                animalStrings.add(a.getName() + "," + a.getSpecies() + "," + a.getAge() + "," + a.getPrice());
            }
        }

        Files.write(Paths.get(path), animalStrings);
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
        boolean match = validation.doesItMatchPromo(code, path);
        if (!(match)) {
            List<PromoCode> promoCodesList = new ArrayList<>();
            promoCodesList = loadPromoCodes(path);
            promoCodesList.add(new PromoCode(code, value));

            List<String> PromoCodeStrings = new ArrayList<>();
            for (PromoCode promo : promoCodesList) {
                PromoCodeStrings.add(promo.getCode() + "," + promo.getValue());
            }

            Files.write(Paths.get(path), PromoCodeStrings);
            System.out.println("Promocode added sucessfully!");

        } else {
            System.out.println("Promo code already exist");
        }
    }

    public void updatePromoCode(String code, double newValue, String path) throws IOException {
        boolean match = validation.doesItMatchPromo(code, path);
        if (!(match)) {
            System.out.println("Promo code doesn't exist");
        } else {
            deletePromoCode(code, path);
            writePromoCode(code, newValue, path);
            System.out.println("Promocode updated sucessfully!");
        }
    }

    public void deletePromoCode(String code, String path) throws IOException {
        boolean match = validation.doesItMatchPromo(code, path);
        if (!(match)) {
            System.out.println("Promo code doesn't exist");
        } else {
            List<PromoCode> promoCodesList = new ArrayList<>();
            promoCodesList = loadPromoCodes(path);

            int index = 0;

            for (PromoCode promo : promoCodesList) {
                String oldcode = promo.getCode();
                if (oldcode.equals(code)) {
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
            System.out.println("Promocode deleted sucessfully!");
        }
    }

    public void prntPromo(String path) throws IOException {
        List<PromoCode> promoCodesList = new ArrayList<>();
        promoCodesList = loadPromoCodes(path);
        int listSize = promoCodesList.size();
        if (listSize == 0) {
            System.out.println("No promo code");
        } else {
            for (int i = 0; i < listSize; i++) {
                System.out.println(promoCodesList.get(i));
            }
        }
    }

    public double matchingPromoCode(String input, String path) throws IOException {
        // get promo list
        List<PromoCode> promoList = new ArrayList<>();
        promoList = loadPromoCodes(path);

        String userInput = input;
        double value = 0;

        // for every promo in the promo list
        for (PromoCode promo : promoList) {
            // if match with promo list true
            if (userInput.equals(promo.getCode())) {
                value = promo.getValue();
            }
        }

        // return result
        return value;
    }

    // ADMIN SECTION
    public List<Admin> loadAdmins(String path) throws IOException {

        Path p = Paths.get(path);

        List<String> adminsString = Files.readAllLines(p);
        List<Admin> admins = new ArrayList<>();

        for (String admin : adminsString) {
            String[] pieces = admin.split(",");
            String user = pieces[0];
            String password = pieces[1];
            admins.add(new Admin(user, password));
        }

        return admins;
    }

    public void writeAdmin(String user, String password, String path) throws IOException {
        boolean match = validation.doesItMatchAdmin(user, path);
        if (!(match)) {
            List<Admin> adminsList = new ArrayList<>();
            adminsList = loadAdmins(path);
            adminsList.add(new Admin(user, password));

            List<String> adminsStrings = new ArrayList<>();
            for (Admin admin : adminsList) {
                adminsStrings.add(admin.getUser() + "," + admin.getPassword());
            }

            Files.write(Paths.get(path), adminsStrings);
            System.out.println("Admin added sucessfully!");
        } else {
            System.out.println("Admin already exist");
        }
    }

    public void updateAdmin(String user, String newPassword, String path) throws IOException {
        boolean match = validation.doesItMatchAdmin(user, path);
        if (!(match)) {
            System.out.println("Admin doesn't exist");
        } else {
            deleteAdmin(user, path);
            writeAdmin(user, newPassword, path);
            System.out.println("Admin updated sucessfully!");
        }
    }

    public void deleteAdmin(String user, String path) throws IOException {
        boolean match = validation.doesItMatchAdmin(user, path);
        if (!(match)) {
            System.out.println("Admin doesn't exist");
        } else {
            List<Admin> adminsList = new ArrayList<>();
            adminsList = loadAdmins(path);

            int index = 0;

            for (Admin admin : adminsList) {
                String oldUser = admin.getUser();
                if (oldUser.equals(user)) {
                    adminsList.remove(index);
                    break;
                }
                index++;
            }

            List<String> adminsStrings = new ArrayList<>();
            for (Admin admin : adminsList) {
                adminsStrings.add(admin.getUser() + "," + admin.getPassword());
            }

            Files.write(Paths.get(path), adminsStrings);
            System.out.println("Admin deleted sucessfully!");
        }
    }

    public void prntAdmin(String path) throws IOException {
        List<Admin> adminsList = new ArrayList<>();
        adminsList = loadAdmins(path);

        for (int i = 0; i < adminsList.size(); i++) {
            System.out.println(adminsList.get(i));
        }

    }

    public boolean matchingAdmin(String username, String password, String path) throws IOException {
        // get admin list
        List<Admin> adminsList = new ArrayList<>();
        adminsList = loadAdmins(path);

        boolean match = false;

        // for every admin in the admin list
        for (Admin admin : adminsList) {
            // set variables from list
            String usernameFromList = admin.getUser();
            String passwordFromList = admin.getPassword();

            // if match with admin list true
            if (usernameFromList.equals(username) && passwordFromList.equals(password)) {
                match = true;
            }
        }

        // return result
        return match;
    }

}