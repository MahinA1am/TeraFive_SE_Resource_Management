package pol;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Category extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JLabel lblNewLabel;
	private JTextField textField;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnReset;
	private JButton btnClose;
	private JLabel lblNewLabel_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Category frame = new Category("","");
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
	public Category(String userEmail,String userRole) {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 873, 579);
		contentPane = new JPanel();
		setLocationRelativeTo(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 60, 387, 469);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.BOLD, 12));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Name"
			}
		));
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_1 = new JLabel("Category");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(340, 20, 181, 29);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel = new JLabel("Name");
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(462, 190, 46, 14);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.BOLD, 12));
		textField.setColumns(10);
		textField.setBounds(462, 215, 328, 20);
		contentPane.add(textField);
		
		btnNewButton = new JButton("Save");
		btnNewButton.addActionListener(new ActionListener() { 
		    public void actionPerformed(ActionEvent e) {
		        String name = textField.getText();

		        if (name.isEmpty()) {
		            JOptionPane.showMessageDialog(null, "Category name cannot be empty.", "Error", JOptionPane.ERROR_MESSAGE);
		            return;
		        }

		        try (Connection connection = DatabaseConnection.getConnection()) {
		            String query = "INSERT INTO category (cname) VALUES (?)";
		            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
		                preparedStatement.setString(1, name);

		                int rowsInserted = preparedStatement.executeUpdate();
		                if (rowsInserted > 0) {
		                    JOptionPane.showMessageDialog(null, "Category added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
		                    loadTableData(); 
		                    textField.setText(""); 
		    		        table.clearSelection(); 
		                }
		            }
		        } catch (SQLException ex) {
		            JOptionPane.showMessageDialog(null, "Error while adding category: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		            ex.printStackTrace();
		        }
		    }
		});

		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBounds(462, 256, 74, 23);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("Update");
		btnNewButton_1.setEnabled(false);
    	
		btnNewButton_1.addActionListener(new ActionListener() { 
		    public void actionPerformed(ActionEvent e) {
		        int selectedRow = table.getSelectedRow();
		        if (selectedRow == -1) {
		            JOptionPane.showMessageDialog(null, "Please select a category to update.", "Error", JOptionPane.ERROR_MESSAGE);
		            return;
		        }

		        String id = table.getValueAt(selectedRow, 0).toString(); // Get the selected ID
		        String name = textField.getText();

		        if (name.isEmpty()) {
		            JOptionPane.showMessageDialog(null, "Category name cannot be empty.", "Error", JOptionPane.ERROR_MESSAGE);
		            return;
		        }

		        try (Connection connection = DatabaseConnection.getConnection()) {
		            String query = "UPDATE category SET cname = ? WHERE cid = ?";
		            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
		                preparedStatement.setString(1, name);
		                preparedStatement.setInt(2, Integer.parseInt(id));

		                int rowsUpdated = preparedStatement.executeUpdate();
		                if (rowsUpdated > 0) {
		                    JOptionPane.showMessageDialog(null, "Category updated successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
		                    loadTableData(); 
		                    textField.setText(""); 
		    		        table.clearSelection(); 
		                }
		            }
		        } catch (SQLException ex) {
		            JOptionPane.showMessageDialog(null, "Error while updating category: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		            ex.printStackTrace();
		        }
		        btnNewButton_1.setEnabled(false);
		    	btnNewButton.setEnabled(true);
		    }
		});

		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_1.setBounds(546, 256, 86, 23);
		contentPane.add(btnNewButton_1);
		
		btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() { 
		    public void actionPerformed(ActionEvent e) {
		        textField.setText(""); 
		        table.clearSelection(); 
		        btnNewButton_1.setEnabled(false);
		    	btnNewButton.setEnabled(true);
		    }
		});

		btnReset.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnReset.setBounds(643, 256, 74, 23);
		contentPane.add(btnReset);
		
		btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				   HomePage homeFrame = new HomePage(userEmail,userRole);
	                homeFrame.setVisible(true);
	                dispose();
			}
		});
		btnClose.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnClose.setBounds(727, 256, 74, 23);
		contentPane.add(btnClose);
		
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setIcon(new ImageIcon(Category.class.getResource("/Images/4813762.jpg")));
		lblNewLabel_2.setBounds(0, 0, 3000, 2000);
		contentPane.add(lblNewLabel_2);
		
		table.getSelectionModel().addListSelectionListener(event -> {
		    int selectedRow = table.getSelectedRow();
		    if (selectedRow != -1) {
		        String name = table.getValueAt(selectedRow, 1).toString();
		        textField.setText(name);
		        btnNewButton_1.setEnabled(true);
		    	btnNewButton.setEnabled(false);
		    }
		});
		

		loadTableData();
		  this.addWindowListener(new WindowAdapter() {
	            @Override
	            public void windowClosing(WindowEvent e) {
	            	  HomePage homeFrame = new HomePage(userEmail,userRole);
		                homeFrame.setVisible(true);
		                dispose();
	               
	            }
	        });
	}
	private void loadTableData() {
	    DefaultTableModel model = (DefaultTableModel) table.getModel();
	    model.setRowCount(0); 

	    try (Connection connection = DatabaseConnection.getConnection()) {
	        String query = "SELECT * FROM category";
	        try (Statement statement = connection.createStatement();
	             ResultSet resultSet = statement.executeQuery(query)) {

	            while (resultSet.next()) {
	                int id = resultSet.getInt("cid");
	                String name = resultSet.getString("cname");

	                model.addRow(new Object[]{id, name});
	            }
	        }
	    } catch (SQLException ex) {
	        JOptionPane.showMessageDialog(null, "Error while loading category data: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
	        ex.printStackTrace();
	    }
	}

}
