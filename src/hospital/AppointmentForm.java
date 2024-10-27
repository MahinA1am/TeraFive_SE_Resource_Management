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
        setTitle("Appointment Form");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(6, 2, 10, 10));

        // Create form components
        add(new JLabel("Patient Name:"));
        patientNameField = new JTextField();
        add(patientNameField);

        add(new JLabel("Doctor Name:"));
        doctorNameField = new JTextField();
        add(doctorNameField);

        add(new JLabel("Appointment Date (YYYY-MM-DD):"));
        appointmentDateField = new JTextField(LocalDate.now().toString()); // Defaults to today’s date
        add(appointmentDateField);

        add(new JLabel("Patient Phone No:"));
        phoneField = new JTextField();
        add(phoneField);

        add(new JLabel("Appointment No:"));
        appointmentNoField = new JTextField(generateRandomString());
        appointmentNoField.setEditable(false); // Read-only field
        add(appointmentNoField);

        JButton saveButton = new JButton("Save");
        add(saveButton);
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveAppointment();
            }
        });

        JButton clearButton = new JButton("Clear");
        add(clearButton);
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearFields();
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

        String url = "jdbc:mysql://localhost:3306/Save"; // Placeholder database URL
        String user = "root"; // Placeholder username
        String password = "password"; // Placeholder password

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
