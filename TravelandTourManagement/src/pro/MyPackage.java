package pro;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class MyPackage extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyPackage frame = new MyPackage();
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
	public MyPackage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 865, 569);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(153, 170, 187));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMyPackage = new JLabel("My Package");
		lblMyPackage.setHorizontalAlignment(SwingConstants.CENTER);
		lblMyPackage.setForeground(Color.BLACK);
		lblMyPackage.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblMyPackage.setBounds(48, 11, 262, 24);
		contentPane.add(lblMyPackage);
		
		JLabel lblNewLabel = new JLabel("UserName :");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(77, 90, 83, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Your Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(203, 90, 220, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblLocation = new JLabel("Location :");
		lblLocation.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblLocation.setBounds(77, 128, 83, 14);
		contentPane.add(lblLocation);
		
		JLabel lblNewLabel_1_1 = new JLabel("Dubai");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_1.setBounds(203, 128, 220, 14);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblPackage = new JLabel("Package :");
		lblPackage.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPackage.setBounds(77, 172, 83, 14);
		contentPane.add(lblPackage);
		
		JLabel lblNewLabel_1_2 = new JLabel("Silver Package");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_2.setBounds(203, 172, 220, 14);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblHotel = new JLabel("Hotel :");
		lblHotel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblHotel.setBounds(77, 213, 83, 14);
		contentPane.add(lblHotel);
		
		JLabel lblNewLabel_1_3 = new JLabel("Hotel X");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_3.setBounds(203, 213, 220, 14);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblArrival = new JLabel("Arrival :");
		lblArrival.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblArrival.setBounds(77, 258, 83, 14);
		contentPane.add(lblArrival);
		
		JLabel lblNewLabel_1_4 = new JLabel("11/10/24");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_4.setBounds(203, 258, 220, 14);
		contentPane.add(lblNewLabel_1_4);
		
		JLabel lblLeaving = new JLabel("Leaving :");
		lblLeaving.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblLeaving.setBounds(77, 309, 83, 14);
		contentPane.add(lblLeaving);
		
		JLabel lblNewLabel_1_5 = new JLabel("15/10/24");
		lblNewLabel_1_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_5.setBounds(203, 309, 220, 14);
		contentPane.add(lblNewLabel_1_5);
		
		JLabel lblTotalPerson = new JLabel("Total Person :");
		lblTotalPerson.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTotalPerson.setBounds(77, 356, 94, 14);
		contentPane.add(lblTotalPerson);
		
		JLabel lblNewLabel_1_6 = new JLabel("2");
		lblNewLabel_1_6.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_6.setBounds(203, 356, 220, 14);
		contentPane.add(lblNewLabel_1_6);
		
		JLabel lblPrice = new JLabel("Price :");
		lblPrice.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPrice.setBounds(77, 409, 83, 14);
		contentPane.add(lblPrice);
		
		JLabel lblNewLabel_1_7 = new JLabel("24000 BDT");
		lblNewLabel_1_7.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_7.setBounds(203, 409, 220, 14);
		contentPane.add(lblNewLabel_1_7);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(MyPackage.class.getResource("/Images/bookpackage.jpg")));
		lblNewLabel_2.setBounds(320, 0, 529, 530);
		contentPane.add(lblNewLabel_2);
	}

}
