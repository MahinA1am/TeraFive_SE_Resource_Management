package hospital;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class RegistrationForm extends JFrame {

    // Constructor for RegistrationForm
    public RegistrationForm() {
        // Set the title of the JFrame
        setTitle("Admin Registration Form");
        setSize(400, 400); // Set the size of the window
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Dispose window on close
        setLocationRelativeTo(null); // Center the window

        // Add a WindowListener to reopen the LoginPage when the form is closed
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent e) {
                new LoginPage(); // Reopen LoginPage
            }
        });

        // Create a panel with a grid layout for alignment
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Padding between components

        // Create Labels and Input Fields
        JLabel nameLabel = new JLabel("Name:");
        JTextField nameTextField = new JTextField(15);

        JLabel usernameLabel = new JLabel("Username:");
        JTextField usernameTextField = new JTextField(15);

        JLabel passwordLabel = new JLabel("Password:");
        JPasswordField passwordField = new JPasswordField(15);

        JLabel ageLabel = new JLabel("Age:");
        JTextField ageTextField = new JTextField(15);

        JLabel dobLabel = new JLabel("Date of Birth (YYYY-MM-DD):");
        JTextField dobTextField = new JTextField(15);

        JLabel phoneLabel = new JLabel("Phone Number:");
        JTextField phoneTextField = new JTextField(15);

        // Create Register Button
        JButton registerButton = new JButton("Register");

        // Align components in grid layout
        gbc.gridx = 0; gbc.gridy = 0;
        panel.add(nameLabel, gbc);

        gbc.gridx = 1; gbc.gridy = 0;
        panel.add(nameTextField, gbc);

        gbc.gridx = 0; gbc.gridy = 1;
        panel.add(usernameLabel, gbc);

        gbc.gridx = 1; gbc.gridy = 1;
        panel.add(usernameTextField, gbc);

        gbc.gridx = 0; gbc.gridy = 2;
        panel.add(passwordLabel, gbc);

        gbc.gridx = 1; gbc.gridy = 2;
        panel.add(passwordField, gbc);

        gbc.gridx = 0; gbc.gridy = 3;
        panel.add(ageLabel, gbc);

        gbc.gridx = 1; gbc.gridy = 3;
        panel.add(ageTextField, gbc);

        gbc.gridx = 0; gbc.gridy = 4;
        panel.add(dobLabel, gbc);

        gbc.gridx = 1; gbc.gridy = 4;
        panel.add(dobTextField, gbc);

        gbc.gridx = 0; gbc.gridy = 5;
        panel.add(phoneLabel, gbc);

        gbc.gridx = 1; gbc.gridy = 5;
        panel.add(phoneTextField, gbc);

        // Register Button
        gbc.gridx = 0; gbc.gridy = 6;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(registerButton, gbc);

        // Add the panel to the frame
        add(panel);

        // Make the frame visible
        setVisible(true);

        // Action Listener for Register Button
        registerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Retrieve data from input fields
                String name = nameTextField.getText();
                String username = usernameTextField.getText();
                String password = String.valueOf(passwordField.getPassword());
                String age = ageTextField.getText();
                String dob = dobTextField.getText();
                String phone = phoneTextField.getText();

                // Call method to save data to the database
                saveToDatabase(name, username, password, age, dob, phone);
            }
        });
    }

    // Method to save registration details to the database
    private void saveToDatabase(String name, String username, String password, String age, String dob, String phone) {
        String url = "jdbc:mysql://localhost:3306/hospital";
        String user = "root";
        String pass = "admin";

        String query = "INSERT INTO admin (name, username, password, age, dob, phone) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection con = DriverManager.getConnection(url, user, pass);
             PreparedStatement stmt = con.prepareStatement(query)) {

            stmt.setString(1, name);
            stmt.setString(2, username);
            stmt.setString(3, password);
            stmt.setString(4, age);
            stmt.setString(5, dob);
            stmt.setString(6, phone);

            int rowsInserted = stmt.executeUpdate();
            if (rowsInserted > 0) {
                JOptionPane.showMessageDialog(null, "Registration Successful!");
                dispose(); // Close RegistrationForm
                new LoginPage(); // Reopen LoginPage
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error: Could not connect to database", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Main method to run the application
    public static void main(String[] args) {
        new RegistrationForm();
    }
    private static final long serialVersionUID = 1L;
}
