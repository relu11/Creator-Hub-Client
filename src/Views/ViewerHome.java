package Views;

import Controllers.AuthorizationController;
import Controllers.PostsController;
import Models.Feed;

import javax.swing.*;

public class ViewerHome extends JFrame {
    private JButton logoutButton;
    private JPanel mainPanel;
    private JPanel navbarPanel;
    private JLabel titleLabel;
    private JScrollPane feedScrollPane;
    private Feed feed;
    private AuthorizationController authorizationController;
    private PostsController postsController;

    public ViewerHome() {
        super("Creator Hub | Viewer Home");
        this.setContentPane(this.mainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.authorizationController = new AuthorizationController();
        this.postsController = new PostsController();
        this.postsController.getPosts(AuthorizationController.getCurrentUser());
        logoutButton.addActionListener(e -> {
            this.authorizationController.logout();
            dispose();
            Main mainFrame = new Main();
            mainFrame.setVisible(true);
        });
    }
}
