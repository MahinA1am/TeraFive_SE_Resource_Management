package main;


import hospital.LoginPage ;
//import inventory.LoginPage as InventoryLoginPage;
import employee.LoginForm ;
//import travel.LoginPage as TravelLoginPage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame {

    public Main() {
        setTitle("Resource Management System");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create panel with buttons for each module
        JPanel panel = new JPanel(new GridLayout(4, 1, 10, 10));

        JButton hospitalButton = new JButton("Hospital Management");
        JButton inventoryButton = new JButton("Inventory Management");
        JButton employeeButton = new JButton("Employee Management");
        JButton travelButton = new JButton("Travel Management");

        // Add action listeners to buttons to open respective login pages
        hospitalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new LoginPage(); // Opens Hospital login page
            }
        });

//        inventoryButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                new InventoryLoginPage(); // Opens Inventory login page
//            }
//        });
//
        employeeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new LoginForm(); // Opens Employee login page
            }
        });
//
//        travelButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                new TravelLoginPage(); // Opens Travel login page
//            }
//        });

        // Add buttons to panel
        panel.add(hospitalButton);
        panel.add(inventoryButton);
        panel.add(employeeButton);
        panel.add(travelButton);

        add(panel, BorderLayout.CENTER);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Main());
    }
    
    private static final long serialVersionUID = 1L;
}
