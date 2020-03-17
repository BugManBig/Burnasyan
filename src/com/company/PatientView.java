package com.company;

import javax.swing.*;
import java.awt.*;

public class PatientView {
    private PatientController patientController;

    private JTextField nameField;
    private JTextField surnameField;
    private JTextField patronymicField;

    public void setPatientController(PatientController patientController) {
        this.patientController = patientController;
    }

    public void create() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(600, 300);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setVisible(true);

        nameField = createTextfield(20);
        frame.add(nameField);
        surnameField = createTextfield(60);
        frame.add(surnameField);
        patronymicField = createTextfield(100);
        frame.add(patronymicField);

        JButton createButton = new JButton("Create");
        createButton.setBounds(20, 140, 100, 30);
        createButton.addActionListener(e -> patientController.handleCreateButtonClick());
        frame.add(createButton);

        frame.repaint();
    }

    private JTextField createTextfield(int yOffset) {
        JTextField textField = new JTextField();
        textField.setBounds(20, yOffset, 200, 30);
        textField.setFont(new Font("Arial", Font.PLAIN, 16));
        return textField;
    }

    public String getName() {
        return nameField.getText();
    }

    public String getSurname() {
        return surnameField.getText();
    }

    public String getPatronymic() {
        return patronymicField.getText();
    }
}
