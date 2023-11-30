package project;

import java.io.IOException;
import static project.Console.*;
import java.util.Scanner;

public class App {
    final static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        // greet user
        greet();
        // login as admin or user?
        displayLoginMenu();

    }

}
