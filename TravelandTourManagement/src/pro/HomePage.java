package pro;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import java.awt.Font;
import java.awt.Color;

public class HomePage extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomePage frame = new HomePage("");
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
	public HomePage(String userType) {
		int a;
		a=userType.equals("admin@gmail.com") ? 1 : 2;
		
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 800);
		contentPane = new JPanel();
		setResizable(false); 
		setLocationRelativeTo(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Profile");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Profile(userType).setVisible(true);
				dispose();
			}
		});
		btnNewButton.setIcon(new ImageIcon(HomePage.class.getResource("/Images/Profile.png")));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBounds(389, 27, 126, 44);
		contentPane.add(btnNewButton);
		
		// GIF image
		ImageIcon backgroundGif = new ImageIcon(HomePage.class.getResource("/Images/HomePageBG.gif"));
		
		JButton btnNewButton_1 = new JButton("Packages");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Packeges(userType).setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(HomePage.class.getResource("/Images/packages.png")));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_1.setBounds(572, 27, 126, 44);
		contentPane.add(btnNewButton_1);
		if(a==2) {
		JButton btnNewButton_2 = new JButton("My Packages");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MyPackage(userType).setVisible(true);
				dispose();
			}
		});
		btnNewButton_2.setIcon(new ImageIcon(HomePage.class.getResource("/Images/Mypackages.png")));
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_2.setBounds(753, 27, 144, 44);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Payment");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Payment(userType,0,0,"None","","",0,0.0).setVisible(true);
				dispose();
			}
		});
		btnNewButton_3.setIcon(new ImageIcon(HomePage.class.getResource("/Images/Money.png")));
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_3.setBounds(948, 27, 126, 44);
		contentPane.add(btnNewButton_3);
		}
		
		JButton btnNewButton_4 = new JButton("Logout");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int choice = JOptionPane.showConfirmDialog(HomePage.this, "Do you want to log out?", 
					    "Log Out", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

					if (choice == JOptionPane.YES_OPTION) {
				new Login().setVisible(true);
				dispose();
					}
			}
		});
		btnNewButton_4.setIcon(new ImageIcon(HomePage.class.getResource("/Images/Exit.png")));
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_4.setBounds(1119, 27, 126, 44);
		contentPane.add(btnNewButton_4);
		
		
		JLabel lblNewLabel_1 = new JLabel("<html>Explore the World with Ease –<br>Your Journey Starts Here!</html>");
		lblNewLabel_1.setForeground(new Color(0, 0, 0));;
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(72, 20, 279, 73);
		contentPane.add(lblNewLabel_1);
		
		if(a==1) {
		
		JButton btnNewButton_2_1 = new JButton("Manage Packs");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ManagePack(userType).setVisible(true);
				dispose();
			}
		});
		
		btnNewButton_2_1.setIcon(new ImageIcon(HomePage.class.getResource("/Images/Mypackages.png")));
		btnNewButton_2_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_2_1.setBounds(747, 27, 163, 44);
		contentPane.add(btnNewButton_2_1);
		
		JButton btnNewButton_3_1 = new JButton("View Info");
		btnNewButton_3_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ViewDetails(userType).setVisible(true);
				dispose();
			}
		});
		btnNewButton_3_1.setIcon(new ImageIcon(HomePage.class.getResource("/Images/View-orders.png")));
		btnNewButton_3_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_3_1.setBounds(948, 27, 145, 44);
		contentPane.add(btnNewButton_3_1);
		}
		
		// Set the GIF as a JLabel background
		JLabel lblNewLabel = new JLabel(backgroundGif);
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setBounds(0, 0, 1280, 800);
		contentPane.add(lblNewLabel);

		// Timer to stop GIF after one loop (set delay based on GIF duration)
		int gifDuration = 5000; // Set this to the GIF's duration in milliseconds (e.g., 5 seconds)
		Timer timer = new Timer(gifDuration, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				backgroundGif.getImage().flush(); // Stops GIF playback
				((Timer)e.getSource()).stop(); // Stops the timer
			}
		});
		timer.setRepeats(false); // Only execute once
		timer.start();
	}
}
