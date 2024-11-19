package pol;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class ManageOrder extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTable table_1;
	private JTable table_2;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JLabel lblNewLabel_7;
	private int pid;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManageOrder frame = new ManageOrder();
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
	public ManageOrder() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1195, 800);
		contentPane = new JPanel();
		 setLocationRelativeTo(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Manage Order");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(509, 11, 181, 29);
		contentPane.add(lblNewLabel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(29, 93, 334, 296);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
					"ID", "Name", "Email", "Mobile Number"
			}
		));
		scrollPane.setViewportView(table);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(416, 93, 334, 296);
		contentPane.add(scrollPane_1);
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
					"ID", "Name", "Quantity", "Price", "Description", "Category ID","Category Name"
			}
		));
		scrollPane_1.setViewportView(table_1);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(813, 93, 334, 296);
		contentPane.add(scrollPane_2);
		
		table_2 = new JTable();
		table_2.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Product ID", "Name", "Quantity", "Price", "Description", "Sub Total"
			}
		));
		scrollPane_2.setViewportView(table_2);
		
		JLabel lblNewLabel_2 = new JLabel("Customer List");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(125, 68, 119, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Product List");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(525, 68, 138, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Cart");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_4.setBounds(948, 68, 82, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Name");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_5.setBounds(29, 471, 46, 14);
		contentPane.add(lblNewLabel_5);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.BOLD, 12));
		textField.setColumns(10);
		textField.setBounds(29, 496, 328, 20);
		contentPane.add(textField);
		
		JLabel lblNewLabel_2_1 = new JLabel("Mobile Number");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2_1.setBounds(29, 531, 128, 14);
		contentPane.add(lblNewLabel_2_1);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		textField_1.setColumns(10);
		textField_1.setBounds(29, 566, 328, 20);
		contentPane.add(textField_1);
		
		JLabel lblNewLabel_3_1 = new JLabel("Email");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3_1.setBounds(29, 597, 46, 14);
		contentPane.add(lblNewLabel_3_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		textField_2.setColumns(10);
		textField_2.setBounds(29, 634, 328, 20);
		contentPane.add(textField_2);
		
		JLabel lblNewLabel_6 = new JLabel("Selected Customer :");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_6.setBounds(29, 436, 165, 14);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_6_1 = new JLabel("Selected Product :");
		lblNewLabel_6_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_6_1.setBounds(416, 437, 165, 14);
		contentPane.add(lblNewLabel_6_1);
		
		JLabel lblProductName = new JLabel("Product Name");
		lblProductName.setHorizontalAlignment(SwingConstants.LEFT);
		lblProductName.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblProductName.setBounds(416, 471, 102, 14);
		contentPane.add(lblProductName);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		textField_3.setColumns(10);
		textField_3.setBounds(416, 496, 328, 20);
		contentPane.add(textField_3);
		
		JLabel lblNewLabel_2_2 = new JLabel("Product Price");
		lblNewLabel_2_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2_2.setBounds(416, 531, 128, 14);
		contentPane.add(lblNewLabel_2_2);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		textField_4.setColumns(10);
		textField_4.setBounds(416, 566, 328, 20);
		contentPane.add(textField_4);
		
		JLabel lblNewLabel_3_2 = new JLabel("Product Description");
		lblNewLabel_3_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3_2.setBounds(416, 597, 190, 14);
		contentPane.add(lblNewLabel_3_2);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		textField_5.setColumns(10);
		textField_5.setBounds(416, 622, 328, 20);
		contentPane.add(textField_5);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Order Quantity");
		lblNewLabel_2_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2_1_1.setBounds(416, 658, 128, 14);
		contentPane.add(lblNewLabel_2_1_1);
		
		textField_6 = new JTextField();
		textField_6.setFont(new Font("Tahoma", Font.BOLD, 12));
		textField_6.setColumns(10);
		textField_6.setBounds(416, 683, 328, 20);
		contentPane.add(textField_6);
		
		JButton btnNewButton = new JButton("Add To Cart");
		btnNewButton.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        String productName = textField_3.getText();
		        String priceText = textField_4.getText();
		        String description = textField_5.getText();
		        String quantityText = textField_6.getText();

		        if (productName.isEmpty() || priceText.isEmpty() || description.isEmpty() || quantityText.isEmpty()) {
		            JOptionPane.showMessageDialog(null, "Please fill all the fields.", "Error", JOptionPane.INFORMATION_MESSAGE);
		            return;
		        }

		        int pid = -1;
		        int selectedRow = table_1.getSelectedRow();
		        if (selectedRow != -1) {
		            try {
		                
		            	 String pId = table_1.getValueAt(selectedRow, 0).toString();
		            	    pid = Integer.parseInt(pId);
		            } catch (Exception ex) {
		                JOptionPane.showMessageDialog(null, "Error retrieving product ID.", "Error", JOptionPane.ERROR_MESSAGE);
		                return;
		            }
		        }

		        try {
		            int quantity = Integer.parseInt(quantityText);
		            double price = Double.parseDouble(priceText);

		            int availableQuantity = getAvailableQuantityFromDB(productName);
		            if (availableQuantity < quantity) {
		                JOptionPane.showMessageDialog(null, "Insufficient stock! Available quantity: " + availableQuantity, 
		                                              "Error", JOptionPane.ERROR_MESSAGE);
		                return;
		            }

		            double subtotal = quantity * price;

		            DefaultTableModel model = (DefaultTableModel) table_2.getModel();
		            model.addRow(new Object[]{pid, productName, quantity, price, description, subtotal});

		            updateProductQuantityInDB(productName, availableQuantity - quantity);
		            updateTotalAmount();
		            resetTextField();
		        } catch (NumberFormatException ex) {
		            JOptionPane.showMessageDialog(null, "Please enter valid numbers for quantity and price.", "Error", JOptionPane.ERROR_MESSAGE);
		        } catch (Exception ex) {
		            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		            ex.printStackTrace();
		        }

		        loadProductData();
		    }
		});



		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBounds(416, 714, 328, 23);
		contentPane.add(btnNewButton);
		
		lblNewLabel_7 = new JLabel("Total Amount : 0000");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_7.setBounds(893, 422, 254, 29);
		contentPane.add(lblNewLabel_7);
		
		JButton btnNewButton_1 = new JButton("Save Order Details");
		btnNewButton_1.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        String customerName = textField.getText();
		        String customerEmail = textField_2.getText();

		        String billId = "BILL" + System.currentTimeMillis();

		        DefaultTableModel cartModel = (DefaultTableModel) table_2.getModel();
		        for (int i = 0; i < cartModel.getRowCount(); i++) {
		            // Ensure the first column contains product ID (not name)
		            int productId = Integer.parseInt(cartModel.getValueAt(i, 0).toString());
		            // If product name is needed, use a different column index
		            String productName = cartModel.getValueAt(i, 1).toString();  // Assuming the second column has the product name
		            int quantity = Integer.parseInt(cartModel.getValueAt(i, 2).toString());
		            double pricePerUnit = Double.parseDouble(cartModel.getValueAt(i, 3).toString());
		            String description = cartModel.getValueAt(i, 4).toString();
		            double totalPrice = quantity * pricePerUnit;

		            try (Connection con = DatabaseConnection.getConnection()) {
		                String query = "INSERT INTO order_details (bill_id, customer_id, product_id, quantity, price_per_unit, total_price) "
		                        + "VALUES (?, ?, ?, ?, ?, ?)";
		                try (var ps = con.prepareStatement(query)) {
		                    ps.setString(1, billId);
		                    ps.setInt(2, getCustomerIdByEmail(customerEmail));
		                    ps.setInt(3, productId);  // product_id
		                    ps.setInt(4, quantity);
		                    ps.setDouble(5, pricePerUnit);
		                    ps.setDouble(6, totalPrice);

		                    ps.executeUpdate();
		                }
		            } catch (SQLException ex) {
		                ex.printStackTrace();
		                JOptionPane.showMessageDialog(null, "Error saving order: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		            }
		        
		        }

		        JOptionPane.showMessageDialog(null, "Order details saved successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
		    }
		});
		
		


		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_1.setBounds(813, 496, 334, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Reset");
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_2.setBounds(813, 566, 334, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Close");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				   HomePage homeFrame = new HomePage("","");
	                homeFrame.setVisible(true);
	                dispose();
			}
		});
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_3.setBounds(813, 633, 334, 23);
		contentPane.add(btnNewButton_3);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(ManageOrder.class.getResource("/Images/4813762.jpg")));
		lblNewLabel.setBounds(0, 0, 3029, 2000);
		contentPane.add(lblNewLabel);
		
		table.getSelectionModel().addListSelectionListener(event -> {
		    int selectedRow = table.getSelectedRow();
		    if (selectedRow != -1) {
		        textField.setText(table.getValueAt(selectedRow, 1).toString());
		        textField_1.setText(table.getValueAt(selectedRow, 3).toString());
		        textField_2.setText(table.getValueAt(selectedRow, 2).toString());
		     
		    }
		});
		
		table_1.getSelectionModel().addListSelectionListener(event -> {
		    int selectedRow = table_1.getSelectedRow();
		    if (selectedRow != -1) {
		        textField_3.setText(table_1.getValueAt(selectedRow, 1).toString());
		        textField_4.setText(table_1.getValueAt(selectedRow, 3).toString());
		        textField_5.setText(table_1.getValueAt(selectedRow, 4).toString());
		        //textField_6.setText(table_1.getValueAt(selectedRow, 2).toString());
		     
		    }
		});
		
		
		
		
		loadCustomerData();
		loadProductData();		
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
	private void loadProductData() {
	    try (Connection con = DatabaseConnection.getConnection()) {
	        DefaultTableModel model = (DefaultTableModel) table_1.getModel();
	        model.setRowCount(0);

	        String query = "SELECT p.pid, p.pname, p.quantity, p.price, p.description, p.category_id, c.cname "
	                     + "FROM product p "
	                     + "INNER JOIN category c ON p.category_id = c.cid";
	        System.out.println("Executing query: " + query);

	        try (var ps = con.prepareStatement(query);
	             var rs = ps.executeQuery()) {
	            while (rs.next()) {
	                model.addRow(new Object[]{
	                    rs.getInt("pid"),
	                    rs.getString("pname"),  
	                    rs.getInt("quantity"),
	                    rs.getDouble("price"),
	                    rs.getString("description"),
	                    rs.getInt("category_id"),
	                    rs.getString("cname")
	                });
	            }
	        }

	        System.out.println("Product data loaded successfully.");
	    } catch (SQLException e) {
	        System.err.println("SQL error in loadProductData: " + e.getMessage());
	        e.printStackTrace();
	    }
	}
	private void updateTotalAmount() {
	    DefaultTableModel model = (DefaultTableModel) table_2.getModel();
	    double totalAmount = 0.0;

	    for (int i = 0; i < model.getRowCount(); i++) {
	        totalAmount += (double) model.getValueAt(i, 5); 
	    }

	    lblNewLabel_7.setText("Total Amount: " + String.format("%.2f", totalAmount));
	}
	/*
	 * public void updateTotalAmount() { double totalAmount = 0.0;
	 * 
	 * for (int i = 0; i < table_2.getRowCount(); i++) { Object priceObject =
	 * table_2.getValueAt(i, 3); // Get price from table Object quantityObject =
	 * table_2.getValueAt(i, 2); // Get quantity from table
	 * 
	 * try { double price = Double.parseDouble(priceObject.toString()); // Ensure
	 * price is a double int quantity = Integer.parseInt(quantityObject.toString());
	 * // Ensure quantity is an int totalAmount += price * quantity; // Update total
	 * amount } catch (NumberFormatException ex) {
	 * JOptionPane.showMessageDialog(null,
	 * "Error calculating total amount. Please check input values.", "Error",
	 * JOptionPane.ERROR_MESSAGE); return; // Exit if there is an issue with parsing
	 * } }
	 */

	    // Update the total amount label or field
		/*
		 * lblNewLabel_7.setText("Total: " + totalAmount); }
		 */

	private void resetTextField() {
		textField_3.setText("");
		textField_4.setText(""); 
		textField_5.setText("");
		textField_6.setText(""); 

	}
	private int getAvailableQuantityFromDB(String productName) throws SQLException {
	    int availableQuantity = 0;

	    String query = "SELECT quantity FROM product WHERE pname = ?";
	    try (Connection con = DatabaseConnection.getConnection();
	         var ps = con.prepareStatement(query)) {
	        ps.setString(1, productName);
	        try (var rs = ps.executeQuery()) {
	            if (rs.next()) {
	                availableQuantity = rs.getInt("quantity");
	            }
	        }
	    }

	    return availableQuantity;
	}
	private void updateProductQuantityInDB(String productName, int newQuantity) throws SQLException {
	    String query = "UPDATE product SET quantity = ? WHERE pname = ?";
	    try (Connection con = DatabaseConnection.getConnection();
	         var ps = con.prepareStatement(query)) {
	        ps.setInt(1, newQuantity);
	        ps.setString(2, productName);
	        ps.executeUpdate();
	    }
	}

	private int getCustomerIdByEmail(String email) {
	    int customerId = -1;  
	    try (Connection con = DatabaseConnection.getConnection()) {
	        String query = "SELECT id FROM customer WHERE email = ?";
	        try (var ps = con.prepareStatement(query)) {
	            ps.setString(1, email); 
	            try (var rs = ps.executeQuery()) {
	                if (rs.next()) {
	                    customerId = rs.getInt("id");  
	                }
	            }
	        }
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	        JOptionPane.showMessageDialog(null, "Error retrieving customer ID: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
	    }
	    return customerId;
	}

	


}
