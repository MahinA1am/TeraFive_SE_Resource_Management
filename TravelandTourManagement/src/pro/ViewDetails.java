package pro;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.itextpdf.text.Document;
import com.itextpdf.text.Font;  // Use the correct iText Font class
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class ViewDetails extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTable bookDetailsTable;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ViewDetails frame = new ViewDetails("");
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public ViewDetails(String userEmail) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1000, 600);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(3, 152, 158));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Book Details Table
        JLabel lblBookDetails = new JLabel("Book Details");
        lblBookDetails.setHorizontalAlignment(SwingConstants.CENTER);
        lblBookDetails.setFont(new java.awt.Font("Tahoma", java.awt.Font.BOLD, 16)); // Use AWT Font for UI
        lblBookDetails.setBounds(400, 20, 150, 25);
        contentPane.add(lblBookDetails);

        bookDetailsTable = new JTable(new DefaultTableModel(new Object[][] {}, new String[] {
                "User_name", "P_ID", "H_ID", "Total_Price", "Mobile Number", "Email", "Country", "Address", 
                "Total Person", "Location", "Arrival Date", "Leaving Date"
        }));

        JScrollPane scrollPane = new JScrollPane(bookDetailsTable);
        scrollPane.setBounds(50, 60, 900, 300);
        contentPane.add(scrollPane);

        JButton btnView = new JButton("View");
        btnView.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		exportSelectedRowToPDF();
        	}
        });
        btnView.setFont(new java.awt.Font("Tahoma", java.awt.Font.BOLD, 14)); // Use AWT Font for UI
        btnView.setBounds(440, 400, 120, 30);
        contentPane.add(btnView);

        JButton btnClose = new JButton("Close");
        btnClose.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		new HomePage(userEmail).setVisible(true);
        		dispose();
        	}
        });
        btnClose.setFont(new java.awt.Font("Tahoma", java.awt.Font.BOLD, 16)); // Use AWT Font for UI
        btnClose.setBounds(874, 520, 100, 30);
        contentPane.add(btnClose);

        loadBookDetails();
    }

    private void loadBookDetails() {
        DefaultTableModel model = (DefaultTableModel) bookDetailsTable.getModel();
        model.setRowCount(0); // Clear any existing rows

        String query = "SELECT * FROM book_details";

        try (Connection connection = DatabaseConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                // Add rows to the table model
                model.addRow(new Object[]{
                        resultSet.getString("User_name"),
                        resultSet.getInt("P_ID"),
                        resultSet.getInt("H_ID"),
                        resultSet.getDouble("Total_Price"),
                        resultSet.getString("Mobile_Number"),
                        resultSet.getString("Email"),
                        resultSet.getString("Country"),
                        resultSet.getString("Address"),
                        resultSet.getInt("Total_Person"),
                        resultSet.getString("Location"),
                        resultSet.getDate("Arrival_Date"),
                        resultSet.getDate("Leaving_Date")
                });
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error loading data: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    private void exportSelectedRowToPDF() {
        int selectedRow = bookDetailsTable.getSelectedRow();

        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a row to export!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Retrieve row data
        int columnCount = bookDetailsTable.getColumnCount();
        String[] rowData = new String[columnCount];
        for (int i = 0; i < columnCount; i++) {
            rowData[i] = bookDetailsTable.getValueAt(selectedRow, i).toString();
        }

        // Define the output file path in the user's documents folder
        String filePath = System.getProperty("user.dir") + "/src/BookingDetails.pdf";

        try {
            // Create PDF document
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(filePath));
            document.open();

            // Add title using iText Font
            Font titleFont = new Font(Font.FontFamily.HELVETICA, 16, Font.BOLD);
            document.add(new Paragraph("Booking Details", titleFont));
            document.add(new Paragraph(" ")); // Empty line for spacing

            // Add data in top-down format
            String[] columnNames = {
                    "User Name", "Package ID", "Hotel ID", "Total Price", "Mobile Number", "Email", "Country", "Address",
                    "Total Person", "Location", "Arrival Date", "Leaving Date"
            };

            Font labelFont = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD); // For labels
            Font valueFont = new Font(Font.FontFamily.HELVETICA, 12); // For values

            for (int i = 0; i < columnCount; i++) {
                Paragraph line = new Paragraph(columnNames[i] + ": " + rowData[i], labelFont);
                line.setFont(valueFont); // Set the font for the value
                document.add(line);
            }

            document.close();

            JOptionPane.showMessageDialog(this, "Row exported successfully to PDF!\nSaved at: " + filePath, "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error exporting to PDF: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
