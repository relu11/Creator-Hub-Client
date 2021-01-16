/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.Chat;
import Models.User;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Islam Mohamed
 */
public class ChatController {
    private IChatController serverChatController;
    
    public ChatController() {
        try {
            Registry registry = LocateRegistry.getRegistry(1099);
            this.serverChatController = (IChatController) registry.lookup("chatController");
        } catch (RemoteException | NotBoundException e) {
            e.printStackTrace();
        }
    }
    
    public ArrayList<Chat> getChats(User user) {
        try {
            return this.serverChatController.getChats(user.getId());
        } catch (RemoteException ex) {
            Logger.getLogger(ChatController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
