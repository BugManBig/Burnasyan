package com.company;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class TransplantationView {
    private JFrame frame;
    private JFormattedTextField dateField;
    private JLabel rangeLabel;
    private TransplantationController transplantationController;
    private JComboBox<String> typeComboBox;

    public void setTransplantationController(TransplantationController transplantationController) {
        this.transplantationController = transplantationController;
    }

    public void create() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);

        createLabel("Трансплантация", 200, 20);
        createLabel("Тип трансплантанта:", 20, 70);
        createLabel("Дата трансплантации:", 20, 110);

        typeComboBox = new JComboBox<>(new String[]{"Родственный", "Трупный"});
        typeComboBox.setBounds(220, 70, 150, 30);
        typeComboBox.setFont(Params.FONT);
        frame.add(typeComboBox);

        try {
            dateField = new JFormattedTextField(new MaskFormatter("##.##.####"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        dateField.setBounds(220, 110, 100, 30);
        dateField.setFont(Params.FONT);
        dateField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                transplantationController.handleKeyRelease();
            }
        });
        frame.add(dateField);

        rangeLabel = new JLabel();
        rangeLabel.setFont(Params.FONT);
        rangeLabel.setBounds(330, 110, 250, 30);
        frame.add(rangeLabel);

        JButton nextButton = new JButton("Next");
        nextButton.addActionListener(e -> transplantationController.handleNextButtonClick());
        nextButton.setBounds(450, 300, 100, 30);
        frame.add(nextButton);

        frame.setVisible(true);
    }

    public void setRangeLabel(String string) {
        rangeLabel.setText(string);
    }

    public LocalDate getDate() {
        try {
            return LocalDate.parse(dateField.getText(), DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        } catch (DateTimeParseException e) {
            return null;
        }
    }

    private void createLabel(String text, int x, int y) {
        JLabel label = new JLabel(text);
        label.setBounds(x, y, 200, 30);
        label.setFont(Params.FONT);
        frame.add(label);
    }

    public void close() {
        frame.dispose();
    }

    public String getDateString() {
        return dateField.getText();
    }

    public String getTypeString() {
        return (String) typeComboBox.getSelectedItem();
    }
}
