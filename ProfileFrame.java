import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File; 

public class ProfileFrame extends JFrame {
    private JTextField nameField, usernameField, genderField, phoneField, birthDateField, emailField;
    private JTextArea addressArea;
    private JLabel photoLabel;
    private JButton updateButton, deleteButton, uploadPhotoButton;
    private String photoPath;

    public ProfileFrame(User user) {
        setTitle("Edit Profile");
        setSize(450, 750);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        photoLabel = new JLabel();
        photoLabel.setBounds(150, 10, 150, 150);
        photoLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        photoLabel.setHorizontalAlignment(JLabel.CENTER);
        add(photoLabel);

        uploadPhotoButton = new JButton("Upload Photo");
        uploadPhotoButton.setBounds(150, 170, 150, 25);
        add(uploadPhotoButton);

        uploadPhotoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int result = fileChooser.showOpenDialog(null);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    photoPath = selectedFile.getAbsolutePath();
                    ImageIcon photoIcon = new ImageIcon(new ImageIcon(photoPath).getImage()
                            .getScaledInstance(150, 150, Image.SCALE_SMOOTH));
                    photoLabel.setIcon(photoIcon);
                }
            }
        });

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(50, 210, 100, 25);
        add(emailLabel);

        emailField = new JTextField(user.getEmail());
        emailField.setBounds(150, 210, 250, 25);
        add(emailField);

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(50, 250, 100, 25);
        add(nameLabel);

        nameField = new JTextField(user.getName());
        nameField.setBounds(150, 250, 250, 25);
        add(nameField);

        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setBounds(50, 290, 100, 25);
        add(usernameLabel);

        usernameField = new JTextField(user.getUsername());
        usernameField.setBounds(150, 290, 250, 25);
        add(usernameField);

        JLabel genderLabel = new JLabel("Gender:");
        genderLabel.setBounds(50, 330, 100, 25);
        add(genderLabel);

        genderField = new JTextField(user.getGender());
        genderField.setBounds(150, 330, 250, 25);
        add(genderField);

        JLabel phoneLabel = new JLabel("Phone:");
        phoneLabel.setBounds(50, 370, 100, 25);
        add(phoneLabel);

        phoneField = new JTextField(user.getPhone());
        phoneField.setBounds(150, 370, 250, 25);
        add(phoneField);

        JLabel birthDateLabel = new JLabel("Birth Date:");
        birthDateLabel.setBounds(50, 410, 100, 25);
        add(birthDateLabel);

        birthDateField = new JTextField(user.getBirthDate());
        birthDateField.setBounds(150, 410, 250, 25);
        add(birthDateField);

        JLabel addressLabel = new JLabel("Address:");
        addressLabel.setBounds(50, 450, 100, 25);
        add(addressLabel);

        addressArea = new JTextArea(user.getAddress());
        addressArea.setBounds(150, 450, 250, 75);
        addressArea.setLineWrap(true);
        addressArea.setWrapStyleWord(true);
        add(addressArea);

        updateButton = new JButton("Update");
        updateButton.setBounds(50, 550, 100, 25);
        add(updateButton);

        deleteButton = new JButton("Delete Profile");
        deleteButton.setBounds(200, 550, 150, 25);
        add(deleteButton);

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                user.setEmail(emailField.getText());
                user.setName(nameField.getText());
                user.setUsername(usernameField.getText());
                user.setGender(genderField.getText());
                user.setPhone(phoneField.getText());
                user.setBirthDate(birthDateField.getText());
                user.setAddress(addressArea.getText());

                JOptionPane.showMessageDialog(null, "Profile updated!");
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int response = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete your profile?", "Confirm", JOptionPane.YES_NO_OPTION);
                if (response == JOptionPane.YES_OPTION) {
                    JOptionPane.showMessageDialog(null, "Profile deleted!");
                    dispose();
                    new LoginFrame();
                }
            }
        });

        setVisible(true);
    }
}
