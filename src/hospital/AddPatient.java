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
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(6, 2, 10, 10));

        // Create and add form components
        add(new JLabel("Name:"));
        nameField = new JTextField();
        add(nameField);

        add(new JLabel("Consulted Doctor:"));
        doctorField = new JTextField();
        add(doctorField);

        add(new JLabel("Disease Details:"));
        diseaseField = new JTextField();
        add(diseaseField);

        add(new JLabel("Phone No:"));
        phoneField = new JTextField();
        add(phoneField);

        add(new JLabel("Blood Group:"));
        bloodGroupField = new JTextField();
        add(bloodGroupField);

        JButton addButton = new JButton("Add Patient");
        add(addButton);
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
        String url = "jdbc:mysql://localhost:3306/Save"; // Placeholder database URL
        String user = "root"; // Placeholder username
        String password = "password"; // Placeholder password

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
