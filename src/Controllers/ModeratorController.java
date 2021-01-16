package Controllers;

import Models.CreatorRequest;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;

public class ModeratorController {
    private IModerator serverModeratorController;

    public ModeratorController() {
        try {
            Registry registry = LocateRegistry.getRegistry(1099);
            this.serverModeratorController = (IModerator) registry.lookup("moderatorController");
        } catch (RemoteException | NotBoundException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<CreatorRequest> getCreatorRequests() {
        try {
            return this.serverModeratorController.getCreatorRequests();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return null;
    }
}
