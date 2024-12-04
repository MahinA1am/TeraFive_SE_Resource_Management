package hospital;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.time.LocalDate;
import java.util.Random;

public class AppointmentForm extends JFrame {

    private JTextField patientNameField, doctorNameField, phoneField, appointmentNoField;
    private JTextField appointmentDateField;

    public AppointmentForm() {
        // Set title and window properties
        setTitle("Appointment Form");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        // Title Label
        JLabel titleLabel = new JLabel("Book an Appointment", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        add(titleLabel, BorderLayout.NORTH);

        // Form Panel
        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Row 1: Patient Name
        gbc.gridx = 0;
        gbc.gridy = 0;
        formPanel.add(new JLabel("Patient Name:"), gbc);
        gbc.gridx = 1;
        patientNameField = new JTextField(20);
        formPanel.add(patientNameField, gbc);

        // Row 2: Doctor Name
        gbc.gridx = 0;
        gbc.gridy = 1;
        formPanel.add(new JLabel("Doctor Name:"), gbc);
        gbc.gridx = 1;
        doctorNameField = new JTextField(20);
        formPanel.add(doctorNameField, gbc);

        // Row 3: Appointment Date
        gbc.gridx = 0;
        gbc.gridy = 2;
        formPanel.add(new JLabel("Appointment Date (YYYY-MM-DD):"), gbc);
        gbc.gridx = 1;
        appointmentDateField = new JTextField(LocalDate.now().toString());
        formPanel.add(appointmentDateField, gbc);

        // Row 4: Phone Number
        gbc.gridx = 0;
        gbc.gridy = 3;
        formPanel.add(new JLabel("Patient Phone No:"), gbc);
        gbc.gridx = 1;
        phoneField = new JTextField(20);
        formPanel.add(phoneField, gbc);

        // Row 5: Appointment No
        gbc.gridx = 0;
        gbc.gridy = 4;
        formPanel.add(new JLabel("Appointment No:"), gbc);
        gbc.gridx = 1;
        appointmentNoField = new JTextField(generateRandomString());
        appointmentNoField.setEditable(false);
        formPanel.add(appointmentNoField, gbc);

        add(formPanel, BorderLayout.CENTER);

        // Buttons Panel
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        JButton saveButton = new JButton("Save");
        JButton clearButton = new JButton("Clear");
        JButton backButton = new JButton("Back to Homepage");

        buttonPanel.add(saveButton);
        buttonPanel.add(clearButton);
        buttonPanel.add(backButton);
        add(buttonPanel, BorderLayout.SOUTH);

        // Button Actions
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveAppointment();
            }
        });

        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearFields();
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new Homepage();
            }
        });

        setVisible(true);
    }

    // Method to save the appointment details to the database
    private void saveAppointment() {
        if (patientNameField.getText().isEmpty() || doctorNameField.getText().isEmpty() ||
                appointmentDateField.getText().isEmpty() || phoneField.getText().isEmpty() || appointmentNoField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "No field can be empty", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String url = "jdbc:mysql://localhost:3306/hospital"; // Placeholder database URL
        String user = "root"; // Placeholder username
        String password = "admin"; // Placeholder password

        String patientName = patientNameField.getText();
        String doctorName = doctorNameField.getText();
        String appointmentDate = appointmentDateField.getText();
        String phone = phoneField.getText();
        String appointmentNo = appointmentNoField.getText();

        String query = "INSERT INTO appointment (patient_name, doctor_name, appointment_date, phone, appointment_no) VALUES (?, ?, ?, ?, ?)";

        try (Connection con = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = con.prepareStatement(query)) {

            pstmt.setString(1, patientName);
            pstmt.setString(2, doctorName);
            pstmt.setString(3, appointmentDate);
            pstmt.setString(4, phone);
            pstmt.setString(5, appointmentNo);

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(this, "Appointment saved successfully");
                clearFields();
            } else {
                JOptionPane.showMessageDialog(this, "Failed to save appointment");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error connecting to database", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Method to clear all fields
    private void clearFields() {
        patientNameField.setText("");
        doctorNameField.setText("");
        appointmentDateField.setText(LocalDate.now().toString());
        phoneField.setText("");
        appointmentNoField.setText(generateRandomString());
    }

    // Method to generate a random 6-character alphanumeric string
    private String generateRandomString() {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuilder sb = new StringBuilder(6);
        for (int i = 0; i < 6; i++) {
            sb.append(characters.charAt(random.nextInt(characters.length())));
        }
        return sb.toString();
    }

    // Main method to run the AppointmentForm application
    public static void main(String[] args) {
        new AppointmentForm();
    }

    private static final long serialVersionUID = 1L;
}
