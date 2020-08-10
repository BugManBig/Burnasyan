package com.company;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class AddView {
    private AddController addController;

    private JFrame frame;

    private JLabel patientFioLabel;
    private JLabel doctorNameLabel;
    private JFormattedTextField dateField;

    public void setAddController(AddController addController) {
        this.addController = addController;
    }

    public void create() {
        frame = Params.createFrame();

        //Doctor
        JLabel doctorTitleLabel = new JLabel("Врач:");
        doctorTitleLabel.setBounds(20, 20, 50, 20);
        doctorTitleLabel.setFont(Params.FONT);
        frame.add(doctorTitleLabel);

        doctorNameLabel = new JLabel();
        doctorNameLabel.setFont(Params.FONT);
        doctorNameLabel.setBounds(70, 20, 300, 20);
        frame.add(doctorNameLabel);

        JButton selectDoctorButton = new JButton("Выбрать");
        selectDoctorButton.setBounds(20, 50, 100, 30);
        selectDoctorButton.addActionListener(e -> addController.handleSelectDoctorButtonClick());
        frame.add(selectDoctorButton);

        //Patient
        JLabel patientTitleLabel = new JLabel("Пациент:");
        patientTitleLabel.setBounds(20, 120, 70, 20);
        patientTitleLabel.setFont(Params.FONT);
        frame.add(patientTitleLabel);

        patientFioLabel = new JLabel();
        patientFioLabel.setFont(Params.FONT);
        patientFioLabel.setBounds(90, 120, 400, 20);
        frame.add(patientFioLabel);

        JButton selectPatientButton = new JButton("Выбрать");
        selectPatientButton.setBounds(20, 150, 100, 30);
        selectPatientButton.addActionListener(e -> addController.handleSelectPatientButtonClick());
        frame.add(selectPatientButton);

        //Date
        JLabel dateLabel = new JLabel("Дата обследования:");
        dateLabel.setBounds(20, 220, 150, 30);
        dateLabel.setFont(Params.FONT);
        frame.add(dateLabel);

        try {
            dateField = new JFormattedTextField(new MaskFormatter("##.##.####"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        dateField.setBounds(180, 220, 100, 30);
        dateField.setFont(Params.FONT);
        dateField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                addController.handleKeyRelease();
            }
        });
        frame.add(dateField);

        JButton nextButton = new JButton("Далее");
        nextButton.setBounds(450, 300, 100, 30);
        nextButton.addActionListener(e -> addController.handleNextButtonClick());
        frame.add(nextButton);

        frame.setVisible(true);
    }

    public void setDateField(String string) {
        dateField.setText(string);
    }

    public String getDateString() {
        return dateField.getText();
    }

    public LocalDate getDate() {
        try {
            return LocalDate.parse(dateField.getText(), DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        } catch (DateTimeParseException e) {
            return null;
        }
    }

    public void setPatientFioLabel(String text) {
        patientFioLabel.setText(text);
    }

    public void setDoctorNameLabel(String text) {
        doctorNameLabel.setText(text);
    }

    public void close() {
        frame.dispose();
    }
}
