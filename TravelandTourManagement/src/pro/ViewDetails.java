package pro;

import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ViewDetails extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTable bookDetailsTable;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ViewDetails frame = new ViewDetails();
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
    public ViewDetails() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1000, 600);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Book Details Table
        JLabel lblBookDetails = new JLabel("Book Details");
        lblBookDetails.setHorizontalAlignment(SwingConstants.CENTER);
        lblBookDetails.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblBookDetails.setBounds(400, 20, 150, 25);
        contentPane.add(lblBookDetails);

        bookDetailsTable = new JTable(new DefaultTableModel(new Object[][] {}, new String[] {
                "User_name", "P_ID", "H_ID", "Total_Price", "Mobile Number", "Email", 
                "Total Person", "Location", "Arrival Date", "Leaving Date"
        }));
   

        JScrollPane scrollPane = new JScrollPane(bookDetailsTable);
        scrollPane.setBounds(50, 60, 900, 300);
        contentPane.add(scrollPane);
        
		/*
		 * DefaultTableModel model = (DefaultTableModel) bookDetailsTable.getModel();
		 * model.addRow(new Object[] { "John Doe", "1", "101", "1500", "1234567890",
		 * "johndoe@example.com", "2", "Paris", "2023-11-15", "2023-11-20" });
		 */

        // View Button to show selected row details
        JButton btnView = new JButton("View");
        btnView.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnView.setBounds(440, 400, 120, 30);
        contentPane.add(btnView);
        
        JButton btnClose = new JButton("Close");
        btnClose.setFont(new Font("Tahoma", Font.BOLD, 16));
        btnClose.setBounds(874, 520, 100, 30);
        contentPane.add(btnClose);

        // Action listener for the "View" button
        btnView.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedRow = bookDetailsTable.getSelectedRow();
                if (selectedRow == -1) {
                    JOptionPane.showMessageDialog(null, "Please select a row to view details.");
                    return;
                }

                // Get selected row data
                DefaultTableModel model = (DefaultTableModel) bookDetailsTable.getModel();
                String userName = model.getValueAt(selectedRow, 0).toString();
                String pID = model.getValueAt(selectedRow, 1).toString();
                String hID = model.getValueAt(selectedRow, 2).toString();
                String totalPrice = model.getValueAt(selectedRow, 3).toString();
                String mobileNumber = model.getValueAt(selectedRow, 4).toString();
                String email = model.getValueAt(selectedRow, 5).toString();
                String totalPerson = model.getValueAt(selectedRow, 6).toString();
                String location = model.getValueAt(selectedRow, 7).toString();
                String arrivalDate = model.getValueAt(selectedRow, 8).toString();
                String leavingDate = model.getValueAt(selectedRow, 9).toString();

                // Write details to a text file
                try (BufferedWriter writer = new BufferedWriter(new FileWriter("SelectedRowDetails.txt"))) {
                    writer.write("User Name: " + userName + "\n");
                    writer.write("P_ID: " + pID + "\n");
                    writer.write("H_ID: " + hID + "\n");
                    writer.write("Total Price: " + totalPrice + "\n");
                    writer.write("Mobile Number: " + mobileNumber + "\n");
                    writer.write("Email: " + email + "\n");
                    writer.write("Total Person: " + totalPerson + "\n");
                    writer.write("Location: " + location + "\n");
                    writer.write("Arrival Date: " + arrivalDate + "\n");
                    writer.write("Leaving Date: " + leavingDate + "\n");
                    JOptionPane.showMessageDialog(null, "Details saved to SelectedRowDetails.txt.");
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "Error saving details to file.");
                    ex.printStackTrace();
                }
            }
        });
    }
}
