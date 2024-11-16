package pro;

import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Packeges extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JComboBox<String> locationDropdown;
    private JComboBox<String> packageDropdown;
    private JComboBox<String> hotelDropdown;
    private JLabel packageDetails;
    private JLabel hotelDetails;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTextField textField_4;
    private JLabel lblNewLabel_7;
    private String pack_name="";
    private String hot_name="";
    private double pack_price=0;
    private double hot_price=0;
    private JLabel description;
    private String des="";
    private double hRating=0;
    private JLabel hot_rating;
    private JLabel pack_priceText;
    private JLabel hot_priceText;
    private int pId=0,hId=0,conPid,conHid;
    private String loc="";
    private JLabel test;
    private JLabel lblNewLabel_2;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Packeges frame = new Packeges("");
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
    public Packeges(String userEmail) {
    	setBackground(new Color(255, 255, 255));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1181, 739);
        contentPane = new JPanel();
        setResizable(false); 
		 setLocationRelativeTo(null);
        contentPane.setBackground(new Color(3, 152, 158));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        

        
        locationDropdown = new JComboBox<>(new String[] {"Select Location"});
        locationDropdown.setFont(new Font("Tahoma", Font.BOLD, 12));
        locationDropdown.setBackground(new Color(255, 255, 255));
        locationDropdown.setForeground(new Color(0, 0, 0));
        locationDropdown.setBounds(501, 50, 200, 30);
        contentPane.add(locationDropdown);

        // Package Panel on the left
        JPanel packagePanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                // Cast Graphics to Graphics2D for better control
                Graphics2D g2d = (Graphics2D) g.create();

                // Enable anti-aliasing for smoother edges
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                // Define shadow properties
                int shadowSize = 8; // Size of the shadow
                Color shadowColor = new Color(0, 0, 0, 80); // Semi-transparent shadow color

                // Draw shadow (rectangle)
                g2d.setColor(shadowColor);
                g2d.fillRoundRect(shadowSize, shadowSize, getWidth() - shadowSize, getHeight() - shadowSize, 20, 20);

                g2d.dispose(); // Clean up graphics resources
            }
        };
        packagePanel.setBackground(new Color(0, 0, 0, 0)); 
        packagePanel.setBounds(21, 110, 500, 304);
       // packagePanel.setBorder(new LineBorder(Color.BLACK, 2));
        
        packagePanel.setLayout(null);
        contentPane.add(packagePanel);

        JLabel lblPackages = new JLabel("Available Packages");
        lblPackages.setForeground(new Color(255, 255, 255));
        lblPackages.setBackground(new Color(255, 255, 255));
        lblPackages.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblPackages.setBounds(20, 20, 200, 30);
        packagePanel.add(lblPackages);

        packageDropdown = new JComboBox<>(new String[] {"Select Package"});
        packageDropdown.setFont(new Font("Tahoma", Font.BOLD, 12));
        packageDropdown.setBounds(20, 70, 200, 30);
        packagePanel.add(packageDropdown);

        packageDetails = new JLabel("<html>Silver Package Maximum 5 Days<br>Gold Package Maximum 10 Days</html>");
        packageDetails.setFont(new Font("Tahoma", Font.BOLD, 12));
        packageDetails.setForeground(new Color(255, 255, 255));
        packageDetails.setVerticalAlignment(SwingConstants.TOP);
        packageDetails.setHorizontalAlignment(SwingConstants.LEFT);
        packageDetails.setBounds(33, 205, 243, 30);
        packagePanel.add(packageDetails);

        JButton btnSelectPackage = new JButton("Select Package");
        btnSelectPackage.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnSelectPackage.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		 if ("Select Location".equals(locationDropdown.getSelectedItem().toString())) {
             		
            		 JOptionPane.showMessageDialog(null, "Please select a valid location.", "Error", JOptionPane.ERROR_MESSAGE);
            		 }
        		 else{
        		textField.setText(pack_name);
        		conPid=pId;
        		loc=locationDropdown.getSelectedItem().toString();
        		//test.setText(""+conPid+loc+conHid);
        		 }
        	}
        });
        btnSelectPackage.setBounds(164, 260, 140, 30);
        packagePanel.add(btnSelectPackage);
        
        pack_priceText = new JLabel("Package Price:");
        pack_priceText.setFont(new Font("Tahoma", Font.BOLD, 12));
        pack_priceText.setForeground(new Color(255, 255, 255));
        pack_priceText.setBounds(33, 128, 187, 20);
        packagePanel.add(pack_priceText);
        
        description = new JLabel("Please select a location");
        description.setFont(new Font("Tahoma", Font.BOLD, 12));
        description.setForeground(new Color(255, 255, 255));
        description.setBounds(33, 159, 451, 20);
        packagePanel.add(description);
        
       
        
        	
        

        // Hotel Panel on the right
        JPanel hotelPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                // Cast Graphics to Graphics2D for better control
                Graphics2D g2d = (Graphics2D) g.create();

                // Enable anti-aliasing for smoother edges
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                // Define shadow properties
                int shadowSize = 8; // Size of the shadow
                Color shadowColor = new Color(0, 0, 0, 80); // Semi-transparent shadow color

                // Draw shadow (rectangle)
                g2d.setColor(shadowColor);
                g2d.fillRoundRect(shadowSize, shadowSize, getWidth() - shadowSize, getHeight() - shadowSize, 20, 20);

                g2d.dispose(); // Clean up graphics resources
            }
        };
        hotelPanel.setForeground(new Color(255, 255, 255));
        hotelPanel.setBackground(new Color(0, 0, 0, 0)); 
        hotelPanel.setBounds(651, 110, 500, 304);
        //hotelPanel.setBorder(new LineBorder(Color.BLACK, 2));
        hotelPanel.setLayout(null);
        contentPane.add(hotelPanel);
        

        JLabel lblHotels = new JLabel("Available Hotels");
        lblHotels.setForeground(new Color(255, 255, 255));
        lblHotels.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblHotels.setBounds(20, 20, 200, 30);
        hotelPanel.add(lblHotels);

        hotelDropdown = new JComboBox<>(new String[] {"Select Hotel"});
        hotelDropdown.setFont(new Font("Tahoma", Font.BOLD, 12));
        hotelDropdown.setBounds(20, 70, 200, 30);
        hotelPanel.add(hotelDropdown);

        hotelDetails = new JLabel("Price is for staying 1 Night and 1 Day");
        hotelDetails.setFont(new Font("Tahoma", Font.BOLD, 12));
        hotelDetails.setForeground(new Color(255, 255, 255));
        hotelDetails.setVerticalAlignment(SwingConstants.TOP);
        hotelDetails.setBounds(33, 205, 243, 30);
        hotelPanel.add(hotelDetails);

        JButton btnSelectHotel = new JButton("Select Hotel");
        btnSelectHotel.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnSelectHotel.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		 if ("Select Location".equals(locationDropdown.getSelectedItem().toString())) {
        		
        		 JOptionPane.showMessageDialog(null, "Please select a valid location.", "Error", JOptionPane.ERROR_MESSAGE);
        		 }
        		 else {
        			 textField_1.setText(hot_name);
        			 conHid=hId;
        			// test.setText(""+conPid+loc+conHid);
        		 }
        	}
        });
        btnSelectHotel.setBounds(164, 260, 140, 30);
        hotelPanel.add(btnSelectHotel);
        
        hot_priceText = new JLabel("Hotel Price:");
        hot_priceText.setForeground(new Color(255, 255, 255));
        hot_priceText.setFont(new Font("Tahoma", Font.BOLD, 12));
        hot_priceText.setBounds(33, 128, 187, 20);
        hotelPanel.add(hot_priceText);
        
        hot_rating = new JLabel("Please select a location");
        hot_rating.setFont(new Font("Tahoma", Font.BOLD, 12));
        hot_rating.setForeground(new Color(255, 255, 255));
        hot_rating.setBounds(33, 159, 451, 20);
        hotelPanel.add(hot_rating);
        
        JLabel lblPackagesAndHotels = new JLabel("Packages and Hotels");
        lblPackagesAndHotels.setHorizontalAlignment(SwingConstants.CENTER);
        lblPackagesAndHotels.setForeground(new Color(255, 255, 255));
        lblPackagesAndHotels.setFont(new Font("Verdana", Font.BOLD, 18));
        lblPackagesAndHotels.setBounds(462, 11, 262, 24);
        contentPane.add(lblPackagesAndHotels);
        
        JLabel lblNewLabel = new JLabel("Book Trip :");
        lblNewLabel.setForeground(new Color(255, 255, 0));
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblNewLabel.setBounds(42, 441, 117, 24);
        contentPane.add(lblNewLabel);
        
        JLabel lblNewLabel_1 = new JLabel("Selected Package :");
        lblNewLabel_1.setForeground(new Color(255, 255, 0));
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblNewLabel_1.setBounds(42, 479, 125, 14);
        contentPane.add(lblNewLabel_1);
        
        textField = new JTextField();
        textField.setFont(new Font("Tahoma", Font.BOLD, 12));
        textField.setColumns(10);
        textField.setBounds(169, 477, 262, 20);
        contentPane.add(textField);
        
        JLabel lblNewLabel_1_1 = new JLabel("Selected Hotel :");
        lblNewLabel_1_1.setForeground(new Color(255, 255, 0));
        lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblNewLabel_1_1.setBounds(526, 479, 125, 14);
        contentPane.add(lblNewLabel_1_1);
        
        textField_1 = new JTextField();
        textField_1.setFont(new Font("Tahoma", Font.BOLD, 12));
        textField_1.setColumns(10);
        textField_1.setBounds(653, 477, 262, 20);
        contentPane.add(textField_1);
        
        JLabel lblNewLabel_1_2 = new JLabel("Arrival Date :");
        lblNewLabel_1_2.setForeground(new Color(255, 255, 0));
        lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblNewLabel_1_2.setBounds(42, 521, 125, 14);
        contentPane.add(lblNewLabel_1_2);
        
        textField_2 = new JTextField();
        textField_2.setFont(new Font("Tahoma", Font.BOLD, 12));
        textField_2.setColumns(10);
        textField_2.setBounds(169, 519, 262, 20);
        contentPane.add(textField_2);
        
        JLabel lblNewLabel_1_3 = new JLabel("Leaving Date  :");
        lblNewLabel_1_3.setForeground(new Color(255, 255, 0));
        lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblNewLabel_1_3.setBounds(526, 517, 125, 14);
        contentPane.add(lblNewLabel_1_3);
        
        textField_3 = new JTextField();
        textField_3.setFont(new Font("Tahoma", Font.BOLD, 12));
        textField_3.setColumns(10);
        textField_3.setBounds(653, 515, 262, 20);
        contentPane.add(textField_3);
        
        JLabel lblNewLabel_1_4 = new JLabel("Total Person :");
        lblNewLabel_1_4.setForeground(new Color(255, 255, 0));
        lblNewLabel_1_4.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblNewLabel_1_4.setBounds(42, 562, 125, 14);
        contentPane.add(lblNewLabel_1_4);
        
        textField_4 = new JTextField();
        textField_4.setFont(new Font("Tahoma", Font.BOLD, 12));
        textField_4.setColumns(10);
        textField_4.setBounds(169, 560, 262, 20);
        contentPane.add(textField_4);
        
        lblNewLabel_7 = new JLabel("Total Amount : 0000");
        lblNewLabel_7.setForeground(new Color(255, 255, 0));
        lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNewLabel_7.setBounds(526, 554, 254, 29);
        contentPane.add(lblNewLabel_7);
        
        JButton btnAdd = new JButton("Pay");
        btnAdd.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		  if (textField.getText().trim().isEmpty() ||
          	            textField_1.getText().trim().isEmpty() ||
          	            textField_2.getText().trim().isEmpty() ||
          	            textField_3.getText().trim().isEmpty() ||
          	            textField_4.getText().trim().isEmpty()) {

          	            JOptionPane.showMessageDialog(null, "All fields must be filled!", "Validation Error", JOptionPane.ERROR_MESSAGE);
          	        }
        		  else {
        			  
        			 
        			  String v3 = textField_2.getText().trim();
        			  String v4 = textField_3.getText().trim();
        			

        			  
        			  
        			  int persons = Integer.parseInt(textField_4.getText());
        			  
        		        double totalAmount = (hot_price+pack_price) * persons;
        			  new Payment(userEmail,conPid, conHid,loc,v3, v4, persons,totalAmount).setVisible(true);
        			  dispose();
        		  }
        		
        	}
        });
        btnAdd.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnAdd.setBounds(446, 619, 74, 23);
        contentPane.add(btnAdd);
        
        JButton btnNewButton_1 = new JButton("Check price");
        btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnNewButton_1.setBounds(530, 619, 110, 23);
        contentPane.add(btnNewButton_1);
        
        JButton btnClose = new JButton("Close");
        btnClose.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		new HomePage(userEmail).setVisible(true);
        		dispose();
        	}
        });
        btnClose.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnClose.setBounds(650, 619, 74, 23);
        contentPane.add(btnClose);
        
        test = new JLabel("");
        test.setBounds(68, 624, 267, 39);
        contentPane.add(test);
        
        JLabel label = new JLabel("");
        label.setIcon(new ImageIcon(Packeges.class.getResource("/Images/Ocean.png")));
        label.setBounds(0, 0, 1184, 700);
        contentPane.add(label);
    	// Load the original image icon
		ImageIcon originalIcon = new ImageIcon(Login.class.getResource("/Images/sideBG.png"));

		// Resize the image to a new width and height (for example, 50x50)
		Image resizedImage = originalIcon.getImage().getScaledInstance(1200, 740, java.awt.Image.SCALE_SMOOTH);
        locationDropdown.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	if ("Select Location".equals(locationDropdown.getSelectedItem().toString())) {
            		 packageDropdown.removeAllItems(); 
            		 hotelDropdown.removeAllItems();
                    packageDropdown.addItem("Select Package");
                    hotelDropdown.addItem("Select Hotel");
                    pack_priceText.setText("Package Price: ");
                    hot_priceText.setText("Hotel Price: ");
                    description.setText("Please select a location");
                    hot_rating.setText("Please select a location");
                    
                    
                }
            	else {
                loadPackagesAndHotels();
            	}
                
                clearFields();
                
            }
        });

        packageDropdown.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updatePackageDetails();
                clearFields();
            }
        });

        hotelDropdown.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateHotelDetails();
                clearFields();
            }
        });

        btnNewButton_1.addActionListener(new ActionListener() { // Check price button
            public void actionPerformed(ActionEvent e) {
            	   if (textField.getText().trim().isEmpty() ||
            	            textField_1.getText().trim().isEmpty() ||
            	            textField_2.getText().trim().isEmpty() ||
            	            textField_3.getText().trim().isEmpty() ||
            	            textField_4.getText().trim().isEmpty()) {

            	            JOptionPane.showMessageDialog(null, "All fields must be filled!", "Validation Error", JOptionPane.ERROR_MESSAGE);
            	        }
            	else {
                calculateTotalAmount();
            	}
            }
        });
        
   
        
        loadLocations();

     
    }
    private void loadLocations() {
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT DISTINCT Location FROM Packages UNION SELECT DISTINCT Location FROM Hotels")) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                locationDropdown.addItem(rs.getString("Location"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void loadPackagesAndHotels() {
		
		 packageDropdown.removeAllItems(); 
		 hotelDropdown.removeAllItems();
		 
        String selectedLocation = (String) locationDropdown.getSelectedItem();

        try (Connection conn = DatabaseConnection.getConnection()) {
            // Load packages for the selected location
        	 PreparedStatement packageStmt = conn.prepareStatement("SELECT P_Name, P_Price,Description,P_ID FROM Packages WHERE Location = ?");
            packageStmt.setString(1, selectedLocation);
            ResultSet rsPackages = packageStmt.executeQuery();
            while (rsPackages.next()) {
            	pack_name=rsPackages.getString("P_Name");
            	pack_price = rsPackages.getDouble("P_Price");
            	des=rsPackages.getString("Description");
            	pId=rsPackages.getInt("P_ID");
                packageDropdown.addItem(pack_name);
                
            }
            rsPackages.close();

            // Load hotels for the selected location
            PreparedStatement hotelStmt = conn.prepareStatement("SELECT H_Name, H_Price,Rating,H_ID FROM Hotels WHERE Location = ?");
            hotelStmt.setString(1, selectedLocation);
            ResultSet rsHotels = hotelStmt.executeQuery();
            while (rsHotels.next()) {
            	hot_name=rsHotels.getString("H_Name");
            	hot_price = rsHotels.getDouble("H_Price");
            	hRating=rsHotels.getDouble("Rating");
            	hId=rsHotels.getInt("H_ID");
                hotelDropdown.addItem(hot_name);
            }
            rsHotels.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void updatePackageDetails() {
        String selectedPackage = (String) packageDropdown.getSelectedItem();
        if (selectedPackage != null) {
        	
        	 description.setText(des);
        	 pack_priceText.setText("Package Price: "+pack_price); 
        }
    }

    private void updateHotelDetails() {
        String selectedHotel = (String) hotelDropdown.getSelectedItem();
        if (selectedHotel != null) {
            hot_rating.setText("Hotel Rating : "+hRating);
            hot_priceText.setText("Hotel Price: "+hot_price); 
        }
    }

    private void calculateTotalAmount() {
        int persons = Integer.parseInt(textField_4.getText());
  
        double totalAmount = (hot_price+pack_price) * persons;
        lblNewLabel_7.setText("Total Amount : " + totalAmount);
    }
    private void clearFields() {
        textField.setText("");
        textField_1.setText("");
        textField_2.setText("");
        textField_3.setText("");
        textField_4.setText("");
        loc="";
        conPid=0;
        conHid=0;
    }
}
