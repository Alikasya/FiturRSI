import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignUpFrame extends JFrame {
    private JTextField emailField, usernameField;
    private JPasswordField passwordField;
    private JButton signUpButton;

    private static String savedUsername;
    private static String savedPassword;

    public SignUpFrame() {
        setTitle("Sign Up");
        setSize(400, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(50, 50, 100, 25);
        add(emailLabel);

        emailField = new JTextField();
        emailField.setBounds(150, 50, 200, 25);
        add(emailField);

        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setBounds(50, 100, 100, 25);
        add(usernameLabel);

        usernameField = new JTextField();
        usernameField.setBounds(150, 100, 200, 25);
        add(usernameField);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(50, 150, 100, 25);
        add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(150, 150, 200, 25);
        add(passwordField);

        signUpButton = new JButton("Sign Up");
        signUpButton.setBounds(150, 200, 100, 25);
        add(signUpButton);

        signUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                savedUsername = usernameField.getText();
                savedPassword = new String(passwordField.getPassword());

                JOptionPane.showMessageDialog(null, "Sign up successful! Please log in.");
                dispose();
                new LoginFrame();
            }
        });

        setVisible(true);
    }

    public static String getSavedUsername() {
        return savedUsername;
    }

    public static String getSavedPassword() {
        return savedPassword;
    }
}
