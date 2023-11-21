package project;

import java.util.InputMismatchException;
import static project.Console.*;
import java.util.Scanner;

public class App {
    final static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        // greet user
        greet();
        // login as admin or user?
        displayLoginMenu();
    }

}
