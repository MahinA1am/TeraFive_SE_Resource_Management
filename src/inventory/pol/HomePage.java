package pol;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
					HomePage frame = new HomePage();
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
	public HomePage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 869, 573);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("User");
		btnNewButton.setIcon(new ImageIcon(HomePage.class.getResource("/Images/Users.png")));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBounds(10, 29, 107, 40);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Category");
		btnNewButton_1.setIcon(new ImageIcon(HomePage.class.getResource("/Images/category.png")));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_1.setBounds(127, 29, 107, 40);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Product");
		btnNewButton_2.setIcon(new ImageIcon(HomePage.class.getResource("/Images/product.png")));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_2.setBounds(244, 29, 111, 40);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Customer");
		btnNewButton_3.setIcon(new ImageIcon(HomePage.class.getResource("/Images/customers.png")));
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_3.setBounds(365, 29, 107, 40);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Order");
		btnNewButton_4.setIcon(new ImageIcon(HomePage.class.getResource("/Images/Orders.png")));
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_4.setBounds(482, 29, 107, 40);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("View Order");
		btnNewButton_5.setIcon(new ImageIcon(HomePage.class.getResource("/Images/View-orders.png")));
		btnNewButton_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_5.setBounds(599, 29, 117, 40);
		contentPane.add(btnNewButton_5);
		
		JButton btnNewButton_5_1 = new JButton("Logout");
		btnNewButton_5_1.setIcon(new ImageIcon(HomePage.class.getResource("/Images/Exit.png")));
		btnNewButton_5_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_5_1.setBounds(726, 29, 117, 40);
		contentPane.add(btnNewButton_5_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(HomePage.class.getResource("/Images/bg.png")));
		lblNewLabel.setBounds(0, 0, 853, 534);
		contentPane.add(lblNewLabel);
	}
}
