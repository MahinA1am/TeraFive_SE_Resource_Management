package hospital;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPage extends JFrame {

    // Predefined username and password for demo purposes
    private final String USERNAME = "admin";
    private final String PASSWORD = "password123";

    // Constructor for LoginPage
    public LoginPage() {
        // Set the title of the JFrame
        setTitle("Login Page");
        setSize(400, 300); // Set size of the window
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the window

        // Create a panel with a grid layout for alignment
        JPanel panel = new JPanel(new GridBagLayout());
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
        panel.add(userLabel, gbc);

        gbc.gridx = 1; gbc.gridy = 0;
        panel.add(userTextField, gbc);

        gbc.gridx = 0; gbc.gridy = 1;
        panel.add(passwordLabel, gbc);

        gbc.gridx = 1; gbc.gridy = 1;
        panel.add(passwordField, gbc);

        // Buttons are in the next row, center-aligned
        gbc.gridx = 0; gbc.gridy = 2;
        gbc.gridwidth = 2; // Make the buttons span two columns
        gbc.anchor = GridBagConstraints.CENTER; // Center-align the buttons

        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(loginButton);
        buttonPanel.add(registerButton);
        buttonPanel.add(clearButton);
        panel.add(buttonPanel, gbc);

        // Add the panel to the frame
        add(panel);

        // Make the frame visible
        setVisible(true);

        // Action Listeners for Buttons
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = userTextField.getText();
                String password = String.valueOf(passwordField.getPassword());

                // Check if the entered credentials match
                if (USERNAME.equals(username) && PASSWORD.equals(password)) {
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
                //JOptionPane.showMessageDialog(null, "Redirecting to Registration Page");
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

    // Main method to run the application
    public static void main(String[] args) {
        new LoginPage();
    }
    private static final long serialVersionUID = 1L;
}

