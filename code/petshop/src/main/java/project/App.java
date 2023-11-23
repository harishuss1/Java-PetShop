package project;

import java.io.IOException;
import java.util.InputMismatchException;
import static project.Console.*;
import java.util.Scanner;

public class App {
    final static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        // test the promo
        String path = "promo.csv";
        PromoCodeFileHandler tester = new PromoCodeFileHandler();
        tester.loadPromoCodes(path);

        // greet user
        greet();
        // login as admin or user?
        displayLoginMenu();

    }

}
