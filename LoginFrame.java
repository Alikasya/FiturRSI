import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton, signUpButton;

    public LoginFrame() {
        setTitle("Login");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setBounds(50, 50, 100, 25);
        add(usernameLabel);

        usernameField = new JTextField();
        usernameField.setBounds(150, 50, 200, 25);
        add(usernameField);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(50, 100, 100, 25);
        add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(150, 100, 200, 25);
        add(passwordField);

        loginButton = new JButton("Login");
        loginButton.setBounds(150, 150, 100, 25);
        add(loginButton);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                if (username.equals("aku") && password.equals("12345")) {
                    JOptionPane.showMessageDialog(null, "Login successful!");
                    dispose();

                    User user = new User("aku123@gmail.com", password, "", username, "", "", "", "");
                    new ProfileFrame(user);
                } else {
                    JOptionPane.showMessageDialog(null, "Login failed, try again.");
                }
            }
        });

        JLabel signUpText = new JLabel("Don't have an account?");
        signUpText.setBounds(90, 200, 150, 25);
        add(signUpText);

        signUpButton = new JButton("Sign Up");
        signUpButton.setBounds(240, 200, 80, 25);
        signUpButton.setForeground(Color.BLUE);
        signUpButton.setBorderPainted(false); 
        signUpButton.setContentAreaFilled(false); 
        signUpButton.setFocusPainted(false);
        add(signUpButton);

        signUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); 
                new SignUpFrame(); 
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new LoginFrame();
    }
}
