package Controllers;

import Models.User;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class UserController {
    private IUserController serverUserController;

    public UserController() {
        try {
            Registry registry = LocateRegistry.getRegistry(1099);
            this.serverUserController = (IUserController) registry.lookup("userController");
        } catch (RemoteException | NotBoundException e) {
            e.printStackTrace();
        }
    }

    public void requestToBecomeCreator(User user) {
        try {
            this.serverUserController.requestToBeCreator(user);
            System.out.println("sent creator request");
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
