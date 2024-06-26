import java.util.Scanner;
import java.util.regex.Pattern;

public class EasyKanban {

    private static String registeredUsername;
    private static String registeredPassword;
    private static String firstName;
    private static String lastName;

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            // Register User
            System.out.println("Register an account");

            System.out.print("Enter username (must be less than 5 characters long and contain an underscore): ");
            String username = scanner.nextLine();
            while (!isValidUsername(username)) {
                System.out.print("Username is not correctly formatted,please ensure that your username contains an underscore and is no more than 5 characters in length. Enter again: ");
                username = scanner.nextLine();
            }

            System.out.print("Enter password (8 or more characters, contain a capital letter and a number): ");
            String password = scanner.nextLine();
            while (!isValidPassword(password)) {
                
                System.out.print("Password is not correctly formatted,please ensure that the password contains at least 8 characters, a capital letter, a number and a special character. Enter again: ");
                password = scanner.nextLine();
            }
            
        

            System.out.print("Enter your first name: ");
            firstName = scanner.nextLine();

            System.out.print("Enter your last name: ");
            lastName = scanner.nextLine();

            // Save registered details
            registeredUsername = username;
            registeredPassword = password;

            System.out.println("Register successful!");

            // Login User
            System.out.println("Login to your account");

            System.out.print("Enter username: ");
            String loginUsername = scanner.nextLine();
            System.out.print("Enter password: ");
            String loginPassword = scanner.nextLine();

            if (isValidLogin(loginUsername, loginPassword)) {
                System.out.println("Login successful!");
                System.out.println("Welcome to Easy Kanban, " + firstName + " " + lastName + "Its great seeing you again");
            } else {
                System.out.println("Login failed. Incorrect username or password.");
            }
        }
    }

    private static boolean isValidUsername(String username) {
        return username.length() < 5 && username.contains("_");
    }

    private static boolean isValidPassword(String password) {
        return password.length() >= 8 &&
               Pattern.compile("[A-Z]").matcher(password).find() &&
               Pattern.compile("[0-9]").matcher(password).find();
    }

    private static boolean isValidLogin(String username, String password) {
        return username.equals(registeredUsername) && password.equals(registeredPassword);
    }
}
