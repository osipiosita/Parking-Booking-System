package src;

import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class App {
    private static Authentication authentication;

    public static void main(String[] args) {
        AppDB appDB = new AppDB();
        authentication = new Authentication(appDB);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    registerUser(scanner);
                    break;
                case 2:
                    loginUser(scanner);
                    break;
                case 3:
                    System.out.println("Exiting application.");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void registerUser(Scanner scanner) {
        System.out.print("Enter username: ");
        String username = scanner.next();
        System.out.print("Enter email: ");
        String email = scanner.next();
        System.out.print("Enter password: ");
        String password = scanner.next();

        try {
            if (authentication.register(username, email, password)) {
                System.out.println("Registration successful.");
            } else {
                System.out.println("Registration failed. User with email already exists.");
            }
        } catch (NoSuchAlgorithmException e) {
            System.out.println(" Registration failed. Try again!");
        }
    }

    private static void loginUser(Scanner scanner) {
        System.out.print("Enter email: ");
        String email = scanner.next();
        System.out.print("Enter password: ");
        String password = scanner.next();

        try {
            if (authentication.login(email, password)) {
                System.out.println("Login successful.");
            } else {
                System.out.println("Login failed. Invalid email or password.");
            }
        } catch (NoSuchAlgorithmException e) {
            System.out.println("Login failed. Try again!");
        }
    }
}

