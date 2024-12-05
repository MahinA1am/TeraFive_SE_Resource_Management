package employee;

import javax.swing.*;
import java.awt.*;

public class Homepage extends JFrame {

    public Homepage() {
        // Frame settings
        setTitle("Homepage");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Background image
        JLabel backgroundLabel = new JLabel(new ImageIcon("src/resources/homepage_background.jpg")); // Update with  image path
        backgroundLabel.setLayout(new BorderLayout());
        add(backgroundLabel);

        // Menu Bar
        JMenuBar menuBar = new JMenuBar();

        // Hospital Menu
        JMenu hospitalMenu = new JMenu("Hospital");
        JMenuItem doctorMenuItem = new JMenuItem("Doctor Info");
        JMenuItem staffMenuItem = new JMenuItem("Staff Info");
        JMenuItem boardMenuItem = new JMenuItem("Board Info");
        hospitalMenu.add(doctorMenuItem);
        hospitalMenu.add(staffMenuItem);
        hospitalMenu.add(boardMenuItem);
        menuBar.add(hospitalMenu);

        // Inventory Menu
        JMenu inventoryMenu = new JMenu("Inventory");
        JMenuItem adminTableMenuItem = new JMenuItem("Admin Table");
        inventoryMenu.add(adminTableMenuItem);
        menuBar.add(inventoryMenu);

        // Travel Menu
        JMenu travelMenu = new JMenu("Travel");
        JMenuItem hotelStaffMenuItem = new JMenuItem("Hotel Staff");
        JMenuItem tourStaffMenuItem = new JMenuItem("Tour Staff");
        travelMenu.add(hotelStaffMenuItem);
        travelMenu.add(tourStaffMenuItem);
        menuBar.add(travelMenu);

        // Add menu bar to the frame
        setJMenuBar(menuBar);

        // Welcome Panel
        JPanel welcomePanel = new JPanel();
        welcomePanel.setOpaque(false); // Transparent
        welcomePanel.setLayout(new BorderLayout());
        JLabel welcomeLabel = new JLabel("Welcome to the Resource Management System!", JLabel.CENTER);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 20));
        welcomeLabel.setForeground(Color.WHITE);
        welcomePanel.add(welcomeLabel, BorderLayout.CENTER);

        backgroundLabel.add(welcomePanel, BorderLayout.NORTH);

        // Action Listeners for Hospital Menu
        doctorMenuItem.addActionListener(e -> new DoctorsInfo());
        staffMenuItem.addActionListener(e -> new StaffInfo());
        boardMenuItem.addActionListener(e -> new BoardInfo());

        // Action Listener for Inventory Menu
        adminTableMenuItem.addActionListener(e -> JOptionPane.showMessageDialog(this, "Navigating to Admin Table..."));

        // Action Listeners for Travel Menu
        hotelStaffMenuItem.addActionListener(e -> JOptionPane.showMessageDialog(this, "Navigating to Hotel Staff..."));
        tourStaffMenuItem.addActionListener(e -> JOptionPane.showMessageDialog(this, "Navigating to Tour Staff..."));

        setVisible(true);
    }

    public static void main(String[] args) {
        new Homepage();
    }

    private static final long serialVersionUID = 1L;
}
