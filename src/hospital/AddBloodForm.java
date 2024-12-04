package hospital;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class AddBloodForm extends JFrame {

    private JComboBox<String> bloodGroupComboBox;
    private JTextField quantityField, expiryDateField;

    public AddBloodForm() {
        setTitle("Add Blood");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Blood Group
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(new JLabel("Blood Group:"), gbc);

        gbc.gridx = 1;
        bloodGroupComboBox = new JComboBox<>(new String[]{"A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-"});
        add(bloodGroupComboBox, gbc);

        // Quantity
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(new JLabel("Quantity (bags):"), gbc);

        gbc.gridx = 1;
        quantityField = new JTextField(10);
        add(quantityField, gbc);

        // Expiry Date
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(new JLabel("Expiry Date (YYYY-MM-DD):"), gbc);

        gbc.gridx = 1;
        expiryDateField = new JTextField(10);
        add(expiryDateField, gbc);

        // Buttons
        JPanel buttonPanel = new JPanel();
        JButton saveButton = new JButton("Save");
        JButton clearButton = new JButton("Clear");
        buttonPanel.add(saveButton);
        buttonPanel.add(clearButton);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        add(buttonPanel, gbc);

        // Button Actions
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveBlood();
            }
        });

        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearFields();
            }
        });

        setVisible(true);
    }

    private void saveBlood() {
        String bloodGroup = (String) bloodGroupComboBox.getSelectedItem();
        String quantityStr = quantityField.getText();
        String expiryDate = expiryDateField.getText();

        if (bloodGroup.isEmpty() || quantityStr.isEmpty() || expiryDate.isEmpty()) {
            JOptionPane.showMessageDialog(this, "All fields are required", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            int quantity = Integer.parseInt(quantityStr);

            String url = "jdbc:mysql://localhost:3306/hospital";
            String user = "root";
            String password = "admin";

            String query = "INSERT INTO bloodbank (blood_group, quantity, expiry_date) VALUES (?, ?, ?)";
            try (Connection con = DriverManager.getConnection(url, user, password);
                 PreparedStatement pstmt = con.prepareStatement(query)) {

                pstmt.setString(1, bloodGroup);
                pstmt.setInt(2, quantity);
                pstmt.setString(3, expiryDate);

                int rowsAffected = pstmt.executeUpdate();
                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(this, "Blood record added successfully");
                    clearFields();
                } else {
                    JOptionPane.showMessageDialog(this, "Failed to add record", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Quantity must be a number", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Database error", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void clearFields() {
        bloodGroupComboBox.setSelectedIndex(0);
        quantityField.setText("");
        expiryDateField.setText("");
    }
    private static final long serialVersionUID = 1L;
}
