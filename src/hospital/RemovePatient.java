package hospital;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class RemovePatient extends JFrame {

    private JTextField nameField, phoneField;

    public RemovePatient() {
        setTitle("Remove Patient");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(3, 2, 10, 10));

        // Create and add form components
        add(new JLabel("Name:"));
        nameField = new JTextField();
        add(nameField);

        add(new JLabel("Phone No:"));
        phoneField = new JTextField();
        add(phoneField);

        JButton removeButton = new JButton("Remove Patient");
        add(removeButton);
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removePatientFromDatabase();
            }
        });

        setVisible(true);
    }

    // Method to remove patient information from the database
    private void removePatientFromDatabase() {
        String url = "jdbc:mysql://localhost:3306/Save"; // Placeholder database URL
        String user = "root"; // Placeholder username
        String password = "password"; // Placeholder password

        String name = nameField.getText();
        String phone = phoneField.getText();

        String query = "DELETE FROM patient WHERE name = ? AND phone_no = ?";

        try (Connection con = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = con.prepareStatement(query)) {

            pstmt.setString(1, name);
            pstmt.setString(2, phone);

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(this, "Patient removed successfully");
            } else {
                JOptionPane.showMessageDialog(this, "No matching patient found");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error connecting to database", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        new RemovePatient();
    }
    private static final long serialVersionUID = 1L;
}

