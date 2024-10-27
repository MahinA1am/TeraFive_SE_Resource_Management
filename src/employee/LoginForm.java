package employee;

import javax.swing.*;
import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
import java.sql.*;

public class LoginForm extends JFrame {

    // Declare components
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JComboBox<String> roleComboBox;
    private JButton loginButton, clearButton, registerButton;

    // Constructor
    public LoginForm() {
        setTitle("Login Form");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Panel for input fields and buttons
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2, 10, 10));

        // Username
        panel.add(new JLabel("Username:"));
        usernameField = new JTextField();
        panel.add(usernameField);

        // Password
        panel.add(new JLabel("Password:"));
        passwordField = new JPasswordField();
        panel.add(passwordField);

        // Role
        panel.add(new JLabel("Role:"));
        String[] roles = {"Admin", "Employee"};
        roleComboBox = new JComboBox<>(roles);
        panel.add(roleComboBox);

        // Buttons
        loginButton = new JButton("Login");
        clearButton = new JButton("Clear");
        registerButton = new JButton("Register");

        // Center the buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(loginButton);
        buttonPanel.add(clearButton);
        buttonPanel.add(registerButton);

        // Add panels to the main frame
        add(panel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        // Button actions
        loginButton.addActionListener(e -> login());
        clearButton.addActionListener(e -> clearFields());
        registerButton.addActionListener(e -> registerUser());

        setVisible(true);
    }

    // Login action
    private void login() {
        String username = usernameField.getText();
        String password = String.valueOf(passwordField.getPassword());
        String role = (String) roleComboBox.getSelectedItem();

        if (username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all fields.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        boolean isValid = validateCredentials(username, password, role);
        if (isValid) {
            JOptionPane.showMessageDialog(this, "Login successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
            boolean isAdmin = role.equals("Admin");
            new Homepage(isAdmin, username);  // Opens the homepage with user role
            dispose();  // Close the login form
        } else {
            JOptionPane.showMessageDialog(this, "Invalid username or password.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Clear fields action
    private void clearFields() {
        usernameField.setText("");
        passwordField.setText("");
        roleComboBox.setSelectedIndex(0);
    }

    // Placeholder register action
    private void registerUser() {
        JOptionPane.showMessageDialog(this, "Redirecting to registration form...", "Register", JOptionPane.INFORMATION_MESSAGE);
        // Redirect to registration form logic here
    }

    // Validate credentials with the database
    private boolean validateCredentials(String username, String password, String role) {
        String url = "jdbc:mysql://localhost:3306/Save"; // Placeholder database URL
        String dbUser = "root"; // Placeholder username
        String dbPass = "password"; // Placeholder password

        String table = role.equals("Admin") ? "admin" : "employee";
        String query = "SELECT * FROM " + table + " WHERE username = ? AND password = ?";

        try (Connection con = DriverManager.getConnection(url, dbUser, dbPass);
             PreparedStatement stmt = con.prepareStatement(query)) {

            stmt.setString(1, username);
            stmt.setString(2, password);

            ResultSet rs = stmt.executeQuery();
            return rs.next();  // Return true if a match is found

        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Database error.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    // Main method to run the login form
    public static void main(String[] args) {
        new LoginForm();
    }
    
    private static final long serialVersionUID = 1L;
}
