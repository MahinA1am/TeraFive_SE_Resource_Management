package pro;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class Register extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 838, 543);
		contentPane = new JPanel();
		 setResizable(false); 
		 setLocationRelativeTo(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRegistrationForm = new JLabel("Registration Form");
		lblRegistrationForm.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistrationForm.setForeground(new Color(255, 128, 0));
		lblRegistrationForm.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblRegistrationForm.setBounds(275, 36, 262, 24);
		contentPane.add(lblRegistrationForm);
		
		JLabel lblName = new JLabel("Name");
		lblName.setForeground(new Color(255, 128, 0));
		lblName.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblName.setBounds(275, 76, 46, 14);
		contentPane.add(lblName);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.BOLD, 12));
		textField.setColumns(10);
		textField.setBounds(275, 101, 262, 20);
		contentPane.add(textField);
		
		JLabel pass = new JLabel("Password");
		pass.setForeground(new Color(255, 128, 0));
		pass.setFont(new Font("Tahoma", Font.BOLD, 12));
		pass.setBounds(275, 270, 67, 14);
		contentPane.add(pass);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		textField_1.setColumns(10);
		textField_1.setBounds(275, 295, 262, 20);
		contentPane.add(textField_1);
		
		JLabel email_1 = new JLabel("Email");
		email_1.setForeground(new Color(255, 128, 0));
		email_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		email_1.setBounds(275, 199, 46, 14);
		contentPane.add(email_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		textField_2.setColumns(10);
		textField_2.setBounds(275, 224, 262, 20);
		contentPane.add(textField_2);
		
		JLabel lblConfirmPassword = new JLabel("Confirm Password");
		lblConfirmPassword.setForeground(new Color(255, 128, 0));
		lblConfirmPassword.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblConfirmPassword.setBounds(275, 347, 123, 14);
		contentPane.add(lblConfirmPassword);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		textField_3.setColumns(10);
		textField_3.setBounds(275, 372, 262, 20);
		contentPane.add(textField_3);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.setIcon(new ImageIcon(Register.class.getResource("/Images/login.png")));
		btnRegister.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnRegister.setBounds(312, 426, 177, 23);
		contentPane.add(btnRegister);
		
		JLabel lblPhoneNumber = new JLabel("Phone Number");
		lblPhoneNumber.setForeground(new Color(255, 128, 0));
		lblPhoneNumber.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPhoneNumber.setBounds(275, 143, 123, 14);
		contentPane.add(lblPhoneNumber);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		textField_4.setColumns(10);
		textField_4.setBounds(275, 168, 262, 20);
		contentPane.add(textField_4);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Register.class.getResource("/Images/RegistrationBg.png")));
		lblNewLabel.setBounds(-174, -75, 1920, 1280);
		contentPane.add(lblNewLabel);
	}
}
