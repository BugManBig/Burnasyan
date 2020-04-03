package com.company;

import javax.swing.*;
import java.awt.*;

public class AddView {
    private AddController addController;

    private JFrame frame;

    private JLabel patientLabel;

    public void setAddController(AddController addController) {
        this.addController = addController;
    }

    public void create() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(600, 200);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setVisible(true);

        JLabel label = new JLabel("Patient:");
        label.setBounds(20, 20, 60, 20);
        label.setFont(new Font("Arial", Font.PLAIN, 16));
        frame.add(label);

        JButton selectPatientButton = new JButton("Select");
        selectPatientButton.setBounds(20, 50, 100, 30);
        selectPatientButton.addActionListener(e -> addController.handleSelectPatientButtonClick());
        frame.add(selectPatientButton);

        JButton nextButton = new JButton("Next");
        nextButton.setBounds(450, 100, 100, 30);
        nextButton.addActionListener(e -> addController.handleNextButtonClick());
        frame.add(nextButton);

        patientLabel = new JLabel();
        patientLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        patientLabel.setBounds(80, 20, 300, 20);
        frame.add(patientLabel);

        frame.repaint();
    }

    public void setPatientLabel(String text) {
        patientLabel.setText(text);
    }

    public void close() {
        frame.dispose();
    }
}
