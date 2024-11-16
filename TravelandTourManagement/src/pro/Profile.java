package pro;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Profile extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private ButtonGroup bg=new ButtonGroup();
	private String newEmail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Profile frame = new Profile("");
					
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
	public Profile(String userEmail) {
		newEmail=userEmail;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 865, 571);
		contentPane = new JPanel();
		setResizable(false); 
		setLocationRelativeTo(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("Name");
		lblName.setForeground(new Color(255, 128, 0));
		lblName.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblName.setBounds(106, 78, 46, 14);
		contentPane.add(lblName);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.BOLD, 12));
		textField.setColumns(10);
		textField.setBounds(106, 103, 262, 20);
		contentPane.add(textField);
		
		JLabel lblPhoneNumber = new JLabel("Phone Number");
		lblPhoneNumber.setForeground(new Color(255, 128, 0));
		lblPhoneNumber.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPhoneNumber.setBounds(106, 145, 123, 14);
		contentPane.add(lblPhoneNumber);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		textField_1.setColumns(10);
		textField_1.setBounds(106, 170, 262, 20);
		contentPane.add(textField_1);
		
		JLabel email_1 = new JLabel("Email");
		email_1.setForeground(new Color(255, 128, 0));
		email_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		email_1.setBounds(106, 201, 46, 14);
		contentPane.add(email_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		textField_2.setColumns(10);
		textField_2.setBounds(106, 226, 262, 20);
		contentPane.add(textField_2);
		ImageIcon originalIcon = new ImageIcon(Profile.class.getResource("/Images/newcustomer.jpg"));

		
		Image resizedImage = originalIcon.getImage().getScaledInstance(395, 630, java.awt.Image.SCALE_SMOOTH);
		
		JLabel lblProfile = new JLabel("Profile");
		lblProfile.setHorizontalAlignment(SwingConstants.CENTER);
		lblProfile.setForeground(new Color(255, 128, 0));
		lblProfile.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblProfile.setBounds(106, 21, 262, 24);
		contentPane.add(lblProfile);
		
		JLabel email_1_1 = new JLabel("Country");
		email_1_1.setForeground(new Color(255, 128, 0));
		email_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		email_1_1.setBounds(106, 268, 100, 14);
		contentPane.add(email_1_1);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		textField_3.setColumns(10);
		textField_3.setBounds(106, 293, 262, 20);
		contentPane.add(textField_3);
		
		JLabel email_1_2 = new JLabel("Address");
		email_1_2.setForeground(new Color(255, 128, 0));
		email_1_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		email_1_2.setBounds(106, 342, 84, 14);
		contentPane.add(email_1_2);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		textField_4.setColumns(10);
		textField_4.setBounds(106, 367, 262, 20);
		contentPane.add(textField_4);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Male");
		rdbtnNewRadioButton.setSelected(true);
		rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		rdbtnNewRadioButton.setBounds(107, 404, 109, 23);
		contentPane.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Female");
		rdbtnNewRadioButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		rdbtnNewRadioButton_1.setBounds(259, 404, 109, 23);
		contentPane.add(rdbtnNewRadioButton_1);
		bg.add(rdbtnNewRadioButton_1);
		bg.add(rdbtnNewRadioButton);
		
		JButton btnNewButton_1 = new JButton("Update");
		btnNewButton_1.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        // Retrieve data from the text fields
		        String name = textField.getText();
		        String phone = textField_1.getText();
		        String email = textField_2.getText();
		        String country = textField_3.getText();
		        String address = textField_4.getText();
		        String gender = rdbtnNewRadioButton.isSelected() ? "Male" : "Female";  // Get selected gender

		        // Validate input fields (optional)
		        if (name.isEmpty() || phone.isEmpty() || email.isEmpty() || country.isEmpty() || address.isEmpty()) {
		            JOptionPane.showMessageDialog(Profile.this, "Please fill in all fields.");
		            return;
		        }
		        newEmail=email;

		        // Prepare the SQL update query
		        String updateQuery = "UPDATE users SET name = ?, phone = ?, country = ?, address = ?, gender = ? WHERE email = ?";

		        // Execute the update
		        try (Connection connection = DatabaseConnection.getConnection();
		             PreparedStatement statement = connection.prepareStatement(updateQuery)) {

		            // Set parameters for the query
		            statement.setString(1, name);
		            statement.setString(2, phone);
		            statement.setString(3, country);
		            statement.setString(4, address);
		            statement.setString(5, gender);
		            statement.setString(6, email);  // Ensure you're updating the right user by email

		            // Execute update
		            int rowsUpdated = statement.executeUpdate();

		            if (rowsUpdated > 0) {
		                JOptionPane.showMessageDialog(Profile.this, "Profile updated successfully!");
		            } else {
		                JOptionPane.showMessageDialog(Profile.this, "Error: Profile update failed.");
		            }

		        } catch (SQLException ex) {
		            ex.printStackTrace();
		            JOptionPane.showMessageDialog(Profile.this, "Error updating profile.");
		        }
		        loadUserData(newEmail);
		    }
		   
		});

		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_1.setBounds(106, 447, 86, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    new HomePage(newEmail).setVisible(true);
                dispose();
			}
		});
		btnClose.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnClose.setBounds(259, 447, 74, 23);
		contentPane.add(btnClose);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		
		
				lblNewLabel.setIcon(new ImageIcon(Profile.class.getResource("/Images/ProfileBG.png")));
				
					lblNewLabel.setBounds(0, 0, 849, 571);
					contentPane.add(lblNewLabel);
		loadUserData(userEmail);
	}
	  private void loadUserData(String userEmail) {
	        try (Connection connection = DatabaseConnection.getConnection()) {
	            String query = "SELECT name, phone, email, country, address, gender FROM users WHERE email = ?";
	            try (PreparedStatement statement = connection.prepareStatement(query)) {
	                statement.setString(1, userEmail);
	                ResultSet resultSet = statement.executeQuery();

	                if (resultSet.next()) {
	                   
	                    textField.setText(resultSet.getString("name"));
	                    textField_1.setText(resultSet.getString("phone"));
	                    textField_2.setText(resultSet.getString("email"));
	                    textField_3.setText(resultSet.getString("country"));
	                    textField_4.setText(resultSet.getString("address"));

	                   
	                    String gender = resultSet.getString("gender");
	                    if ("Male".equalsIgnoreCase(gender)) {
	                        bg.setSelected(bg.getElements().nextElement().getModel(), false);
	                    } else {
	                        bg.setSelected(bg.getElements().nextElement().getModel(), true);
	                    }
	                }
	            }
	        } catch (SQLException ex) {
	            ex.printStackTrace();
	            JOptionPane.showMessageDialog(this, "Error loading user data.");
	        }
	    }
}

