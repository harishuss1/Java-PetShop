package project;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Validation {

    private static final Scanner scanner = new Scanner(System.in);
    /**
     * Gets a positive integer from the user.
     *
     * @param prompt the prompt to display to the user.
     * @return a positive integer entered by the user.
     */
    public int getPositiveInteger(String prompt) {
        int input = 0;
        boolean isValidInput = false;

        while (!isValidInput) {
            try {
                System.out.print(prompt);
                input = scanner.nextInt();

                if (input >= 0) {
                    isValidInput = true;
                } else {
                    System.out.println("Please enter a positive integer.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
                scanner.next();
            }
        }

        return input;
    }
    /**
     * Gets a positive double from the user.
     *
     * @param prompt the prompt to display to the user.
     * @return a positive double entered by the user.
     */
    public double getPositiveDouble(String prompt) {
        double input = 0.0;
        boolean isValidInput = false;

        while (!isValidInput) {
            try {
                System.out.print(prompt);
                input = scanner.nextDouble();

                if (input >= 0.0) {
                    isValidInput = true;
                } else {
                    System.out.println("Please enter a positive double.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid double.");
                scanner.next();
            }
        }

        return input;
    }
    /**
     * Gets a valid boolean from the user.
     *
     * @param prompt the prompt to display to the user.
     * @return a boolean value entered by the user.
     */
    public boolean getValidBoolean(String prompt) {
        boolean isValidInput = false;
        boolean result = false;

        while (!isValidInput) {
            System.out.print(prompt);
            String input = scanner.next().toLowerCase();

            if (input.equals("true") || input.equals("false")) {
                result = Boolean.parseBoolean(input);
                isValidInput = true;
            } else {
                System.out.println("Please enter 'true' or 'false'.");
            }
        }

        return result;
    }

    /**
     * Gets a non-empty string input from the user.
     *
     * @param prompt the prompt to display to the user.
     * @return a non-empty string entered by the user.
     */
    public String getStringInput(String prompt) {
        String input;
        do {
            System.out.print(prompt + " ");
            input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println("Input cannot be empty. Please enter a valid value.");
            }
        } while (input.isEmpty());

        return input;
    }
    /**
     * Checks if the input matches any promo codes in the provided path.
     *
     * @param input the input to match.
     * @param path  the path to the file containing promo codes.
     * @return true if the input matches any promo code, false otherwise.
     * @throws IOException if there is an issue reading input or output.
     */
    public boolean doesItMatchPromo(String input, String path) throws IOException {
        FileHandler fileHandler = new FileHandler();
        // get promo list
        List<PromoCode> promoList = new ArrayList<>();
        promoList = fileHandler.loadPromoCodes(path);

        boolean match = false;

        // for every promo in the promo list
        for (PromoCode promo : promoList) {
            // if match with promo list true
            if (input.equals(promo.getCode())) {
                match = true;
            }
        }

        return match;
    }
    /**
     * Checks if the input matches any admin usernames in the provided path.
     *
     * @param input the input to match.
     * @param path  the path to the file containing admin usernames.
     * @return true if the input matches any admin username, false otherwise.
     * @throws IOException if there is an issue reading input or output.
     */
    public boolean doesItMatchAdmin(String input, String path) throws IOException {
        FileHandler fileHandler = new FileHandler();
        // get admin list
        List<Admin> adminList = new ArrayList<>();
        adminList = fileHandler.loadAdmins(path);

        boolean match = false;

        // for every admin in the admin list
        for (Admin admin : adminList) {
            // if match with admin list true
            if (input.equals(admin.getUser())) {
                match = true;
            }
        }

        return match;
    }
}
