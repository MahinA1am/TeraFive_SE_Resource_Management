package pro;

import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Color;
import java.sql.*;

public class ManagePack extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTable packageTable;
    private JTable hotelTable;

    // Package input fields
    private JTextField txtPackageLocation;
    private JTextField txtPackagePrice;
    private JTextField txtPackageName;
    private JTextField txtPackageDescription;

    // Hotel input fields
    private JTextField txtHotelLocation;
    private JTextField txtHotelName;
    private JTextField txtHotelPrice;
    private JTextField txtHotelRating;

    // Database connection instance
    private Connection connection;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ManagePack frame = new ManagePack("");
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public ManagePack(String userEmail) {
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setBounds(100, 100, 1000, 713);
        contentPane = new JPanel();
        setResizable(false); 
		 setLocationRelativeTo(null);
        contentPane.setBackground(new Color(3, 152, 158));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Establishing connection
        connection = DatabaseConnection.getConnection();

        // Package Table and Controls
        JLabel lblPackageTable = new JLabel("Packages");
        lblPackageTable.setHorizontalAlignment(SwingConstants.CENTER);
        lblPackageTable.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblPackageTable.setBounds(117, 56, 200, 30);
        contentPane.add(lblPackageTable);

        packageTable = new JTable(new DefaultTableModel(new Object[][] {}, new String[] {
                "P_ID", "Location", "P_Price", "P_Name", "Description"
        }));
        packageTable.setBackground(new Color(255, 255, 255));
        JScrollPane packageScrollPane = new JScrollPane(packageTable);
        packageScrollPane.setBounds(47, 96, 400, 300);
        contentPane.add(packageScrollPane);

        // Package Input Fields (without P_ID)
        JLabel lblPackageLocation = new JLabel("Location:");
        lblPackageLocation.setBounds(47, 416, 100, 25);
        contentPane.add(lblPackageLocation);

        txtPackageLocation = new JTextField();
        txtPackageLocation.setBounds(157, 416, 240, 25);
        contentPane.add(txtPackageLocation);

        JLabel lblPackagePrice = new JLabel("P_Price:");
        lblPackagePrice.setBounds(47, 456, 100, 25);
        contentPane.add(lblPackagePrice);

        txtPackagePrice = new JTextField();
        txtPackagePrice.setBounds(157, 456, 240, 25);
        contentPane.add(txtPackagePrice);

        JLabel lblPackageName = new JLabel("P_Name:");
        lblPackageName.setBounds(47, 496, 100, 25);
        contentPane.add(lblPackageName);

        txtPackageName = new JTextField();
        txtPackageName.setBounds(157, 496, 240, 25);
        contentPane.add(txtPackageName);

        JLabel lblPackageDescription = new JLabel("Description:");
        lblPackageDescription.setBounds(47, 536, 100, 25);
        contentPane.add(lblPackageDescription);

        txtPackageDescription = new JTextField();
        txtPackageDescription.setBounds(157, 536, 240, 25);
        contentPane.add(txtPackageDescription);

        JButton btnAddPackage = new JButton("Add Package");
        btnAddPackage.setBounds(167, 576, 150, 30);
        btnAddPackage.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addPackage();
            }
        });
        contentPane.add(btnAddPackage);

        // Hotel Table and Controls
        JLabel lblHotelTable = new JLabel("Hotels");
        lblHotelTable.setHorizontalAlignment(SwingConstants.CENTER);
        lblHotelTable.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblHotelTable.setBounds(593, 56, 200, 30);
        contentPane.add(lblHotelTable);

        hotelTable = new JTable(new DefaultTableModel(new Object[][] {}, new String[] {
                "H_ID", "Location", "H_Name", "H_Price", "Rating"
        }));
        JScrollPane hotelScrollPane = new JScrollPane(hotelTable);
        hotelScrollPane.setBounds(497, 96, 400, 300);
        contentPane.add(hotelScrollPane);

        // Hotel Input Fields (without H_ID)
        JLabel lblHotelLocation = new JLabel("Location:");
        lblHotelLocation.setBounds(497, 416, 100, 25);
        contentPane.add(lblHotelLocation);

        txtHotelLocation = new JTextField();
        txtHotelLocation.setBounds(607, 416, 240, 25);
        contentPane.add(txtHotelLocation);

        JLabel lblHotelName = new JLabel("H_Name:");
        lblHotelName.setBounds(497, 456, 100, 25);
        contentPane.add(lblHotelName);

        txtHotelName = new JTextField();
        txtHotelName.setBounds(607, 456, 240, 25);
        contentPane.add(txtHotelName);

        JLabel lblHotelPrice = new JLabel("H_Price:");
        lblHotelPrice.setBounds(497, 496, 100, 25);
        contentPane.add(lblHotelPrice);

        txtHotelPrice = new JTextField();
        txtHotelPrice.setBounds(607, 496, 240, 25);
        contentPane.add(txtHotelPrice);

        JLabel lblHotelRating = new JLabel("Rating:");
        lblHotelRating.setBounds(497, 536, 100, 25);
        contentPane.add(lblHotelRating);

        txtHotelRating = new JTextField();
        txtHotelRating.setBounds(607, 536, 240, 25);
        contentPane.add(txtHotelRating);

        JButton btnAddHotel = new JButton("Add Hotel");
        btnAddHotel.setBounds(617, 576, 150, 30);
        btnAddHotel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addHotel();
            }
        });
        contentPane.add(btnAddHotel);

        JButton btnClose = new JButton("Close");
        btnClose.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		new HomePage(userEmail).setVisible(true);
                
        		dispose();
        	}
        });
        btnClose.setFont(new Font("Tahoma", Font.BOLD, 16));
        btnClose.setBounds(862, 629, 100, 30);
        contentPane.add(btnClose);

        JLabel lblManagePackageAnd = new JLabel("Manage Package and Hotel");
        lblManagePackageAnd.setHorizontalAlignment(SwingConstants.CENTER);
        lblManagePackageAnd.setForeground(Color.BLACK);
        lblManagePackageAnd.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblManagePackageAnd.setBounds(346, 11, 262, 24);
        contentPane.add(lblManagePackageAnd);

        // Initial data fetch
        refreshPackageTable();
        refreshHotelTable();
        
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
            	new HomePage(userEmail).setVisible(true);
        		dispose();
               
            }
        });
    }

    // Method to add package
    private void addPackage() {
        String location = txtPackageLocation.getText();
        String price = txtPackagePrice.getText();
        String name = txtPackageName.getText();
        String description = txtPackageDescription.getText();

        if (location.isEmpty() || price.isEmpty() || name.isEmpty() || description.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all fields.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            try {
                String query = "INSERT INTO Packages (Location, P_Price, P_Name, Description) VALUES (?, ?, ?, ?)";
                PreparedStatement stmt = connection.prepareStatement(query);
                stmt.setString(1, location);
                stmt.setString(2, price);
                stmt.setString(3, name);
                stmt.setString(4, description);
                stmt.executeUpdate();

                JOptionPane.showMessageDialog(this, "Package added successfully.");
                clearPackageFields();
                refreshPackageTable();
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error adding package.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    // Method to add hotel
    private void addHotel() {
        String location = txtHotelLocation.getText();
        String name = txtHotelName.getText();
        String price = txtHotelPrice.getText();
        String rating = txtHotelRating.getText();

        if (location.isEmpty() || name.isEmpty() || price.isEmpty() || rating.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all fields.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            try {
                String query = "INSERT INTO Hotels (Location, H_Name, H_Price, Rating) VALUES (?, ?, ?, ?)";
                PreparedStatement stmt = connection.prepareStatement(query);
                stmt.setString(1, location);
                stmt.setString(2, name);
                stmt.setString(3, price);
                stmt.setString(4, rating);
                stmt.executeUpdate();

                JOptionPane.showMessageDialog(this, "Hotel added successfully.");
                clearHotelFields();
                refreshHotelTable();
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error adding hotel.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    // Refresh the package table to reflect changes
    private void refreshPackageTable() {
        try {
            String query = "SELECT * FROM Packages";
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            DefaultTableModel model = (DefaultTableModel) packageTable.getModel();
            model.setRowCount(0); // Clear the table

            while (rs.next()) {
                Object[] row = {
                    rs.getInt("P_ID"),
                    rs.getString("Location"),
                    rs.getString("P_Price"),
                    rs.getString("P_Name"),
                    rs.getString("Description")
                };
                model.addRow(row);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Refresh the hotel table to reflect changes
    private void refreshHotelTable() {
        try {
            String query = "SELECT * FROM Hotels";
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            DefaultTableModel model = (DefaultTableModel) hotelTable.getModel();
            model.setRowCount(0); // Clear the table

            while (rs.next()) {
                Object[] row = {
                    rs.getInt("H_ID"),
                    rs.getString("Location"),
                    rs.getString("H_Name"),
                    rs.getString("H_Price"),
                    rs.getString("Rating")
                };
                model.addRow(row);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Clear package input fields after adding a row
    private void clearPackageFields() {
        txtPackageLocation.setText("");
        txtPackagePrice.setText("");
        txtPackageName.setText("");
        txtPackageDescription.setText("");
    }

    // Clear hotel input fields after adding a row
    private void clearHotelFields() {
        txtHotelLocation.setText("");
        txtHotelName.setText("");
        txtHotelPrice.setText("");
        txtHotelRating.setText("");
    }
}
