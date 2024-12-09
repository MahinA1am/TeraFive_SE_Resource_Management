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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;

public class MyPackage extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	 private JLabel lblUserName, lblLocation, lblPackage, lblHotel, lblArrival, lblLeaving, lblTotalPerson, lblPrice;
	 private String hID,pID;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyPackage frame = new MyPackage("fipranto9001@gmail.com");
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
	public MyPackage(String userEmail) {
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setBounds(100, 100, 865, 569);
        contentPane = new JPanel();
        setResizable(false); 
		 setLocationRelativeTo(null);
        contentPane.setBackground(new Color(153, 170, 187));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblMyPackage = new JLabel("My Package");
        lblMyPackage.setHorizontalAlignment(SwingConstants.CENTER);
        lblMyPackage.setForeground(new Color(255, 255, 255));
        lblMyPackage.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblMyPackage.setBounds(283, 11, 262, 24);
        contentPane.add(lblMyPackage);

        JLabel lblNewLabel = new JLabel("UserName :");
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblNewLabel.setBounds(77, 90, 83, 14);
        contentPane.add(lblNewLabel);

        lblUserName = new JLabel("Your Name");
        lblUserName.setForeground(new Color(255, 255, 255));
        lblUserName.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblUserName.setBounds(203, 90, 220, 14);
        contentPane.add(lblUserName);

        JLabel lblLocationLabel = new JLabel("Location :");
        lblLocationLabel.setForeground(new Color(255, 255, 255));
        lblLocationLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblLocationLabel.setBounds(77, 128, 83, 14);
        contentPane.add(lblLocationLabel);

        lblLocation = new JLabel("Location");
        lblLocation.setForeground(new Color(255, 255, 255));
        lblLocation.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblLocation.setBounds(203, 128, 220, 14);
        contentPane.add(lblLocation);

        JLabel lblPackageLabel = new JLabel("Package :");
        lblPackageLabel.setForeground(new Color(255, 255, 255));
        lblPackageLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblPackageLabel.setBounds(77, 172, 83, 14);
        contentPane.add(lblPackageLabel);

        lblPackage = new JLabel("Package");
        lblPackage.setForeground(new Color(255, 255, 255));
        lblPackage.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblPackage.setBounds(203, 172, 220, 14);
        contentPane.add(lblPackage);

        JLabel lblHotelLabel = new JLabel("Hotel :");
        lblHotelLabel.setForeground(new Color(255, 255, 255));
        lblHotelLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblHotelLabel.setBounds(77, 213, 83, 14);
        contentPane.add(lblHotelLabel);

        lblHotel = new JLabel("Hotel");
        lblHotel.setForeground(new Color(255, 255, 255));
        lblHotel.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblHotel.setBounds(203, 213, 220, 14);
        contentPane.add(lblHotel);

        JLabel lblArrivalLabel = new JLabel("Arrival :");
        lblArrivalLabel.setForeground(new Color(255, 255, 255));
        lblArrivalLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblArrivalLabel.setBounds(77, 258, 83, 14);
        contentPane.add(lblArrivalLabel);

        lblArrival = new JLabel("Arrival");
        lblArrival.setForeground(new Color(255, 255, 255));
        lblArrival.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblArrival.setBounds(203, 258, 220, 14);
        contentPane.add(lblArrival);

        JLabel lblLeavingLabel = new JLabel("Leaving :");
        lblLeavingLabel.setForeground(new Color(255, 255, 255));
        lblLeavingLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblLeavingLabel.setBounds(77, 309, 83, 14);
        contentPane.add(lblLeavingLabel);

        lblLeaving = new JLabel("Leaving");
        lblLeaving.setForeground(new Color(255, 255, 255));
        lblLeaving.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblLeaving.setBounds(203, 309, 220, 14);
        contentPane.add(lblLeaving);

        JLabel lblTotalPersonLabel = new JLabel("Total Person :");
        lblTotalPersonLabel.setForeground(new Color(255, 255, 255));
        lblTotalPersonLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblTotalPersonLabel.setBounds(77, 356, 94, 14);
        contentPane.add(lblTotalPersonLabel);

        lblTotalPerson = new JLabel("Total Person");
        lblTotalPerson.setForeground(new Color(255, 255, 255));
        lblTotalPerson.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblTotalPerson.setBounds(203, 356, 220, 14);
        contentPane.add(lblTotalPerson);

        JLabel lblPriceLabel = new JLabel("Price :");
        lblPriceLabel.setForeground(new Color(255, 255, 255));
        lblPriceLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblPriceLabel.setBounds(77, 409, 83, 14);
        contentPane.add(lblPriceLabel);

        lblPrice = new JLabel("Price");
        lblPrice.setForeground(new Color(255, 255, 255));
        lblPrice.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblPrice.setBounds(203, 409, 220, 14);
        contentPane.add(lblPrice);
        
        JButton btnClose = new JButton("Close");
        btnClose.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		new HomePage(userEmail).setVisible(true);
        		dispose();
        	}
        });
        btnClose.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnClose.setBounds(765, 496, 74, 23);
        contentPane.add(btnClose);
        
                JLabel lblImage = new JLabel("");
                lblImage.setForeground(new Color(255, 255, 255));
                lblImage.setIcon(new ImageIcon(MyPackage.class.getResource("/Images/testBG.png")));
                lblImage.setBounds(-124, -136, 1093, 721);
                contentPane.add(lblImage);

        // Load booking details
        loadBookingDetails(userEmail);
        loadPackagesAndHotels();   
        
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
            	new HomePage(userEmail).setVisible(true);
        		dispose();
               
            }
        });
        }

    private void loadBookingDetails(String userEmail) {
        String query = "SELECT * FROM book_details WHERE Email = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, userEmail);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                lblUserName.setText(resultSet.getString("User_name"));
                lblLocation.setText(resultSet.getString("Location"));
                //lblPackage.setText(resultSet.getString("P_ID"));  
                //lblHotel.setText(resultSet.getString("H_ID")); 
                pID=resultSet.getString("P_ID");
                hID=resultSet.getString("H_ID");

                lblArrival.setText(resultSet.getDate("Arrival_Date").toString());
                lblLeaving.setText(resultSet.getDate("Leaving_Date").toString());
                lblTotalPerson.setText(String.valueOf(resultSet.getInt("Total_Person")));
                lblPrice.setText(resultSet.getDouble("Total_Price") + " BDT");
            } else {
                JOptionPane.showMessageDialog(this, "No booking details found for user: " +userEmail,
                        "No Data", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error loading booking details: " + e.getMessage(),
                    "Database Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
    private void loadPackagesAndHotels() {
		
		
		 
     

       try (Connection conn = DatabaseConnection.getConnection()) {
           // Load packages for the selected location
       	 PreparedStatement packageStmt = conn.prepareStatement("SELECT P_Name FROM Packages WHERE P_ID = ?");
           packageStmt.setString(1,pID );
           ResultSet rsPackages = packageStmt.executeQuery();
           while (rsPackages.next()) {
        	   lblPackage.setText(rsPackages.getString("P_Name"));
           
               
           }
           rsPackages.close();

           // Load hotels for the selected location
           PreparedStatement hotelStmt = conn.prepareStatement("SELECT H_Name FROM Hotels WHERE H_ID= ?");
           hotelStmt.setString(1, hID);
           ResultSet rsHotels = hotelStmt.executeQuery();
           while (rsHotels.next()) {
        	   lblHotel.setText(rsHotels.getString("H_Name"));
           
               
           }
           rsHotels.close();
       } catch (SQLException e) {
           e.printStackTrace();
       }
   }
}
