package Controllers;

import Models.User;

public class AuthorizationController {
    private static User currentUser;

    public static User getCurrentUser() {
        return currentUser;
    }

    public static void login(String email, String password) {
        System.out.println("Email: " + email);
        System.out.println("Password: " + password);
        System.out.println("Log In");
    }

    public static void logout() {
        currentUser = null;
    }

    public static void signup(String email, String password, String name, String country) {
        System.out.println("Sign up");
    }
}
