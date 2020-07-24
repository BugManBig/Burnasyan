package com.company;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.text.ParseException;

public class AddView {
    private AddController addController;

    private JFrame frame;

    private JLabel patientNameLabel;
    private JLabel doctorNameLabel;
    private JFormattedTextField dateField;

    public void setAddController(AddController addController) {
        this.addController = addController;
    }

    public void create() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setVisible(true);

        //Doctor
        JLabel doctorTitleLabel = new JLabel("Doctor:");
        doctorTitleLabel.setBounds(20, 20, 60, 20);
        doctorTitleLabel.setFont(Params.FONT);
        frame.add(doctorTitleLabel);

        doctorNameLabel = new JLabel();
        doctorNameLabel.setFont(Params.FONT);
        doctorNameLabel.setBounds(80, 20, 300, 20);
        frame.add(doctorNameLabel);

        JButton selectDoctorButton = new JButton("Select");
        selectDoctorButton.setBounds(20, 50, 100, 30);
        selectDoctorButton.addActionListener(e -> addController.handleSelectDoctorButtonClick());
        frame.add(selectDoctorButton);

        //Patient
        JLabel patientTitleLabel = new JLabel("Patient:");
        patientTitleLabel.setBounds(20, 120, 60, 20);
        patientTitleLabel.setFont(Params.FONT);
        frame.add(patientTitleLabel);

        patientNameLabel = new JLabel();
        patientNameLabel.setFont(Params.FONT);
        patientNameLabel.setBounds(80, 120, 300, 20);
        frame.add(patientNameLabel);

        JButton selectPatientButton = new JButton("Select");
        selectPatientButton.setBounds(20, 150, 100, 30);
        selectPatientButton.addActionListener(e -> addController.handleSelectPatientButtonClick());
        frame.add(selectPatientButton);

        //Date
        JLabel dateLabel = new JLabel("Date:");
        dateLabel.setBounds(20, 220, 50, 30);
        dateLabel.setFont(Params.FONT);
        frame.add(dateLabel);

        try {
            dateField = new JFormattedTextField(new MaskFormatter("##.##.####"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        dateField.setBounds(70, 220, 100, 30);
        dateField.setFont(Params.FONT);
        frame.add(dateField);

        JButton nextButton = new JButton("Next");
        nextButton.setBounds(450, 300, 100, 30);
        nextButton.addActionListener(e -> addController.handleNextButtonClick());
        frame.add(nextButton);

        frame.repaint();
    }

    public void setDateField(String string) {
        dateField.setText(string);
    }

    public String getDate() {
        return dateField.getText();
    }

    public void setPatientLabel(String text) {
        patientNameLabel.setText(text);
    }

    public void setDoctorNameLabel(String text) {
        doctorNameLabel.setText(text);
    }

    public void close() {
        frame.dispose();
    }
}
