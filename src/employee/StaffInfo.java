package employee;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
//import java.awt.*;
import java.sql.*;

public class StaffInfo extends JFrame {

    public StaffInfo() {
        setTitle("Staff Info");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        String[] columnNames = {"Staff ID", "Name", "Position", "Salary", "Joining Date"};
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
        JTable table = new JTable(tableModel);

        // Fetch data from database
        String query = "SELECT * FROM Staff";
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital", "root", "admin");
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                int id = rs.getInt("StaffID");
                String name = rs.getString("Name");
                String position = rs.getString("Position");
                double salary = rs.getDouble("Salary");
                Date joiningDate = rs.getDate("JoiningDate");
                tableModel.addRow(new Object[]{id, name, position, salary, joiningDate});
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        add(new JScrollPane(table));
        setVisible(true);
    }
    private static final long serialVersionUID = 1L;
}
