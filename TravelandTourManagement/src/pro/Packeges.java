package pro;

import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Packeges frame = new Packeges();
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
    public Packeges() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1200, 739);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(237, 237, 237));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Location selection dropdown at the top center
        locationDropdown = new JComboBox<>(new String[] {"Select Location", "Dubai", "Paris"});
        locationDropdown.setBounds(501, 50, 200, 30);
        contentPane.add(locationDropdown);

        // Package Panel on the left
        JPanel packagePanel = new JPanel();
        packagePanel.setBounds(21, 110, 500, 304);
        packagePanel.setBackground(Color.WHITE);
        packagePanel.setLayout(null);
        contentPane.add(packagePanel);

        JLabel lblPackages = new JLabel("Available Packages");
        lblPackages.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblPackages.setBounds(20, 20, 200, 30);
        packagePanel.add(lblPackages);

        packageDropdown = new JComboBox<>(new String[] {"Select Package"});
        packageDropdown.setBounds(20, 70, 200, 30);
        packagePanel.add(packageDropdown);

        packageDetails = new JLabel("Please select a location");
        packageDetails.setBounds(20, 120, 200, 100);
        packagePanel.add(packageDetails);

        JButton btnSelectPackage = new JButton("Select Package");
        btnSelectPackage.setBounds(164, 260, 140, 30);
        packagePanel.add(btnSelectPackage);

        // Hotel Panel on the right
        JPanel hotelPanel = new JPanel();
        hotelPanel.setBounds(651, 110, 500, 304);
        hotelPanel.setBackground(Color.WHITE);
        hotelPanel.setLayout(null);
        contentPane.add(hotelPanel);

        JLabel lblHotels = new JLabel("Available Hotels");
        lblHotels.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblHotels.setBounds(20, 20, 200, 30);
        hotelPanel.add(lblHotels);

        hotelDropdown = new JComboBox<>(new String[] {"Select Hotel"});
        hotelDropdown.setBounds(20, 70, 200, 30);
        hotelPanel.add(hotelDropdown);

        hotelDetails = new JLabel("Please select a location");
        hotelDetails.setBounds(20, 120, 200, 100);
        hotelPanel.add(hotelDetails);

        JButton btnSelectHotel = new JButton("Select Hotel");
        btnSelectHotel.setBounds(164, 260, 140, 30);
        hotelPanel.add(btnSelectHotel);
        
        JLabel lblPackagesAndHotels = new JLabel("Packages and Hotels");
        lblPackagesAndHotels.setHorizontalAlignment(SwingConstants.CENTER);
        lblPackagesAndHotels.setForeground(new Color(0, 0, 0));
        lblPackagesAndHotels.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblPackagesAndHotels.setBounds(462, 11, 262, 24);
        contentPane.add(lblPackagesAndHotels);
        
        JLabel lblNewLabel = new JLabel("Book Trip :");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblNewLabel.setBounds(42, 441, 117, 24);
        contentPane.add(lblNewLabel);
        
        JLabel lblNewLabel_1 = new JLabel("Selected Package :");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblNewLabel_1.setBounds(42, 479, 125, 14);
        contentPane.add(lblNewLabel_1);
        
        textField = new JTextField();
        textField.setFont(new Font("Tahoma", Font.BOLD, 12));
        textField.setColumns(10);
        textField.setBounds(169, 477, 262, 20);
        contentPane.add(textField);
        
        JLabel lblNewLabel_1_1 = new JLabel("Selected Hotel :");
        lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblNewLabel_1_1.setBounds(526, 479, 125, 14);
        contentPane.add(lblNewLabel_1_1);
        
        textField_1 = new JTextField();
        textField_1.setFont(new Font("Tahoma", Font.BOLD, 12));
        textField_1.setColumns(10);
        textField_1.setBounds(653, 477, 262, 20);
        contentPane.add(textField_1);
        
        JLabel lblNewLabel_1_2 = new JLabel("Arrival Date :");
        lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblNewLabel_1_2.setBounds(42, 521, 125, 14);
        contentPane.add(lblNewLabel_1_2);
        
        textField_2 = new JTextField();
        textField_2.setFont(new Font("Tahoma", Font.BOLD, 12));
        textField_2.setColumns(10);
        textField_2.setBounds(169, 519, 262, 20);
        contentPane.add(textField_2);
        
        JLabel lblNewLabel_1_3 = new JLabel("Leaving Date  :");
        lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblNewLabel_1_3.setBounds(526, 517, 125, 14);
        contentPane.add(lblNewLabel_1_3);
        
        textField_3 = new JTextField();
        textField_3.setFont(new Font("Tahoma", Font.BOLD, 12));
        textField_3.setColumns(10);
        textField_3.setBounds(653, 515, 262, 20);
        contentPane.add(textField_3);
        
        JLabel lblNewLabel_1_4 = new JLabel("Total Person :");
        lblNewLabel_1_4.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblNewLabel_1_4.setBounds(42, 562, 125, 14);
        contentPane.add(lblNewLabel_1_4);
        
        textField_4 = new JTextField();
        textField_4.setFont(new Font("Tahoma", Font.BOLD, 12));
        textField_4.setColumns(10);
        textField_4.setBounds(169, 560, 262, 20);
        contentPane.add(textField_4);
        
        JLabel lblNewLabel_7 = new JLabel("Total Amount : 0000");
        lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNewLabel_7.setBounds(526, 554, 254, 29);
        contentPane.add(lblNewLabel_7);
        
        JButton btnAdd = new JButton("Add");
        btnAdd.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnAdd.setBounds(446, 619, 74, 23);
        contentPane.add(btnAdd);
        
        JButton btnNewButton_1 = new JButton("Check price");
        btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnNewButton_1.setBounds(530, 619, 110, 23);
        contentPane.add(btnNewButton_1);
        
        JButton btnClose = new JButton("Close");
        btnClose.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnClose.setBounds(650, 619, 74, 23);
        contentPane.add(btnClose);

        // Action listeners
        locationDropdown.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selectedLocation = (String) locationDropdown.getSelectedItem();
                if ("Dubai".equals(selectedLocation)) {
                    packageDropdown.setModel(new DefaultComboBoxModel<>(new String[] {"Select Package", "Dubai Package A", "Dubai Package B"}));
                    hotelDropdown.setModel(new DefaultComboBoxModel<>(new String[] {"Select Hotel", "Dubai Hotel X", "Dubai Hotel Y"}));
                    packageDetails.setText("Select a package for Dubai");
                    hotelDetails.setText("Select a hotel for Dubai");
                } else if ("Paris".equals(selectedLocation)) {
                    packageDropdown.setModel(new DefaultComboBoxModel<>(new String[] {"Select Package", "Paris Package A", "Paris Package B"}));
                    hotelDropdown.setModel(new DefaultComboBoxModel<>(new String[] {"Select Hotel", "Paris Hotel X", "Paris Hotel Y"}));
                    packageDetails.setText("Select a package for Paris");
                    hotelDetails.setText("Select a hotel for Paris");
                } else {
                    packageDropdown.setModel(new DefaultComboBoxModel<>(new String[] {"Select Package"}));
                    hotelDropdown.setModel(new DefaultComboBoxModel<>(new String[] {"Select Hotel"}));
                    packageDetails.setText("Please select a location");
                    hotelDetails.setText("Please select a location");
                }
            }
        });

        packageDropdown.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selectedPackage = (String) packageDropdown.getSelectedItem();
                if ("Dubai Package A".equals(selectedPackage)) {
                    packageDetails.setText("<html><b>Dubai Package A</b><br>Price: $1000<br>Includes flights, hotel stay, and desert safari.</html>");
                } else if ("Dubai Package B".equals(selectedPackage)) {
                    packageDetails.setText("<html><b>Dubai Package B</b><br>Price: $1500<br>Includes premium hotel, meals, and all-inclusive city tours.</html>");
                } else if ("Paris Package A".equals(selectedPackage)) {
                    packageDetails.setText("<html><b>Paris Package A</b><br>Price: $1200<br>Includes flights, hotel stay, and Eiffel Tower tour.</html>");
                } else if ("Paris Package B".equals(selectedPackage)) {
                    packageDetails.setText("<html><b>Paris Package B</b><br>Price: $1800<br>Includes luxury hotel, meals, and Louvre Museum access.</html>");
                } else {
                    packageDetails.setText("");
                }
            }
        });

        hotelDropdown.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selectedHotel = (String) hotelDropdown.getSelectedItem();
                if ("Dubai Hotel X".equals(selectedHotel)) {
                    hotelDetails.setText("<html><b>Dubai Hotel X</b><br>Rating: 4 stars<br>Free breakfast and pool access.</html>");
                } else if ("Dubai Hotel Y".equals(selectedHotel)) {
                    hotelDetails.setText("<html><b>Dubai Hotel Y</b><br>Rating: 5 stars<br>Luxury suites with city view and spa.</html>");
                } else if ("Paris Hotel X".equals(selectedHotel)) {
                    hotelDetails.setText("<html><b>Paris Hotel X</b><br>Rating: 4 stars<br>Central location with free breakfast.</html>");
                } else if ("Paris Hotel Y".equals(selectedHotel)) {
                    hotelDetails.setText("<html><b>Paris Hotel Y</b><br>Rating: 5 stars<br>Luxury suites with Eiffel Tower view and gourmet dining.</html>");
                } else {
                    hotelDetails.setText("");
                }
            }
        });

        btnSelectPackage.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selectedPackage = (String) packageDropdown.getSelectedItem();
                if (!"Select Package".equals(selectedPackage)) {
                    JOptionPane.showMessageDialog(null, "Package selected: " + selectedPackage);
                } else {
                    JOptionPane.showMessageDialog(null, "Please select a package.");
                }
            }
        });

        btnSelectHotel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selectedHotel = (String) hotelDropdown.getSelectedItem();
                if (!"Select Hotel".equals(selectedHotel)) {
                    JOptionPane.showMessageDialog(null, "Hotel selected: " + selectedHotel);
                } else {
                    JOptionPane.showMessageDialog(null, "Please select a hotel.");
                }
            }
        });
    }
}
