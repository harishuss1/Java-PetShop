package project;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Validation {

    private static final Scanner scanner = new Scanner(System.in);

    public  int getPositiveInteger(String prompt) {
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

    public  boolean getValidBoolean(String prompt) {
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
}
