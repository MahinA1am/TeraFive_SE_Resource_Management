package pro;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;

public class Register extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private ButtonGroup bg=new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register frame = new Register();
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
	public Register() {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 950, 700);
		contentPane = new JPanel();
		 setResizable(false); 
		 setLocationRelativeTo(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRegistrationForm = new JLabel("Registration Form");
		lblRegistrationForm.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistrationForm.setForeground(new Color(0, 0, 0));
		lblRegistrationForm.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblRegistrationForm.setBounds(343, 37, 262, 24);
		contentPane.add(lblRegistrationForm);
		
		JLabel lblName = new JLabel("Name");
		lblName.setForeground(new Color(0, 0, 0));
		lblName.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblName.setBounds(343, 77, 46, 14);
		contentPane.add(lblName);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.BOLD, 12));
		textField.setColumns(10);
		textField.setBounds(343, 102, 262, 20);
		contentPane.add(textField);
		
		JLabel pass = new JLabel("Password");
		pass.setForeground(new Color(0, 0, 0));
		pass.setFont(new Font("Tahoma", Font.BOLD, 12));
		pass.setBounds(343, 415, 67, 14);
		contentPane.add(pass);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		textField_1.setColumns(10);
		textField_1.setBounds(343, 440, 262, 20);
		contentPane.add(textField_1);
		
		JLabel email_1 = new JLabel("Email");
		email_1.setForeground(new Color(0, 0, 0));
		email_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		email_1.setBounds(343, 344, 46, 14);
		contentPane.add(email_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		textField_2.setColumns(10);
		textField_2.setBounds(343, 369, 262, 20);
		contentPane.add(textField_2);
		
		JLabel lblConfirmPassword = new JLabel("Confirm Password");
		lblConfirmPassword.setForeground(new Color(0, 0, 0));
		lblConfirmPassword.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblConfirmPassword.setBounds(343, 481, 123, 14);
		contentPane.add(lblConfirmPassword);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		textField_3.setColumns(10);
		textField_3.setBounds(343, 506, 262, 20);
		contentPane.add(textField_3);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.setIcon(new ImageIcon(Register.class.getResource("/Images/login.png")));
		btnRegister.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnRegister.setBounds(382, 610, 177, 23);
		contentPane.add(btnRegister);
		
		JLabel lblPhoneNumber = new JLabel("Phone Number");
		lblPhoneNumber.setForeground(new Color(0, 0, 0));
		lblPhoneNumber.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPhoneNumber.setBounds(343, 144, 123, 14);
		contentPane.add(lblPhoneNumber);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		textField_4.setColumns(10);
		textField_4.setBounds(343, 169, 262, 20);
		contentPane.add(textField_4);
		
		JButton closeButton = new JButton("Back");
		closeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				  new LogIN().setVisible(true);
		            dispose();
			}
		});
		closeButton.setIcon(null);
		closeButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		closeButton.setBounds(833, 627, 91, 23);
		contentPane.add(closeButton);
		
		JLabel email_1_1 = new JLabel("Country");
		email_1_1.setForeground(new Color(0, 0, 0));
		email_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		email_1_1.setBounds(343, 215, 100, 14);
		contentPane.add(email_1_1);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		textField_5.setColumns(10);
		textField_5.setBounds(343, 240, 262, 20);
		contentPane.add(textField_5);
		
		JLabel email_1_2 = new JLabel("Address");
		email_1_2.setForeground(new Color(0, 0, 0));
		email_1_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		email_1_2.setBounds(343, 282, 84, 14);
		contentPane.add(email_1_2);
		
		textField_6 = new JTextField();
		textField_6.setFont(new Font("Tahoma", Font.BOLD, 12));
		textField_6.setColumns(10);
		textField_6.setBounds(343, 307, 262, 20);
		contentPane.add(textField_6);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Female");
		rdbtnNewRadioButton_1.setForeground(new Color(255, 255, 255));
		rdbtnNewRadioButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		rdbtnNewRadioButton_1.setBackground(new Color(0, 128, 128));
		rdbtnNewRadioButton_1.setBounds(495, 555, 109, 23);
		contentPane.add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Male");
		rdbtnNewRadioButton.setForeground(new Color(255, 255, 255));
		rdbtnNewRadioButton.setSelected(true);
		rdbtnNewRadioButton.setBackground(new Color(0, 128, 128));
		rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		rdbtnNewRadioButton.setBounds(343, 555, 109, 23);
		contentPane.add(rdbtnNewRadioButton);
		bg.add(rdbtnNewRadioButton_1);
		bg.add(rdbtnNewRadioButton);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Register.class.getResource("/Images/RegBG.png")));
		lblNewLabel.setBounds(0, 0, 950, 700);
		contentPane.add(lblNewLabel);
		
		btnRegister.addActionListener(e -> {
		    String name = textField.getText();
		    String phone = textField_4.getText();
		    String country = textField_5.getText();
		    String address = textField_6.getText();
		    String email = textField_2.getText();
		    String password = textField_1.getText();
		    String confirmPassword = textField_3.getText();
		    String gender = rdbtnNewRadioButton.isSelected() ? "Male" : "Female"; // Get gender based on selected radio button

		    if (name.isEmpty() || phone.isEmpty() || country.isEmpty() || address.isEmpty() ||
		        email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
		        JOptionPane.showMessageDialog(null, "All fields are required. Please fill in all the fields.", "Error", JOptionPane.ERROR_MESSAGE);
		        return;
		    }

		    if (!password.equals(confirmPassword)) {
		        JOptionPane.showMessageDialog(this, "Passwords do not match.");
		        return;
		    }

		    try (Connection connection = DatabaseConnection.getConnection()) {
		        String query = "INSERT INTO users (name, phone, country, address, email, password, gender) VALUES (?, ?, ?, ?, ?, ?, ?)";
		        try (PreparedStatement statement = connection.prepareStatement(query)) {
		            statement.setString(1, name);
		            statement.setString(2, phone);
		            statement.setString(3, country);
		            statement.setString(4, address);
		            statement.setString(5, email);
		            statement.setString(6, password);
		            statement.setString(7, gender);
		            statement.executeUpdate();
		            JOptionPane.showMessageDialog(this, "Registration successful!");
		            
		            new LogIN().setVisible(true);
		            dispose();
		        }
		    } catch (SQLException ex) {
		        ex.printStackTrace();
		        JOptionPane.showMessageDialog(this, "Error during registration.");
		    }
		});
		
		 this.addWindowListener(new WindowAdapter() {
	            @Override
	            public void windowClosing(WindowEvent e) {
	            	

						
					new LogIN().setVisible(true);
					dispose();
						

	               
	            }
	        });




	}
}
