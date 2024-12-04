package hospital;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;

public class BloodDetailsForm extends JFrame {

    private JTable table;
    private DefaultTableModel model;

    public BloodDetailsForm() {
        setTitle("Blood Details");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Table Setup
        model = new DefaultTableModel();
        model.addColumn("Blood Group");
        model.addColumn("Total Quantity (bags)");

        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        loadBloodDetails();
        setVisible(true);
    }

    private void loadBloodDetails() {
        String url = "jdbc:mysql://localhost:3306/hospital";
        String user = "root";
        String password = "admin";

        String query = "SELECT blood_group, SUM(quantity) AS total_quantity FROM bloodbank GROUP BY blood_group";

        try (Connection con = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = con.prepareStatement(query);
             ResultSet rs = pstmt.executeQuery()) {

            model.setRowCount(0);

            while (rs.next()) {
                String bloodGroup = rs.getString("blood_group");
                int totalQuantity = rs.getInt("total_quantity");

                model.addRow(new Object[]{bloodGroup, totalQuantity});
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error fetching blood details", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    private static final long serialVersionUID = 1L;
}
