package pro;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 776, 482);
		contentPane = new JPanel();
		 setResizable(false); 
		 setLocationRelativeTo(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel welcome = new JLabel("Wecome");
		welcome.setForeground(new Color(255, 255, 255));
		welcome.setHorizontalAlignment(SwingConstants.CENTER);
		welcome.setFont(new Font("Tahoma", Font.BOLD, 14));
		welcome.setBounds(533, 83, 107, 24);
		contentPane.add(welcome);
		
		JLabel email = new JLabel("Email");
		email.setForeground(new Color(255, 255, 255));
		email.setFont(new Font("Tahoma", Font.BOLD, 12));
		email.setBounds(447, 123, 46, 14);
		contentPane.add(email);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.BOLD, 12));
		textField.setColumns(10);
		textField.setBounds(447, 148, 262, 20);
		contentPane.add(textField);
		
		JLabel pass = new JLabel("Password");
		pass.setForeground(new Color(255, 255, 255));
		pass.setFont(new Font("Tahoma", Font.BOLD, 12));
		pass.setBounds(447, 191, 67, 14);
		contentPane.add(pass);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		textField_1.setColumns(10);
		textField_1.setBounds(447, 216, 262, 20);
		contentPane.add(textField_1);
		
		JButton loginButton = new JButton("Login");
		loginButton.setIcon(new ImageIcon(Login.class.getResource("/Images/login.png")));
		loginButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		loginButton.setBounds(447, 262, 262, 23);
		contentPane.add(loginButton);
		
		JButton closeButton = new JButton("Close");
		closeButton.setIcon(new ImageIcon(Login.class.getResource("/Images/close.png")));
		closeButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		closeButton.setBounds(447, 350, 262, 23);
		contentPane.add(closeButton);
		
		JLabel lblNewLabel_1 = new JLabel("Travel and Tour Management System");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(61, 11, 335, 69);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		// Load the original image icon
		ImageIcon originalIcon = new ImageIcon(Login.class.getResource("/Images/user.png"));

		// Resize the image to a new width and height (for example, 50x50)
		Image resizedImage = originalIcon.getImage().getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH);

		// Set the resized image as a new ImageIcon
		lblNewLabel.setIcon(new ImageIcon(resizedImage));

		lblNewLabel.setBounds(60, 114, 352, 259);
		contentPane.add(lblNewLabel);
		
		JButton loginButton_1 = new JButton("Registration");
		ImageIcon myIcon = new ImageIcon(Login.class.getResource("/Images/add.png"));

		// Resize the image to a new width and height (for example, 50x50)
		Image newImage = myIcon.getImage().getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);

		// Set the resized image as a new ImageIcon
		loginButton_1.setIcon(new ImageIcon(newImage));
		loginButton_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		loginButton_1.setBounds(447, 307, 262, 23);
		contentPane.add(loginButton_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(Login.class.getResource("/Images/NewBG.png")));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(-520, -277, 1280, 720);
		contentPane.add(lblNewLabel_2);
	}
}
