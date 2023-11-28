package project;

import java.io.IOException;
import java.util.InputMismatchException;
import static project.Console.*;
import java.util.Scanner;

public class App {
    final static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        // FileHandler file = new FileHandler();
        // file.loadAnimals();
        // test the promo - TEST PASSED WORKS WITH THIS NEW RELATIVE PATH
        // String path = "code/petshop/src/main/resources/promo.csv";
        // System.out.println(path);
        // PromoCodeFileHandler tester = new PromoCodeFileHandler();
        // tester.loadPromoCodes(path);

        // greet user
        greet();
        // login as admin or user?
        displayLoginMenu();

    }

}
