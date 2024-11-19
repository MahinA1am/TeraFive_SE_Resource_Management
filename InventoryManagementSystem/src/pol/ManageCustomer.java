package pol;

import java.awt.EventQueue;

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
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;

public class ManageCustomer extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JLabel lblNewLabel;
	private JTextField textField;
	private JLabel lblNewLabel_2;
	private JTextField textField_1;
	private JLabel lblNewLabel_3;
	private JTextField textField_2;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnReset;
	private JButton btnClose;
	private JLabel lblNewLabel_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManageCustomer frame = new ManageCustomer();
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
	public ManageCustomer() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 874, 573);
		contentPane = new JPanel();
		setLocationRelativeTo(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Manage Customer");
		lblNewLabel_1.setBounds(329, 11, 181, 29);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		contentPane.add(lblNewLabel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(24, 54, 387, 469);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
					"ID", "Name", "Email", "Mobile Number"
			}
		));
		table.setFont(new Font("Tahoma", Font.BOLD, 12));
		scrollPane.setViewportView(table);
		
		lblNewLabel = new JLabel("Name");
		lblNewLabel.setBounds(461, 106, 46, 14);
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(461, 131, 328, 20);
		textField.setFont(new Font("Tahoma", Font.BOLD, 12));
		textField.setColumns(10);
		contentPane.add(textField);
		
		lblNewLabel_2 = new JLabel("Mobile Number");
		lblNewLabel_2.setBounds(461, 166, 128, 14);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(461, 201, 328, 20);
		textField_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		textField_1.setColumns(10);
		contentPane.add(textField_1);
		
		lblNewLabel_3 = new JLabel("Email");
		lblNewLabel_3.setBounds(461, 232, 46, 14);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(lblNewLabel_3);
		
		textField_2 = new JTextField();
		textField_2.setBounds(461, 269, 328, 20);
		textField_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		textField_2.setColumns(10);
		contentPane.add(textField_2);
		
		btnNewButton = new JButton("Save");
		btnNewButton.setBounds(461, 311, 74, 23);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("Update");
		btnNewButton_1.setEnabled(false);
    	
		btnNewButton_1.setBounds(545, 311, 89, 23);
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(btnNewButton_1);
		
		btnReset = new JButton("Reset");
		btnReset.setBounds(644, 311, 74, 23);
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(btnReset);
		
		btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				   HomePage homeFrame = new HomePage("","");
	                homeFrame.setVisible(true);
	                dispose();
			}
		});
		btnClose.setBounds(728, 311, 74, 23);
		btnClose.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(btnClose);
		
		lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(ManageCustomer.class.getResource("/Images/4813762.jpg")));
		lblNewLabel_4.setBounds(0, 0, 3000, 2000);
		contentPane.add(lblNewLabel_4);
		
		btnNewButton.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        saveCustomer();
		        
		    }
		});

		btnNewButton_1.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        updateCustomer();
		        btnNewButton_1.setEnabled(false);
		    	btnNewButton.setEnabled(true);
		    }
		});

		btnReset.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        resetFields();
		        btnNewButton_1.setEnabled(false);
		    	btnNewButton.setEnabled(true);
		    }
		});
		table.getSelectionModel().addListSelectionListener(event -> {
		    int selectedRow = table.getSelectedRow();
		    if (selectedRow != -1) {
		        textField.setText(table.getValueAt(selectedRow, 1).toString());
		        textField_1.setText(table.getValueAt(selectedRow, 3).toString());
		        textField_2.setText(table.getValueAt(selectedRow, 2).toString());
		        btnNewButton_1.setEnabled(true);
		    	btnNewButton.setEnabled(false);
		    }
		});
		
		loadCustomerData();


	}
	private void saveCustomer() {
	    try (Connection con = DatabaseConnection.getConnection()) {
	        String name = textField.getText();
	        String mobileNumber = textField_1.getText();
	        String email = textField_2.getText();

	        if (name.isEmpty() || mobileNumber.isEmpty() || email.isEmpty()) {
	            JOptionPane.showMessageDialog(this, "Please fill all fields.", "Validation Error", JOptionPane.ERROR_MESSAGE);
	            return;
	        }

	        String query = "INSERT INTO customer (name, email, mobile_number) VALUES (?, ?, ?)";
	        try (var ps = con.prepareStatement(query)) {
	            ps.setString(1, name);
	            ps.setString(2, email);
	            ps.setString(3, mobileNumber);
	            ps.executeUpdate();
	            JOptionPane.showMessageDialog(this, "Customer saved successfully.");
	            loadCustomerData();
	            resetFields();
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	        JOptionPane.showMessageDialog(this, "Error saving customer: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
	    }
	}
	private void updateCustomer() {
	    try (Connection con = DatabaseConnection.getConnection()) {
	        int selectedRow = table.getSelectedRow();
	        if (selectedRow == -1) {
	            JOptionPane.showMessageDialog(this, "Please select a customer to update.", "Validation Error", JOptionPane.ERROR_MESSAGE);
	            return;
	        }

	        int id = Integer.parseInt(table.getValueAt(selectedRow, 0).toString());
	        String name = textField.getText();
	        String mobileNumber = textField_1.getText();
	        String email = textField_2.getText();

	        if (name.isEmpty() || mobileNumber.isEmpty() || email.isEmpty()) {
	            JOptionPane.showMessageDialog(this, "Please fill all fields.", "Validation Error", JOptionPane.ERROR_MESSAGE);
	            return;
	        }

	        String query = "UPDATE customer SET name = ?, email = ?, mobile_number = ? WHERE id = ?";
	        try (var ps = con.prepareStatement(query)) {
	            ps.setString(1, name);
	            ps.setString(2, email);
	            ps.setString(3, mobileNumber);
	            ps.setInt(4, id);
	            ps.executeUpdate();
	            JOptionPane.showMessageDialog(this, "Customer updated successfully.");
	            loadCustomerData();
	            resetFields();
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	        JOptionPane.showMessageDialog(this, "Error updating customer: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
	    }
	}
	private void resetFields() {
	    textField.setText("");
	    textField_1.setText("");
	    textField_2.setText("");
	    table.clearSelection();
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




	

}
