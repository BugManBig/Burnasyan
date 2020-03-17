package com.company;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;

public class AddView {
    private AddController addController;

    private JFrame frame;

    public void setAddController(AddController addController) {
        this.addController = addController;
    }

    public void create() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(600, 900);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setVisible(true);

        createLabel("Patient:", 20, 60);

        JButton selectPatientButton = new JButton("Select");
        selectPatientButton.setBounds(20, 50, 100, 30);
        selectPatientButton.addActionListener(e -> addController.handleSelectPatientButtonClick());
        frame.add(selectPatientButton);

        frame.repaint();
    }

    private void createLabel(String title, int yOffset, int width) {
        JLabel label = new JLabel(title);
        label.setBounds(20, yOffset, width, 20);
        label.setFont(new Font("Arial", Font.PLAIN, 16));
        frame.add(label);
    }
}
