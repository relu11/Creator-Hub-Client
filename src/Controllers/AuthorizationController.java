package Controllers;

import Models.User;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class AuthorizationController {
    private static User currentUser;
    private IAuthorization serverAuthController;

    public AuthorizationController() {
        try {
            Registry registry = LocateRegistry.getRegistry(1099);
            this.serverAuthController = (IAuthorization) registry.lookup("authorizationController");
        } catch (RemoteException | NotBoundException e) {
            e.printStackTrace();
        }
    }

    public static User getCurrentUser() {
        return currentUser;
    }

    public void login(String email, String password) {
        System.out.println("Email: " + email);
        System.out.println("Password: " + password);
        System.out.println("Log In");
        try {
            User user = this.serverAuthController.login(email, password);
            if (user != null) {
                System.out.println(user);
                System.out.println(user.getEmail());
                System.out.println(user.getName());
                System.out.println(user.getCountry());
                currentUser = user;
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public void logout() {
        currentUser = null;
    }

    public void signup(String email, String password, String name, String country) {
        try {
            User user = this.serverAuthController.signup(email, name, password, country);
            if (user != null) {
                System.out.println(user.getCountry());
                System.out.println(user.getEmail());
                System.out.println(user.getName());
            }

        } catch (RemoteException e) {
            e.printStackTrace();
        }
        System.out.println("Sign up");
    }
}
