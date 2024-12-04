package hospital;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginPage extends JFrame {

    // Database credentials
    private static final String DB_URL = "jdbc:mysql://localhost:3306/hospital"; // Replace with your DB URL
    private static final String DB_USERNAME = "root"; // Database username
    private static final String DB_PASSWORD = "admin"; // Database password

    // Constructor for LoginPage
    public LoginPage() {
        // Set the title and default settings for the JFrame
        setTitle("Login Page");
        setSize(600, 400); // Adjusted size for background image
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the window

        // Load background image
        JLabel backgroundLabel = new JLabel(new ImageIcon("path_to_background_image.jpg"));
        backgroundLabel.setLayout(new GridBagLayout()); // Use GridBagLayout for overlaying components

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Padding between components

        // Create Labels and Input Fields
        JLabel userLabel = new JLabel("Username:");
        JTextField userTextField = new JTextField(15);

        JLabel passwordLabel = new JLabel("Password:");
        JPasswordField passwordField = new JPasswordField(15);

        // Create Buttons
        JButton loginButton = new JButton("Login");
        JButton registerButton = new JButton("Register");
        JButton clearButton = new JButton("Clear");

        // Align components in grid layout
        gbc.gridx = 0; gbc.gridy = 0;
        backgroundLabel.add(userLabel, gbc);

        gbc.gridx = 1; gbc.gridy = 0;
        backgroundLabel.add(userTextField, gbc);

        gbc.gridx = 0; gbc.gridy = 1;
        backgroundLabel.add(passwordLabel, gbc);

        gbc.gridx = 1; gbc.gridy = 1;
        backgroundLabel.add(passwordField, gbc);

        // Buttons are in the next row, center-aligned
        gbc.gridx = 0; gbc.gridy = 2;
        gbc.gridwidth = 2; // Make the buttons span two columns
        gbc.anchor = GridBagConstraints.CENTER; // Center-align the buttons

        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(loginButton);
        buttonPanel.add(registerButton);
        buttonPanel.add(clearButton);
        backgroundLabel.add(buttonPanel, gbc);

        // Add the backgroundLabel to the frame
        add(backgroundLabel);

        // Make the frame visible
        setVisible(true);

        // Action Listeners for Buttons
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = userTextField.getText();
                String password = String.valueOf(passwordField.getPassword());

                // Validate credentials via the database
                if (validateCredentials(username, password)) {
                    JOptionPane.showMessageDialog(null, "Login Successful!");
                    // Open the Homepage window
                    new Homepage();
                    dispose(); // Close the login window
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Username or Password!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        registerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Redirect to Registration Form
                new RegistrationForm();
            }
        });

        clearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                userTextField.setText("");
                passwordField.setText("");
            }
        });
    }

    // Method to validate credentials against the database
    private boolean validateCredentials(String username, String password) {
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {
            String query = "SELECT * FROM admin WHERE username = ? AND password = ?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, username);
            pstmt.setString(2, password);

            ResultSet rs = pstmt.executeQuery();
            return rs.next(); // Return true if a matching record is found
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Database Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    // Main method to run the application
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new LoginPage());
    }

    private static final long serialVersionUID = 1L;
}
