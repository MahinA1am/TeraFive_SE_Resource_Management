package employee;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
//import java.awt.*;
import java.sql.*;

public class BoardInfo extends JFrame {

    public BoardInfo() {
        setTitle("Board Info");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        String[] columnNames = {"Board ID", "Name", "Role", "Salary"};
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
        JTable table = new JTable(tableModel);

        // Fetch data from database
        String query = "SELECT * FROM Board";
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital", "root", "admin");
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                int id = rs.getInt("BoardID");
                String name = rs.getString("Name");
                String role = rs.getString("Role");
                double salary = rs.getDouble("Salary");
                tableModel.addRow(new Object[]{id, name, role, salary});
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        add(new JScrollPane(table));
        setVisible(true);
    }
    private static final long serialVersionUID = 1L;
}
