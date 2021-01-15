package Views;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame {
    private JPanel mainPanel;
    private JLabel titleLabel;
    private JButton loginButton;
    private JButton signupButton;

    Main() {
        super("Creator Hub");
        this.setContentPane(this.mainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        loginButton.addActionListener(e -> {
            dispose();
            Login loginFrame = new Login();
            loginFrame.setVisible(true);
        });
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.setVisible(true);
    }
}
