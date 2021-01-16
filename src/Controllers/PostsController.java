package Controllers;

import Models.Creator;
import Models.Post;
import Models.User;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PostsController {
    private IPostsController serverPostsController;
    public PostsController() {
        try {
            Registry registry = LocateRegistry.getRegistry(1099);
            this.serverPostsController = (IPostsController) registry.lookup("postsController");
        } catch (RemoteException | NotBoundException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Post> getPosts(User user) {
        System.out.println("Get Posts");
        try {
            ArrayList<Post> posts = this.serverPostsController.getPosts(user);
            System.out.println(posts);
            return posts;
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Post getPost(User user) {
        System.out.println("Get Post");
        try {
            Post post = this.serverPostsController.GetPost(user);
            System.out.println(post);
            return post;
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public void createPost(Post post, User user) {
        try {
            this.serverPostsController.CreatePost((Creator) user, post);
            System.out.println("Created");
        } catch (RemoteException ex) {
            Logger.getLogger(PostsController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
