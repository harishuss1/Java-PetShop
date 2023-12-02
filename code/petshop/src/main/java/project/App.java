package project;

import java.io.IOException;
import static project.Console.*;
import java.util.Scanner;
/**
 * The App class serves as the entry point for the pet shop application.
 * It contains the main method responsible for initiating the program and
 * directing users to the login menu for either admin or regular user access.
 */

public class App {
    final static Scanner scanner = new Scanner(System.in);
/**
     * The main method of the application.
     *
     * @param args the command-line arguments.
     * @throws IOException if an I/O error occurs.
     */
    public static void main(String[] args) throws IOException {
        // greet user
        greet();
        // login as admin or user?
        displayLoginMenu();

    }

}
