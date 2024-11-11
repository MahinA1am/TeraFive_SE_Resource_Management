package pro;

import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;

public class Payment extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField txtAmount, txtName, txtAddress, txtCardNumber, txtExpiry, txtCVV, txtPromoCode;
    private JLabel lblSummary, lblDiscountedAmount;
    private JCheckBox chkPaidStatus;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Payment frame = new Payment();
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
    public Payment() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 900, 700);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(153, 170, 187));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

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

        txtAmount = new JTextField();
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

        txtName = new JTextField();
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
        btnClose.setFont(new Font("Tahoma", Font.BOLD, 16));
        btnClose.setBounds(774, 611, 100, 30);
        contentPane.add(btnClose);

        // Promo Code Button ActionListener
        btnApplyPromo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String promoCode = txtPromoCode.getText();
                String amountText = txtAmount.getText();
                if (!promoCode.isEmpty() && !amountText.isEmpty()) {
                    double amount = Double.parseDouble(amountText);
                    double discount = 0.10;  // Example 10% discount
                    double discountedAmount = amount - (amount * discount);
                    lblDiscountedAmount.setText("Discounted Amount: $" + discountedAmount);
                }
            }
        });

        // Pay Button ActionListener
        btnPay.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selectedPaymentMethod = (String) paymentMethodDropdown.getSelectedItem();
                if ("Credit Card".equals(selectedPaymentMethod) || "Debit Card".equals(selectedPaymentMethod)) {
                    if (txtCardNumber.getText().isEmpty() || txtExpiry.getText().isEmpty() || txtCVV.getText().isEmpty()) {
                        lblSummary.setText("Please fill in all card details.");
                        return;
                    }
                }
                lblSummary.setText("Payment successful!");
                chkPaidStatus.setSelected(true);
                chkPaidStatus.setEnabled(true);
            }
        });

        // Show/Hide Card Details based on Payment Method
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
    }
}
