package Views;

import Controllers.AuthorizationController;
import Models.Feed;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewerHome extends JFrame {
    private JButton logoutButton;
    private JPanel mainPanel;
    private JPanel navbarPanel;
    private JLabel titleLabel;
    private JScrollPane feedScrollPane;
    private Feed feed;

    public ViewerHome() {
        super("Creator Hub | Viewer Home");
        this.setContentPane(this.mainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        logoutButton.addActionListener(e -> {
            AuthorizationController.logout();
            dispose();
            Main mainFrame = new Main();
            mainFrame.setVisible(true);
        });
    }
}
