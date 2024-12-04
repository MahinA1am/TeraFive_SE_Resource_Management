package hospital;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class AppointmentList extends JFrame {

    private JTable table;
    private DefaultTableModel model;

    public AppointmentList() {
        setTitle("Appointment List - Sorted by Date");
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        // Title label
        JLabel titleLabel = new JLabel("Appointment List (Sorted by Date)", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        add(titleLabel, BorderLayout.NORTH);

        // Setup table model and add columns
        model = new DefaultTableModel();
        model.addColumn("Patient Name");
        model.addColumn("Doctor Name");
        model.addColumn("Appointment Date");
        model.addColumn("Phone No");
        model.addColumn("Appointment No");

        // Create table and set model
        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        // Bottom panel with buttons
        JPanel buttonPanel = new JPanel();
        JButton homeButton = new JButton("Back to Homepage");
        buttonPanel.add(homeButton);
        add(buttonPanel, BorderLayout.SOUTH);

        // Load appointment data sorted by date
        loadAppointmentData();

        // Button action to go back to Homepage
        homeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close this window
                new Homepage(); // Open homepage
            }
        });

        setVisible(true);
    }

    // Method to load and display appointment data sorted by date
    private void loadAppointmentData() {
        String url = "jdbc:mysql://localhost:3306/hospital"; // Placeholder database URL
        String user = "root"; // Placeholder username
        String password = "admin"; // Placeholder password

        String query = "SELECT patient_name, doctor_name, appointment_date, phone, appointment_no FROM appointment ORDER BY appointment_date";

        try (Connection con = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = con.prepareStatement(query);
             ResultSet rs = pstmt.executeQuery()) {

            // Clear any existing rows
            model.setRowCount(0);

            // Fetch data from result set and add it to the table
            while (rs.next()) {
                String patientName = rs.getString("patient_name");
                String doctorName = rs.getString("doctor_name");
                String appointmentDate = rs.getString("appointment_date");
                String phone = rs.getString("phone");
                String appointmentNo = rs.getString("appointment_no");

                model.addRow(new Object[]{patientName, doctorName, appointmentDate, phone, appointmentNo});
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error loading data from database", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        new AppointmentList();
    }

    private static final long serialVersionUID = 1L;
}
