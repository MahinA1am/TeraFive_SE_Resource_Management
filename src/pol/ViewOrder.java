package pol;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


import com.itextpdf.text.Font;

import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

import com.itextpdf.text.Document;

import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.*;
import javax.swing.*;


public class ViewOrder extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTable table_1;
	private JScrollPane scrollPane_1;
	private JButton btnNewButton;
	private JLabel lblOrderList;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewOrder frame = new ViewOrder("","");
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
	public ViewOrder(String userEmail,String userRole) {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 900, 646);
		contentPane = new JPanel();
		setLocationRelativeTo(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("View Order");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new java.awt.Font("Tahoma", java.awt.Font.BOLD, 18));
		lblNewLabel_1.setBounds(370, 11, 181, 29);
		contentPane.add(lblNewLabel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 81, 387, 469);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Name", "Email", "Mobile Number"
			}
		));
		table.setFont(new java.awt.Font("Tahoma", java.awt.Font.BOLD, 12));
		scrollPane.setViewportView(table);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(492, 81, 382, 469);
		contentPane.add(scrollPane_1);
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
					"Order ID", "Date", "Total Paid"
			}
		));
		scrollPane_1.setViewportView(table_1);
		
		btnNewButton = new JButton("Close");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				   HomePage homeFrame = new HomePage(userEmail,userRole);
	                homeFrame.setVisible(true);
	                dispose();
			}
		});
		btnNewButton.setFont(new java.awt.Font("Tahoma", java.awt.Font.BOLD, 12));
		btnNewButton.setBounds(767, 573, 89, 23);
		contentPane.add(btnNewButton);
		
		lblOrderList = new JLabel("Order List");
		lblOrderList.setHorizontalAlignment(SwingConstants.CENTER);
		lblOrderList.setFont(new java.awt.Font("Tahoma", java.awt.Font.BOLD, 13));
		lblOrderList.setBounds(635, 48, 95, 14);
		contentPane.add(lblOrderList);
		
		lblNewLabel = new JLabel("Customer List");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new java.awt.Font("Tahoma", java.awt.Font.BOLD, 13));
		lblNewLabel.setBounds(154, 49, 95, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(ViewOrder.class.getResource("/Images/4813762.jpg")));
		lblNewLabel_2.setBounds(0, -11, 3000, 2022);
		contentPane.add(lblNewLabel_2);
		loadCustomerData();
		
		table.getSelectionModel().addListSelectionListener(e -> {
            int selectedRow =table.getSelectedRow();
            if (selectedRow >= 0) {
              
                int customerId = (int) table.getValueAt(selectedRow, 0);
                
                loadOrderDetailsForCustomer(customerId);
            }
        });
		
		  table_1.getSelectionModel().addListSelectionListener(e -> {
			  exportSelectedRowToPDF();
	        });
		  
		  this.addWindowListener(new WindowAdapter() {
	            @Override
	            public void windowClosing(WindowEvent e) {
	            	  HomePage homeFrame = new HomePage(userEmail,userRole);
		                homeFrame.setVisible(true);
		                dispose();
	               
	            }
	        });
		
		
	}
	private void loadCustomerData() {
	    try (Connection con = DatabaseConnection.getConnection()) {
	        DefaultTableModel model = (DefaultTableModel) table.getModel();
	        model.setRowCount(0);

	        String query = "SELECT * FROM customer";
	        try (var ps = con.prepareStatement(query);
	             var rs = ps.executeQuery()) {
	            while (rs.next()) {
	                model.addRow(new Object[]{
	                    rs.getInt("id"),
	                    rs.getString("name"),
	                    rs.getString("email"),
	                    rs.getString("mobile_number")
	                });
	            }
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	        JOptionPane.showMessageDialog(this, "Error loading customer data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
	    }
	}
	private void loadOrderDetailsForCustomer(int customerId) {
	    // Get the DefaultTableModel from table_1 (your order table)
	    DefaultTableModel model = (DefaultTableModel) table_1.getModel();
	    
	    // Clear the previous data in the order table
	    model.setRowCount(0);

	    // SQL query to fetch order details for the selected customer
	    String sql = "SELECT bill_id, order_date, SUM(total_price) AS total_price "
	               + "FROM order_details WHERE customer_id = ? GROUP BY bill_id, order_date";

	    try (Connection conn = DatabaseConnection.getConnection();
	         PreparedStatement stmt = conn.prepareStatement(sql)) {

	        // Set the customer_id parameter
	        stmt.setInt(1, customerId);

	        // Execute the query and get the result set
	        try (ResultSet rs = stmt.executeQuery()) {

	            // Loop through the result set and add data to the order table model
	            while (rs.next()) {
	                String billId = rs.getString("bill_id");
	                String orderDate = rs.getString("order_date");
	                double totalPrice = rs.getDouble("total_price");

	                // Add a new row to the order table with the retrieved data
	                model.addRow(new Object[] { billId, orderDate, totalPrice });
	            }
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	        JOptionPane.showMessageDialog(this, "Error loading order details: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
	    }
	}
	
	private void exportSelectedRowToPDF() {
	    int selectedRow = table_1.getSelectedRow();

	    if (selectedRow == -1) {
	        JOptionPane.showMessageDialog(this, "Please select a row to export!", "Error", JOptionPane.ERROR_MESSAGE);
	        return;
	    }

	    // Retrieve data from the selected row
	    String billId = (String) table_1.getValueAt(selectedRow, 0); // Bill ID
	    String orderDate = (String) table_1.getValueAt(selectedRow, 1);   // Order Date
	    double totalPrice = (double) table_1.getValueAt(selectedRow, 2); // Total Price

	    // Define the output file path for the PDF
	    String filePath = System.getProperty("user.dir") + "/src/" + billId + ".pdf";

	    try {
	        // Create the PDF document
	        Document document = new Document();
	        PdfWriter.getInstance(document, new FileOutputStream(filePath));
	        document.open();

	        // Add title using iText Font
	        Font titleFont = new Font(Font.FontFamily.HELVETICA, 16, Font.BOLD);
	        document.add(new Paragraph("Order Details", titleFont));
	        document.add(new Paragraph(" ")); // Empty line for spacing

	        // Add the order details to the PDF
	        Font labelFont = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD); // For labels
	        Font valueFont = new Font(Font.FontFamily.HELVETICA, 12); // For values

	        document.add(new Paragraph("Bill ID: " + billId, labelFont));
	        document.add(new Paragraph("Order Date: " + orderDate.toString(), labelFont));
	        document.add(new Paragraph("Total Price: " + totalPrice, labelFont));

	        // Optionally: Add a list of products with the same bill_id and order_date
	        document.add(new Paragraph(" "));
	        document.add(new Paragraph("Products in this order:", labelFont));

	        // Fetch the product details for the selected bill_id and order_date
	        try (Connection conn = DatabaseConnection.getConnection()) {
	            String productQuery = "SELECT product_id,quantity FROM order_details WHERE bill_id = ? AND order_date = ?";
	            try (PreparedStatement ps = conn.prepareStatement(productQuery)) {
	                ps.setString(1, billId);
	                ps.setString(2, orderDate);

	                ResultSet rs = ps.executeQuery();
	                while (rs.next()) {
	                    document.add(new Paragraph("Product ID: " + rs.getString("product_id") + "  --------> Quantity: "+rs.getInt("quantity"), valueFont));
	                }
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	            JOptionPane.showMessageDialog(this, "Error fetching product data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
	        }

	        document.close();
	        JOptionPane.showMessageDialog(this, "Row exported successfully to PDF!\nSaved at: " + filePath, "Success", JOptionPane.INFORMATION_MESSAGE);

	        // Show the PDF in a popup
	        showPDFInPopup(filePath);

	    } catch (Exception ex) {
	        ex.printStackTrace();
	        JOptionPane.showMessageDialog(this, "Error exporting to PDF: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
	    }
	}
	
	private void showPDFInPopup(String filePath) {
	    JDialog pdfDialog = new JDialog(this, "PDF Preview", true); // Modal dialog
	    pdfDialog.setSize(800, 600);
	    pdfDialog.setLocationRelativeTo(null);

	    try {
	        // Load PDF with PDFBox
	        PDDocument pdfDocument = PDDocument.load(new File(filePath));
	        PDFRenderer renderer = new PDFRenderer(pdfDocument);

	        // Render the first page of the PDF as an image
	        BufferedImage pageImage = renderer.renderImageWithDPI(0, 150); // First page, 150 DPI

	        // Display the image in a JLabel
	        JLabel pdfLabel = new JLabel(new ImageIcon(pageImage));
	        JScrollPane scrollPane = new JScrollPane(pdfLabel); // Add scroll if PDF is large
	        pdfDialog.add(scrollPane);

	        pdfDialog.setVisible(true); // Show the dialog
	        pdfDocument.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	        JOptionPane.showMessageDialog(this, "Failed to load PDF for preview: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
	    }
	}




}
