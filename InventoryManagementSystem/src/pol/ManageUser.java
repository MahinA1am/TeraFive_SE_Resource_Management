package pol;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class ManageUser extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	//private String pass="";
	JComboBox comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManageUser frame = new ManageUser("","");
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
	public ManageUser(String userEmail,String userRole) {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 874, 584);
		contentPane = new JPanel();
		
		 setLocationRelativeTo(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Manage User");
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(316, 25, 181, 29);
		contentPane.add(lblNewLabel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(51, 65, 387, 469);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Name", "Email", "Mobile Number", "Address", "Status"
			}
		));
		
		 

		
		JLabel lblNewLabel_2 = new JLabel("Name");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2.setBounds(487, 72, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.BOLD, 12));
		textField.setBounds(487, 97, 328, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Mobile Number");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_3.setBounds(487, 132, 128, 14);
		contentPane.add(lblNewLabel_3);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		textField_1.setBounds(487, 167, 328, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Email");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_4.setBounds(487, 198, 46, 14);
		contentPane.add(lblNewLabel_4);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		textField_2.setBounds(487, 223, 328, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_2_1 = new JLabel("Password");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2_1.setBounds(487, 259, 66, 14);
		contentPane.add(lblNewLabel_2_1);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		textField_3.setColumns(10);
		textField_3.setBounds(487, 284, 328, 20);
		contentPane.add(textField_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("Address");
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3_1.setBounds(487, 319, 128, 14);
		contentPane.add(lblNewLabel_3_1);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		textField_4.setColumns(10);
		textField_4.setBounds(487, 354, 328, 20);
		contentPane.add(textField_4);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("Status");
		lblNewLabel_3_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_3_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3_1_1.setBounds(487, 397, 128, 14);
		contentPane.add(lblNewLabel_3_1_1);
		
		comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.BOLD, 12));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Active", "Inactive"}));
		comboBox.setBounds(487, 422, 328, 22);
		contentPane.add(comboBox);
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        String name = textField.getText();
		        String mobileNumber = textField_1.getText();
		        String email = textField_2.getText();
		        String password = textField_3.getText();
		        String address = textField_4.getText();
		        String status = comboBox.getSelectedItem().toString();

		        if (name.isEmpty() || mobileNumber.isEmpty() || email.isEmpty() || password.isEmpty() || address.isEmpty()) {
		            JOptionPane.showMessageDialog(null, "Please fill all fields.", "Error", JOptionPane.ERROR_MESSAGE);
		            return;
		        }

		        try (Connection connection = DatabaseConnection.getConnection()) {
		            String query = "INSERT INTO myuser (userRole,name, mobileNumber, email, password, address, status) VALUES (?,?, ?, ?, ?, ?, ?)";
		            try (var preparedStatement = connection.prepareStatement(query)) {
		            	preparedStatement.setString(1, "user");
		                preparedStatement.setString(2, name);
		                preparedStatement.setString(3, mobileNumber);
		                preparedStatement.setString(4, email);
		                preparedStatement.setString(5, password); 
		                preparedStatement.setString(6, address);
		                preparedStatement.setString(7, status);

		                int rowsInserted = preparedStatement.executeUpdate();
		                if (rowsInserted > 0) {
		                    JOptionPane.showMessageDialog(null, "User added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
		                    loadUserData();
		                    ResetValue();
		                    
		                }
		            }
		        } catch (Exception ex) {
		            JOptionPane.showMessageDialog(null, "Error while adding user: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		            ex.printStackTrace();
		        }
		    }
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBounds(487, 471, 74, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Update");
		btnNewButton_1.setEnabled(false);
		btnNewButton_1.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        String name = textField.getText();
		        String mobileNumber = textField_1.getText();
		        String email = textField_2.getText();
		        String password = textField_3.getText();
		        String address = textField_4.getText();
		        String status = comboBox.getSelectedItem().toString();

		        if (name.isEmpty() || mobileNumber.isEmpty() || email.isEmpty() || address.isEmpty()) {
		            JOptionPane.showMessageDialog(null, "Please fill all fields.", "Error", JOptionPane.ERROR_MESSAGE);
		            return;
		        }

		        try (Connection connection = DatabaseConnection.getConnection()) {
		            String query = "UPDATE myuser SET name = ?, mobileNumber = ?, password = ?, address = ?, status = ? WHERE email = ?";
		            try (var preparedStatement = connection.prepareStatement(query)) {
		                preparedStatement.setString(1, name);
		                preparedStatement.setString(2, mobileNumber);
		                preparedStatement.setString(3, password);
		                preparedStatement.setString(4, address);
		                preparedStatement.setString(5, status);
		                preparedStatement.setString(6, email);

		                int rowsUpdated = preparedStatement.executeUpdate();
		                if (rowsUpdated > 0) {
		                    JOptionPane.showMessageDialog(null, "User updated successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
		                    loadUserData();
		                    ResetValue();
		                } else {
		                    JOptionPane.showMessageDialog(null, "No user found with the provided email.", "Update Failed", JOptionPane.ERROR_MESSAGE);
		                }
		            }
		        } catch (Exception ex) {
		            JOptionPane.showMessageDialog(null, "Error while updating user: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		            ex.printStackTrace();
		        }
		    	btnNewButton_1.setEnabled(false);
		    	btnNewButton.setEnabled(true);
		    }
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_1.setBounds(571, 471, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() { 
		    public void actionPerformed(ActionEvent e) {
		    	ResetValue();
		    	btnNewButton_1.setEnabled(false);
		    	btnNewButton.setEnabled(true);
		    }
		});
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnReset.setBounds(670, 471, 74, 23);
		contentPane.add(btnReset);
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				   HomePage homeFrame = new HomePage(userEmail,userRole);
	                homeFrame.setVisible(true);
	                dispose();
			}
		});
		btnClose.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnClose.setBounds(754, 471, 74, 23);
		contentPane.add(btnClose);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(ManageUser.class.getResource("/Images/4813762.jpg")));
		lblNewLabel.setBounds(0, 0, 3000, 2000);
		contentPane.add(lblNewLabel);
		
		table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int row = table.getSelectedRow();
                if (row != -1) { 
                    textField.setText(table.getValueAt(row, 1).toString()); 
                    textField_1.setText(table.getValueAt(row, 3).toString()); 
                    textField_2.setText(table.getValueAt(row, 2).toString()); 
               
                    textField_4.setText(table.getValueAt(row, 4).toString()); 
                    comboBox.setSelectedItem(table.getValueAt(row, 5).toString());
                	btnNewButton_1.setEnabled(true);
    		    	btnNewButton.setEnabled(false);
                }
            }
        });
		
		loadUserData();
		this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
            	  HomePage homeFrame = new HomePage(userEmail,userRole);
	                homeFrame.setVisible(true);
	                dispose();
               
            }
        });
	}
	
	private void loadUserData() {
	    DefaultTableModel model = (DefaultTableModel) table.getModel();
	    model.setRowCount(0); 

	    try (Connection connection = DatabaseConnection.getConnection()) {
	        String query = "SELECT * FROM myuser";
	        try (var preparedStatement = connection.prepareStatement(query);
	             var resultSet = preparedStatement.executeQuery()) {

	            while (resultSet.next()) {
	                int id = resultSet.getInt("id");
	                String name = resultSet.getString("name");
	                String email = resultSet.getString("email");
	                String mobileNumber = resultSet.getString("mobileNumber");
	                String address = resultSet.getString("address");
	                String status = resultSet.getString("status");

	               
	                model.addRow(new Object[]{id, name, email, mobileNumber, address, status});
	            }
	        }
	    } catch (SQLException ex) {
	        JOptionPane.showMessageDialog(null, "Error while fetching user data: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
	        ex.printStackTrace();
	    }
	}
	private void ResetValue() {
		   textField.setText("");
	        textField_1.setText("");
	        textField_2.setText("");
	        textField_3.setText("");
	        textField_4.setText("");
	        comboBox.setSelectedIndex(0);
	        table.clearSelection();
	}
	

}
