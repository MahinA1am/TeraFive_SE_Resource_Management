package hospital;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;

public class DoctorDetails extends JFrame {

    private JTable doctorTable;
    private DefaultTableModel tableModel;

    public DoctorDetails() {
        setTitle("Doctor Details");
        setSize(800, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Set up the table with column headers
        String[] columnNames = {"Name", "Education", "License No", "Experience", "Speciality", 
                                "Salary", "Joining Date", "Phone No", "Email"};
        tableModel = new DefaultTableModel(columnNames, 0);
        doctorTable = new JTable(tableModel);

        // Fetch doctor data and populate the table
        fetchDoctorData();

        // Add table to a scroll pane for better view
        JScrollPane scrollPane = new JScrollPane(doctorTable);
        add(scrollPane, BorderLayout.CENTER);

        setVisible(true);
    }

    // Method to fetch doctor data from the database and add it to the table model
    private void fetchDoctorData() {
        String url = "jdbc:mysql://localhost:3306/Save"; // Placeholder database URL
        String user = "root"; // Placeholder username
        String password = "password"; // Placeholder password
        String query = "SELECT name, education, license_no, experience, speciality, salary, joining_date, phone_no, email FROM doctor";

        try (Connection con = DriverManager.getConnection(url, user, password);
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                // Retrieve each doctor's data from the ResultSet
                String name = rs.getString("name");
                String education = rs.getString("education");
                String licenseNo = rs.getString("license_no");
                String experience = rs.getString("experience");
                String speciality = rs.getString("speciality");
                String salary = rs.getString("salary");
                String joiningDate = rs.getString("joining_date");
                String phoneNo = rs.getString("phone_no");
                String email = rs.getString("email");

                // Add each row to the table model
                tableModel.addRow(new Object[]{name, education, licenseNo, experience, speciality, salary, joiningDate, phoneNo, email});
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error fetching data from database", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Main method to run the DoctorDetails application
    public static void main(String[] args) {
        new DoctorDetails();
    }
    private static final long serialVersionUID = 1L;
}
