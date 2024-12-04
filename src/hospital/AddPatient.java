package hospital;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class AddPatient extends JFrame {

    private JTextField nameField, doctorField, diseaseField, phoneField, bloodGroupField;

    public AddPatient() {
        setTitle("Add Patient");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Set background image
        JLabel background = new JLabel(new ImageIcon("path/to/your/background.jpg"));
        background.setLayout(new GridBagLayout()); // Use GridBagLayout for layering components
        setContentPane(background);

        // Create a transparent panel for form components
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setOpaque(false); // Make panel background transparent
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Padding between components

        // Form Components
        JLabel nameLabel = new JLabel("Name:");
        nameField = new JTextField(15);

        JLabel doctorLabel = new JLabel("Consulted Doctor:");
        doctorField = new JTextField(15);

        JLabel diseaseLabel = new JLabel("Disease Details:");
        diseaseField = new JTextField(15);

        JLabel phoneLabel = new JLabel("Phone No:");
        phoneField = new JTextField(15);

        JLabel bloodGroupLabel = new JLabel("Blood Group:");
        bloodGroupField = new JTextField(15);

        JButton addButton = new JButton("Add Patient");

        // Add components to panel
        gbc.gridx = 0; gbc.gridy = 0; panel.add(nameLabel, gbc);
        gbc.gridx = 1; panel.add(nameField, gbc);

        gbc.gridx = 0; gbc.gridy = 1; panel.add(doctorLabel, gbc);
        gbc.gridx = 1; panel.add(doctorField, gbc);

        gbc.gridx = 0; gbc.gridy = 2; panel.add(diseaseLabel, gbc);
        gbc.gridx = 1; panel.add(diseaseField, gbc);

        gbc.gridx = 0; gbc.gridy = 3; panel.add(phoneLabel, gbc);
        gbc.gridx = 1; panel.add(phoneField, gbc);

        gbc.gridx = 0; gbc.gridy = 4; panel.add(bloodGroupLabel, gbc);
        gbc.gridx = 1; panel.add(bloodGroupField, gbc);

        gbc.gridx = 0; gbc.gridy = 5; gbc.gridwidth = 2; panel.add(addButton, gbc);

        // Add panel to the background
        background.add(panel);

        // Action Listener for Add Button
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addPatientToDatabase();
            }
        });

        setVisible(true);
    }

    // Method to add patient information to the database
    private void addPatientToDatabase() {
        String url = "jdbc:mysql://localhost:3306/hospital"; // Replace with actual database URL
        String user = "root"; // Replace with actual database username
        String password = "admin"; // Replace with actual database password

        String name = nameField.getText();
        String doctor = doctorField.getText();
        String disease = diseaseField.getText();
        String phone = phoneField.getText();
        String bloodGroup = bloodGroupField.getText();

        String query = "INSERT INTO patient (name, consulted_doctor, disease_details, phone_no, blood_group) VALUES (?, ?, ?, ?, ?)";

        try (Connection con = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = con.prepareStatement(query)) {

            pstmt.setString(1, name);
            pstmt.setString(2, doctor);
            pstmt.setString(3, disease);
            pstmt.setString(4, phone);
            pstmt.setString(5, bloodGroup);

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(this, "Patient added successfully");
            } else {
                JOptionPane.showMessageDialog(this, "Failed to add patient");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error connecting to database", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        new AddPatient();
    }
    private static final long serialVersionUID = 1L;
}
