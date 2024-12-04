package employee;

import javax.swing.*;
import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
import java.sql.*;

public class Homepage extends JFrame {

    @SuppressWarnings("unused")
	private boolean isAdmin;
    private String username;

    // Constructor
    public Homepage(boolean isAdmin, String username) {
        this.isAdmin = isAdmin;
        this.username = username;

        // Set up the JFrame
        setTitle("Homepage");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Set up the main panel
        JPanel panel = new JPanel(new BorderLayout());
        
        if (isAdmin) {
            setupAdminView(panel);
        } else {
            setupEmployeeView(panel);
        }

        add(panel);
        setVisible(true);
    }

    // Method to set up the employee view
    private void setupEmployeeView(JPanel panel) {
        // Fetch employee data from database
        String[] employeeData = fetchEmployeeData(username);

        // Display employee data
        if (employeeData != null) {
            JTextArea infoArea = new JTextArea();
            infoArea.setEditable(false);
            infoArea.setText("Employee Details:\n");
            infoArea.append("Name: " + employeeData[0] + "\n");
            infoArea.append("Username: " + employeeData[1] + "\n");
            infoArea.append("Age: " + employeeData[2] + "\n");
            infoArea.append("Department: " + employeeData[3] + "\n");
            panel.add(new JScrollPane(infoArea), BorderLayout.CENTER);
        } else {
            JOptionPane.showMessageDialog(this, "No data found for this employee.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Method to set up the admin view
    private void setupAdminView(JPanel panel) {
        // Create buttons for each department
        JButton hospitalButton = new JButton("Hospital");
        JButton tourButton = new JButton("Tour");
        JButton inventoryButton = new JButton("Inventory");

        // Panel for buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(hospitalButton);
        buttonPanel.add(tourButton);
        buttonPanel.add(inventoryButton);
        panel.add(buttonPanel, BorderLayout.NORTH);

        // Text area to display employee details
        JTextArea infoArea = new JTextArea();
        infoArea.setEditable(false);
        panel.add(new JScrollPane(infoArea), BorderLayout.CENTER);

        // Action listeners for department buttons
        hospitalButton.addActionListener(e -> displayEmployeeDetails("Hospital", infoArea));
        tourButton.addActionListener(e -> displayEmployeeDetails("Tour", infoArea));
        inventoryButton.addActionListener(e -> displayEmployeeDetails("Inventory", infoArea));
    }

    // Method to fetch employee data based on username
    private String[] fetchEmployeeData(String username) {
        String[] employeeData = new String[4]; // For name, username, age, department
        String url = "jdbc:mysql://localhost:3306/Save"; // Placeholder database URL
        String user = "root"; // Placeholder username
        String pass = "password"; // Placeholder password

        String query = "SELECT name, username, age, department FROM employee WHERE username = ?";

        try (Connection con = DriverManager.getConnection(url, user, pass);
             PreparedStatement stmt = con.prepareStatement(query)) {

            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                employeeData[0] = rs.getString("name");
                employeeData[1] = rs.getString("username");
                employeeData[2] = rs.getString("age");
                employeeData[3] = rs.getString("department");
                return employeeData;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    // Method to display employee details of a specific department
    private void displayEmployeeDetails(String department, JTextArea infoArea) {
        infoArea.setText("Employees in " + department + " Department:\n");
        String url = "jdbc:mysql://localhost:3306/Save"; // Placeholder database URL
        String user = "root"; // Placeholder username
        String pass = "1234"; // Placeholder password

        String query = "SELECT name, username, age FROM employee WHERE department = ?";

        try (Connection con = DriverManager.getConnection(url, user, pass);
             PreparedStatement stmt = con.prepareStatement(query)) {

            stmt.setString(1, department);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String name = rs.getString("name");
                String username = rs.getString("username");
                String age = rs.getString("age");
                infoArea.append("Name: " + name + ", Username: " + username + ", Age: " + age + "\n");
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error fetching data", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Main method to test the Homepage
    public static void main(String[] args) {
        // Example usage: admin login
        new Homepage(true, "adminUser");

        // Example usage: employee login
        // new Homepage(false, "employeeUser");
    }
    private static final long serialVersionUID = 1L;
}
