package main;


import hospital.LoginPage ;
import pol.Login ;
import employee.LoginForm ;
import pro.LogIN;

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

        inventoryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	Login frame = new Login();
				frame.setVisible(true); // Opens Inventory login page
            }
        });

        employeeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new LoginForm(); // Opens Employee login page
            }
        });

        travelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	LogIN frame = new LogIN(); // Opens Travel login page
            	frame.setVisible(true);
            }
        });

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
