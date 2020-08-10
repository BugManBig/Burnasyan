package com.company;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.event.*;
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
    private JTextField ldField;
    private JTextField rdField;
    private JTextField hdField;
    private JLabel ldLabel;
    private JLabel hdLabel;
    private JComboBox<String> echoComboBox;
    private JTextArea commentArea;

    public void setTransplantationController(TransplantationController transplantationController) {
        this.transplantationController = transplantationController;
    }

    public void create() {
        frame = Params.createFrame(600, 500);

        createLabel("Трансплантация", 200, 20);
        createLabel("Тип трансплантанта:", 20, 70);
        createLabel("Дата трансплантации:", 20, 110);
        createLabel("ПД:", 170, 150);
        createLabel("Размеры", 20, 150);
        createLabel("трансплантата:", 20, 170);
        ldLabel = new JLabel("ЛД:");
        ldLabel.setBounds(170, 190, 30, 30);
        ldLabel.setFont(Params.FONT);
        frame.add(ldLabel);
        hdLabel = new JLabel("ХД:");
        hdLabel.setBounds(170, 230, 30, 30);
        hdLabel.setFont(Params.FONT);
        frame.add(hdLabel);
        createLabel("Эхогенность:", 20, 270);
        createLabel("Доп. образования:", 20, 310);

        typeComboBox = new JComboBox<>(new String[]{"Родственный", "Трупный"});
        typeComboBox.setBounds(220, 70, 150, 30);
        typeComboBox.setFont(Params.FONT);
        typeComboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                transplantationController.handleComboBoxChange();
            }
        });
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

        rdField = new JTextField();
        rdField.setFont(Params.FONT);
        rdField.setBounds(220, 150, 100, 30);
        frame.add(rdField);

        ldField = new JTextField();
        ldField.setFont(Params.FONT);
        ldField.setBounds(220, 190, 100, 30);
        frame.add(ldField);

        hdField = new JTextField();
        hdField.setFont(Params.FONT);
        hdField.setBounds(220, 230, 100, 30);
        frame.add(hdField);

        echoComboBox = new JComboBox<>(new String[]{
                "Умеренно гипоэхогенная",
                "Выраженно гипоэхогенная",
                "Изоэхогенная",
                "Умеренно гиперэхогенная",
                "Выраженно гиперэхогенная"
        });
        echoComboBox.setFont(Params.FONT);
        echoComboBox.setSelectedIndex(2);
        echoComboBox.setBounds(220, 270, 250, 30);
        frame.add(echoComboBox);

        commentArea = new JTextArea();
        commentArea.setFont(Params.FONT);
        commentArea.setBounds(220, 320, 250, 75);
        commentArea.setLineWrap(true);
        commentArea.setWrapStyleWord(true);
        frame.add(commentArea);

        JButton nextButton = new JButton("Далее");
        nextButton.addActionListener(e -> transplantationController.handleNextButtonClick());
        nextButton.setBounds(370, 410, 100, 30);
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
        label.setBounds(x, y, text.length() > 3 ? 200 : 30, 30);
        label.setFont(Params.FONT);
        frame.add(label);
    }

    public void close() {
        frame.dispose();
    }

    public String getDateString() {
        String text = dateField.getText();
        if (text.contains(" ")) {
            return "";
        }
        return text;
    }

    public String getTypeString() {
        return (String) typeComboBox.getSelectedItem();
    }

    public String getRdString() {
        return rdField.getText();
    }

    public String getLdString() {
        return ldField.getText();
    }

    public String getHdString() {
        return hdField.getText();
    }

    public String getEchoType() {
        return (String) echoComboBox.getSelectedItem();
    }

    public String getComment() {
        return commentArea.getText();
    }

    public void setFieldsEnabled(boolean b) {
        ldField.setEnabled(b);
        hdField.setEnabled(b);
        ldLabel.setEnabled(b);
        hdLabel.setEnabled(b);
    }
}
