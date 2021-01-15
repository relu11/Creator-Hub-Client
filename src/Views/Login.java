package Views;

import Controllers.AuthorizationController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame {
    private JTextField emailField;
    private JTextField passwordField;
    private JButton loginButton;
    private JLabel emailLabel;
    private JLabel passwordLabel;
    private JLabel titleLabel;
    private JPanel mainPanel;

    public Login() {
        super("Creator Hub | Login");
        this.setContentPane(this.mainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        loginButton.addActionListener(e -> {
            AuthorizationController.login(emailField.getText(), passwordField.getText());
            dispose();
            ViewerHome viewerHome = new ViewerHome();
            viewerHome.setVisible(true);
        });
    }

    public static void main(String[] args) {
        Login login = new Login();
        login.setVisible(true);
    }
}
