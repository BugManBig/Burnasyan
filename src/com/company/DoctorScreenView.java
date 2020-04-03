package com.company;

import javax.swing.*;
import java.awt.*;

public class DoctorScreenView {
    private JFrame frame;
    private JLabel doctorLabel;
    private DoctorScreenController doctorScreenController;

    public void setDoctorScreenController(DoctorScreenController doctorScreenController) {
        this.doctorScreenController = doctorScreenController;
    }

    public void create() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(600, 200);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setVisible(true);

        JLabel label = new JLabel("Doctor:");
        label.setBounds(20, 20, 60, 20);
        label.setFont(new Font("Arial", Font.PLAIN, 16));
        frame.add(label);

        JButton selectPatientButton = new JButton("Select");
        selectPatientButton.setBounds(20, 50, 100, 30);
        selectPatientButton.addActionListener(e -> doctorScreenController.handleSelectDoctorButtonClick());
        frame.add(selectPatientButton);

        doctorLabel = new JLabel();
        doctorLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        doctorLabel.setBounds(80, 20, 300, 20);
        frame.add(doctorLabel);

        frame.repaint();
    }

    public void setDoctorLabel(String text) {
        doctorLabel.setText(text);
    }
}
