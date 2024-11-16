package pro;

import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.Color;

public class Payment extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField txtAmount, txtName, txtAddress, txtCardNumber, txtExpiry, txtCVV, txtPromoCode;
    private JLabel lblSummary, lblDiscountedAmount;
    private JCheckBox chkPaidStatus;
    private String userName,mobNo,country,address;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Payment frame = new Payment("",0,0,"","","",0,0.0);
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
    public Payment(String userEmail,int pId, int hId,String location, String v3, String v4, int persons,double totalAmount) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 900, 700);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(153, 170, 187));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        loadUser(userEmail);

        // Payment Method Selection
        JLabel lblPaymentMethod = new JLabel("Select Payment Method:");
        lblPaymentMethod.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblPaymentMethod.setBounds(50, 50, 200, 30);
        contentPane.add(lblPaymentMethod);

        JComboBox<String> paymentMethodDropdown = new JComboBox<>(new String[] {"Select Payment Method", "Credit Card", "Debit Card", "PayPal", "Bank Transfer"});
        paymentMethodDropdown.setBounds(250, 50, 200, 30);
        contentPane.add(paymentMethodDropdown);

        // Amount Field
        JLabel lblAmount = new JLabel("Amount:");
        lblAmount.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblAmount.setBounds(50, 100, 100, 30);
        contentPane.add(lblAmount);

        txtAmount = new JTextField(""+totalAmount);
        txtAmount.setBounds(250, 100, 200, 30);
        contentPane.add(txtAmount);

        // Promo Code Field
        JLabel lblPromoCode = new JLabel("Promo Code:");
        lblPromoCode.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblPromoCode.setBounds(50, 150, 100, 30);
        contentPane.add(lblPromoCode);

        txtPromoCode = new JTextField();
        txtPromoCode.setBounds(250, 150, 200, 30);
        contentPane.add(txtPromoCode);

        JButton btnApplyPromo = new JButton("Apply");
        btnApplyPromo.setBounds(460, 150, 100, 30);
        contentPane.add(btnApplyPromo);

        lblDiscountedAmount = new JLabel("");  // Will display discounted total if promo is applied
        lblDiscountedAmount.setFont(new Font("Tahoma", Font.ITALIC, 14));
        lblDiscountedAmount.setBounds(50, 190, 300, 30);
        contentPane.add(lblDiscountedAmount);

        // Billing Information
        JLabel lblBillingInfo = new JLabel("Billing Information:");
        lblBillingInfo.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblBillingInfo.setBounds(50, 230, 200, 30);
        contentPane.add(lblBillingInfo);

        JLabel lblName = new JLabel("Name:");
        lblName.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblName.setBounds(50, 270, 100, 30);
        contentPane.add(lblName);

        txtName = new JTextField(userName);
        txtName.setBounds(250, 270, 200, 30);
        contentPane.add(txtName);

        JLabel lblAddress = new JLabel("Billing Address:");
        lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblAddress.setBounds(50, 310, 120, 30);
        contentPane.add(lblAddress);

        txtAddress = new JTextField();
        txtAddress.setBounds(250, 310, 400, 30);
        contentPane.add(txtAddress);

        // Card Details (shown if Credit/Debit Card is selected)
        JLabel lblCardNumber = new JLabel("Card Number:");
        lblCardNumber.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblCardNumber.setBounds(50, 360, 120, 30);
        contentPane.add(lblCardNumber);

        txtCardNumber = new JTextField();
        txtCardNumber.setBounds(250, 360, 200, 30);
        contentPane.add(txtCardNumber);

        JLabel lblExpiry = new JLabel("Expiry Date (MM/YY):");
        lblExpiry.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblExpiry.setBounds(50, 400, 150, 30);
        contentPane.add(lblExpiry);

        txtExpiry = new JTextField();
        txtExpiry.setBounds(250, 400, 100, 30);
        contentPane.add(txtExpiry);

        JLabel lblCVV = new JLabel("CVV:");
        lblCVV.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblCVV.setBounds(50, 440, 50, 30);
        contentPane.add(lblCVV);

        txtCVV = new JTextField();
        txtCVV.setBounds(250, 440, 100, 30);
        contentPane.add(txtCVV);

        // Paid Status Checkbox
        chkPaidStatus = new JCheckBox("Paid");
        chkPaidStatus.setFont(new Font("Tahoma", Font.PLAIN, 16));
        chkPaidStatus.setBounds(50, 490, 100, 30);
        chkPaidStatus.setEnabled(false); // Initially disabled, updates after payment
        contentPane.add(chkPaidStatus);

        // Pay Button
        JButton btnPay = new JButton("Pay");
        btnPay.setFont(new Font("Tahoma", Font.BOLD, 16));
        btnPay.setBounds(50, 530, 100, 30);
        contentPane.add(btnPay);

        // Transaction Summary Label
        lblSummary = new JLabel("");
        lblSummary.setFont(new Font("Tahoma", Font.ITALIC, 14));
        lblSummary.setBounds(50, 570, 800, 30);
        contentPane.add(lblSummary);
        
        JLabel lblPayment = new JLabel("Payment");
        lblPayment.setHorizontalAlignment(SwingConstants.CENTER);
        lblPayment.setForeground(Color.BLACK);
        lblPayment.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblPayment.setBounds(310, 11, 262, 24);
        contentPane.add(lblPayment);
        
        JButton btnClose = new JButton("Close");
        btnClose.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		new HomePage(userEmail).setVisible(true);
        		dispose();
        	}
        });
        btnClose.setFont(new Font("Tahoma", Font.BOLD, 16));
        btnClose.setBounds(774, 611, 100, 30);
        contentPane.add(btnClose);

      
        btnApplyPromo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String promoCode = txtPromoCode.getText();
                String amountText = txtAmount.getText();
                if (!amountText.isEmpty() && promoCode.equals("h") ) {
                    double amount = Double.parseDouble(amountText);
                    double discount = 0.10;  // Example 10% discount
                    double discountedAmount = amount - (amount * discount);
                    txtAmount.setText(""+discountedAmount);
                    lblDiscountedAmount.setText("Discounted Amount: $" + discountedAmount);
                }
                else {
                	 JOptionPane.showMessageDialog(null, "Invalid Value.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Pay Button ActionListener
        btnPay.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selectedPaymentMethod = (String) paymentMethodDropdown.getSelectedItem();
                if ("Select Payment Method".equals(selectedPaymentMethod)) {
                	JOptionPane.showMessageDialog(null, "Select a Payment Method.", "Error", JOptionPane.ERROR_MESSAGE);
                	return;
                }
                if(txtAddress.getText().isEmpty()) {
                	JOptionPane.showMessageDialog(null, "Invalid Value.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                
                if ("Credit Card".equals(selectedPaymentMethod) || "Debit Card".equals(selectedPaymentMethod)) {
                    if (txtCardNumber.getText().isEmpty() || txtExpiry.getText().isEmpty() || txtCVV.getText().isEmpty()) {
                    	JOptionPane.showMessageDialog(null, "Invalid Value.", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                }
                lblSummary.setText("Payment successful!");
                chkPaidStatus.setSelected(true);
                String sql = "INSERT INTO book_details (User_name, P_ID, H_ID, Total_Price, Mobile_Number, Email, " +
                        "Country, Address, Total_Person, Location, Arrival_Date, Leaving_Date) " +
                        "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

                try (Connection conn = DatabaseConnection.getConnection()) {
                    
                	 PreparedStatement preparedStatement = conn.prepareStatement(sql);
                	 
                  
                
               
             
               preparedStatement.setString(1, userName);
               preparedStatement.setInt(2, pId);
               preparedStatement.setInt(3, hId);
               preparedStatement.setDouble(4, totalAmount);
               preparedStatement.setString(5, mobNo);
               preparedStatement.setString(6, userEmail);
               preparedStatement.setString(7, country);
               preparedStatement.setString(8, address);
               preparedStatement.setInt(9, persons);
               preparedStatement.setString(10, location);
               preparedStatement.setString(11, v3);
               preparedStatement.setString(12, v4);
               
               // Execute the query
               int rowsInserted = preparedStatement.executeUpdate();
               if (rowsInserted > 0) {
                   System.out.println("Data successfully inserted into book_details.");
               } else {
                   System.out.println("Failed to insert data into book_details.");
               }
           } catch (SQLException ex) {
              
               ex.printStackTrace();
           }
            }
                });
              
        
       
        paymentMethodDropdown.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selectedMethod = (String) paymentMethodDropdown.getSelectedItem();
                boolean showCardDetails = "Credit Card".equals(selectedMethod) || "Debit Card".equals(selectedMethod);
                lblCardNumber.setVisible(showCardDetails);
                txtCardNumber.setVisible(showCardDetails);
                lblExpiry.setVisible(showCardDetails);
                txtExpiry.setVisible(showCardDetails);
                lblCVV.setVisible(showCardDetails);
                txtCVV.setVisible(showCardDetails);
            }
        });
        
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                // Ensure location is checked properly
                if ("None".equals(location)) {
                    // Pass the actual JFrame component instead of 'this'
                    JOptionPane.showMessageDialog(e.getWindow(), "First select Package and Hotel for specific Location ",
                            "Select Package and Hotel", JOptionPane.INFORMATION_MESSAGE);
                    new HomePage(userEmail).setVisible(true);
                    dispose();
                }
            }
        });


          
            	
       
        
    }
    private void loadUser(String userEmail)  {
    	 try (Connection connection = DatabaseConnection.getConnection()) {
	            String query = "SELECT name, phone, country, address FROM users WHERE email = ?";
	            try (PreparedStatement statement = connection.prepareStatement(query)) {
	                statement.setString(1, userEmail);
	                ResultSet resultSet = statement.executeQuery();

	                if (resultSet.next()) {
	                   
	                    userName=resultSet.getString("name");
	                    mobNo=resultSet.getString("phone");
	                
	                    country=resultSet.getString("country");
	                    address=resultSet.getString("address");
	                }
	            }
	            catch (SQLException e) {
	                e.printStackTrace();
	            }
    	 
    }
    	 catch (SQLException e) {
             e.printStackTrace();
         }
    }
}

