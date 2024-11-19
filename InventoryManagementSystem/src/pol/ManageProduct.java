package pol;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ManageProduct extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JComboBox<String> comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManageProduct frame = new ManageProduct();
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
	public ManageProduct() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 876, 579);
		contentPane = new JPanel();
		setLocationRelativeTo(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Manage Product");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(327, 24, 181, 29);
		contentPane.add(lblNewLabel_1);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 64, 387, 469);
		contentPane.add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "ID", "Name", "Quantity", "Price", "Description", "Category ID", "Category Name" }));
		table.setFont(new Font("Tahoma", Font.BOLD, 12));
		scrollPane.setViewportView(table);

		JLabel lblName = new JLabel("Name");
		lblName.setHorizontalAlignment(SwingConstants.LEFT);
		lblName.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblName.setBounds(465, 77, 46, 14);
		contentPane.add(lblName);

		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.BOLD, 12));
		textField.setBounds(465, 102, 328, 20);
		contentPane.add(textField);

		JLabel lblQuantity = new JLabel("Add Quantity");
		lblQuantity.setHorizontalAlignment(SwingConstants.LEFT);
		lblQuantity.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblQuantity.setBounds(465, 137, 128, 14);
		contentPane.add(lblQuantity);

		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		textField_1.setBounds(465, 172, 328, 20);
		contentPane.add(textField_1);

		JLabel lblPrice = new JLabel("Price");
		lblPrice.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPrice.setBounds(465, 203, 46, 14);
		contentPane.add(lblPrice);

		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		textField_2.setBounds(465, 228, 328, 20);
		contentPane.add(textField_2);

		JLabel lblDescription = new JLabel("Description");
		lblDescription.setHorizontalAlignment(SwingConstants.LEFT);
		lblDescription.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDescription.setBounds(465, 264, 128, 14);
		contentPane.add(lblDescription);

		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		textField_3.setBounds(465, 289, 328, 20);
		contentPane.add(textField_3);

		JLabel lblCategory = new JLabel("Category");
		lblCategory.setHorizontalAlignment(SwingConstants.LEFT);
		lblCategory.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCategory.setBounds(465, 320, 128, 14);
		contentPane.add(lblCategory);

		comboBox = new JComboBox<>();
		comboBox.setFont(new Font("Tahoma", Font.BOLD, 12));
		comboBox.setBounds(465, 345, 328, 22);
		contentPane.add(comboBox);

		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField.getText().trim().isEmpty() || 
					    textField_1.getText().trim().isEmpty() || 
					    textField_2.getText().trim().isEmpty() || 
					    textField_3.getText().trim().isEmpty() || 
					    comboBox.getSelectedItem().toString().equalsIgnoreCase("Not Added")) {
					    
					    JOptionPane.showMessageDialog(null, "Please fill all fields and select a category.", "Validation Error", JOptionPane.ERROR_MESSAGE);
					    return;
					}
				

				saveProduct();
			}
		});
		btnSave.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnSave.setBounds(465, 394, 74, 23);
		contentPane.add(btnSave);

		JButton btnUpdate = new JButton("Update");
		 btnUpdate.setEnabled(false);
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = table.getSelectedRow();
		        if (selectedRow != -1) {
		        	
		        	updateProduct(selectedRow);
		        }
		        else {
		        	 JOptionPane.showMessageDialog(null, "Please select a category to update.", "Error", JOptionPane.ERROR_MESSAGE);
		        }
		        btnSave.setEnabled(true);
		        btnUpdate.setEnabled(false);
				
			}
		});
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnUpdate.setBounds(549, 394, 89, 23);
		contentPane.add(btnUpdate);

		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetFields();
                btnUpdate.setEnabled(false);
                btnSave.setEnabled(true);
			}
		});
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnReset.setBounds(648, 394, 74, 23);
		contentPane.add(btnReset);

		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnClose.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnClose.setBounds(732, 394, 74, 23);
		contentPane.add(btnClose);

		JLabel lblBackground = new JLabel("");
		lblBackground.setIcon(new ImageIcon(ManageProduct.class.getResource("/Images/4813762.jpg")));
		lblBackground.setBounds(0, 0, 3000, 2000);
		contentPane.add(lblBackground);

		loadCategories();
		loadProductData();
		

		table.getSelectionModel().addListSelectionListener(event -> {
		    if (!event.getValueIsAdjusting()) {
		        int selectedRow = table.getSelectedRow();
		        if (selectedRow != -1) {
		            textField.setText(table.getValueAt(selectedRow, 1).toString());
		            textField_1.setText(table.getValueAt(selectedRow, 2).toString());
		            textField_2.setText(table.getValueAt(selectedRow, 3).toString());
		            textField_3.setText(table.getValueAt(selectedRow, 4).toString());
		            comboBox.setSelectedItem(table.getValueAt(selectedRow, 6).toString());
		            btnSave.setEnabled(false);
		            btnUpdate.setEnabled(true);
		        } else {
		            resetFields();
		            btnSave.setEnabled(true);
		        }
		    }
		});
		

	}

	private void saveProduct() {
	    try (Connection con = DatabaseConnection.getConnection()) {
	        String name = textField.getText();
	        int quantity = Integer.parseInt(textField_1.getText());
	        double price = Double.parseDouble(textField_2.getText());
	        String description = textField_3.getText();
	        String categoryName = comboBox.getSelectedItem().toString();

	      

	       
	        String query = "SELECT cid FROM category WHERE cname = ?";
	        try (var ps = con.prepareStatement(query)) {
	            ps.setString(1, categoryName);
	            try (var rs = ps.executeQuery()) {
	                if (rs.next()) {
	                    int categoryId = rs.getInt("cid");

	                    // Insert Product into Database
	                    query = "INSERT INTO product (pname, quantity, price, description, category_id,category_name) VALUES (?, ?, ?, ?, ?, ?)";
	                    try (var insertPs = con.prepareStatement(query)) {
	                        insertPs.setString(1, name);
	                        insertPs.setInt(2, quantity);
	                        insertPs.setDouble(3, price);
	                        insertPs.setString(4, description);
	                        insertPs.setInt(5, categoryId);
	                        insertPs.setString(6,categoryName);
	                        insertPs.executeUpdate();
	                    }

	                    loadProductData();
	                    resetFields(); 
	                    JOptionPane.showMessageDialog(this, "Product saved successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
	                } else {
	                    JOptionPane.showMessageDialog(this, "Selected category does not exist.", "Error", JOptionPane.ERROR_MESSAGE);
	                }
	            }
	        }
	    } catch (SQLException e) {
	        JOptionPane.showMessageDialog(this, "Database error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
	        e.printStackTrace();
	    } catch (Exception e) {
	        JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
	        e.printStackTrace();
	    }
	}



	

	private void resetFields() {
	    textField.setText("");
	    textField_1.setText("");
	    textField_2.setText("");
	    textField_3.setText("");
	    comboBox.setSelectedIndex(0);
	    table.clearSelection();
	}


	private void loadCategories() {
	    try (Connection con = DatabaseConnection.getConnection()) {
	        comboBox.removeAllItems();
	        comboBox.addItem("Not Added");

	        String query = "SELECT cname FROM category";
	        try (var ps = con.prepareStatement(query);
	             var rs = ps.executeQuery()) {
	            while (rs.next()) {
	                comboBox.addItem(rs.getString("cname"));
	            }
	        }

	        System.out.println("Categories loaded successfully.");
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	
	private void updateProduct(int selectedRow) {
	    try (Connection con = DatabaseConnection.getConnection()) {
	      

	        int id = Integer.parseInt(table.getValueAt(selectedRow, 0).toString());
	        String name = textField.getText();
	        int quantity = Integer.parseInt(textField_1.getText());
	        double price = Double.parseDouble(textField_2.getText());
	        String description = textField_3.getText();
	        String categoryName = comboBox.getSelectedItem().toString();

	        // Validate that all required fields are filled
	        if (name.isEmpty() || categoryName.equals("Not Added") || quantity <= 0 || price <= 0) {
	            JOptionPane.showMessageDialog(this, "Please fill all fields with valid values and select a category.", "Validation Error", JOptionPane.ERROR_MESSAGE);
	            return; // Stop further execution
	        }

	        // Get Category ID from Category Name
	        String query = "SELECT cid FROM category WHERE cname = ?";
	        try (var ps = con.prepareStatement(query)) {
	            ps.setString(1, categoryName);
	            try (var rs = ps.executeQuery()) {
	                if (rs.next()) {
	                    int categoryId = rs.getInt("cid");

	                    // Update Product in Database
	                    query = "UPDATE product SET pname = ?, quantity = ?, price = ?, description = ?, category_id = ? ,category_name=? WHERE pid = ?";
	                    try (var updatePs = con.prepareStatement(query)) {
	                        updatePs.setString(1, name);
	                        updatePs.setInt(2, quantity);
	                        updatePs.setDouble(3, price);
	                        updatePs.setString(4, description);
	                        updatePs.setInt(5, categoryId);
	                        updatePs.setString(6, categoryName);
	                        updatePs.setInt(7, id);
	                        updatePs.executeUpdate();
	                    }

	                    loadProductData(); // Reload data to show updated information
	                    resetFields(); // Reset input fields
	                    JOptionPane.showMessageDialog(this, "Product updated successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
	                } else {
	                    JOptionPane.showMessageDialog(this, "Selected category does not exist.", "Error", JOptionPane.ERROR_MESSAGE);
	                }
	            }
	        }
	    } catch (SQLException e) {
	        JOptionPane.showMessageDialog(this, "Database error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
	        e.printStackTrace();
	    } catch (Exception e) {
	        JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
	        e.printStackTrace();
	    }
	}


	private void loadProductData() {
	    try (Connection con = DatabaseConnection.getConnection()) {
	        DefaultTableModel model = (DefaultTableModel) table.getModel();
	        model.setRowCount(0);  // Clear existing rows

	        String query = "SELECT p.pid, p.pname, p.quantity, p.price, p.description, p.category_id, c.cname "
	                     + "FROM product p "
	                     + "INNER JOIN category c ON p.category_id = c.cid";
	        System.out.println("Executing query: " + query);

	        try (var ps = con.prepareStatement(query);
	             var rs = ps.executeQuery()) {
	            while (rs.next()) {
	                model.addRow(new Object[]{
	                    rs.getInt("pid"),
	                    rs.getString("pname"),  // Corrected from "product_name" to "pname"
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


}
