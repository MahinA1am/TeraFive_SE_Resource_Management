package pol;

import java.awt.EventQueue;
import javax.swing.JOptionPane;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel myFrame;
	private JTextField emailText;
	private JTextField passText;

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
		/* setLocationRelativeTo(null); */
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 831, 542);
		myFrame = new JPanel();
		myFrame.setBorder(new EmptyBorder(5, 5, 5, 5));
		/* setResizable(false); */ 
		 setLocationRelativeTo(null);
		setContentPane(myFrame);
		myFrame.setLayout(null);
		
		JLabel welcome = new JLabel("Wecome");
		welcome.setHorizontalAlignment(SwingConstants.CENTER);
		welcome.setFont(new Font("Tahoma", Font.BOLD, 14));
		welcome.setBounds(609, 96, 107, 24);
		myFrame.add(welcome);
		
		JLabel email = new JLabel("Email");
		email.setFont(new Font("Tahoma", Font.BOLD, 12));
		email.setBounds(523, 136, 46, 14);
		myFrame.add(email);
		
		emailText = new JTextField();
		emailText.setFont(new Font("Tahoma", Font.BOLD, 12));
		emailText.setBounds(523, 161, 262, 20);
		myFrame.add(emailText);
		emailText.setColumns(10);
		
		JLabel pass = new JLabel("Password");
		pass.setFont(new Font("Tahoma", Font.BOLD, 12));
		pass.setBounds(523, 204, 67, 14);
		myFrame.add(pass);
		
		passText = new JTextField();
		passText.setFont(new Font("Tahoma", Font.BOLD, 12));
		passText.setBounds(523, 229, 262, 20);
		myFrame.add(passText);
		passText.setColumns(10);
		
		JButton loginButton = new JButton("Login");
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				   HomePage homeFrame = new HomePage();
	                homeFrame.setVisible(true);
	                dispose();
			}
		});
		loginButton.setIcon(new ImageIcon(Login.class.getResource("/Images/login.png")));
		loginButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		loginButton.setBounds(523, 275, 262, 23);
		myFrame.add(loginButton);
		
		JButton closeButton = new JButton("Close");
		closeButton.setIcon(new ImageIcon(Login.class.getResource("/Images/close.png")));
		closeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int a= JOptionPane.showConfirmDialog(null,"Do You Want To Close The Application","Select",JOptionPane.YES_NO_OPTION);
				
				if(a==0) {
					System.exit(0);
				}
			}
		});
		closeButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		closeButton.setBounds(523, 325, 262, 23);
		myFrame.add(closeButton);
		
		JLabel lblNewLabel_1 = new JLabel("Inventory Management System");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(91, 193, 262, 69);
		myFrame.add(lblNewLabel_1);
		
		JLabel bgImage = new JLabel("");
		bgImage.setHorizontalAlignment(SwingConstants.CENTER);
		bgImage.setIcon(new ImageIcon("C:\\Users\\User\\eclipse-workspace\\InventoryManagementSystem\\src\\Images\\3274764.jpg"));
		bgImage.setBounds(0, 0, 3000, 2000);
		myFrame.add(bgImage);
	}
}
