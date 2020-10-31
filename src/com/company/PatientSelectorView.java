package com.company;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.ParseException;

public class PatientSelectorView {
    private PatientSelectorController patientSelectorController;

    private JTextField nameField;
    private JTextField surnameField;
    private JTextField patronymicField;
    private JTextField birthdayField;
    private JComboBox<String> sexComboBox;
    private JFrame frame;
    private JTable table;
    private String[] sexTypes = {"---", "Мужской", "Женский"};

    public void setPatientSelectorController(PatientSelectorController patientSelectorController) {
        this.patientSelectorController = patientSelectorController;
    }

    public void create() {
        frame = Params.createFrame(770, 270);

        surnameField = createTextfield(20);
        frame.add(surnameField);
        nameField = createTextfield(60);
        frame.add(nameField);
        patronymicField = createTextfield(100);
        frame.add(patronymicField);
        try {
            birthdayField = new JFormattedTextField(new MaskFormatter("##.##.####"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        birthdayField.setBounds(140, 140, 180, 30);
        birthdayField.setFont(Params.FONT);
        frame.add(birthdayField);

        sexComboBox = new JComboBox<>(sexTypes);
        sexComboBox.setBounds(140, 180, 100, 30);
        sexComboBox.setFont(Params.FONT);
        frame.add(sexComboBox);

        createLabel("Фамилия:", 20);
        createLabel("Имя:", 60);
        createLabel("Отчество:", 100);
        createLabel("Дата рождения:", 140);
        createLabel("Пол:", 180);

        JButton createButton = new JButton("+");
        createButton.setBounds(270, 180, 50, 30);
        createButton.setFont(Params.FONT);
        createButton.addActionListener(e -> patientSelectorController.handleCreateButtonClick());
        frame.add(createButton);

        JButton selectButton = new JButton("Выбрать");
        selectButton.setBounds(330, 180, 100, 30);
        selectButton.addActionListener(e -> patientSelectorController.handleSelectButtonClick());
        frame.add(selectButton);

        table = new JTable();
        table.setFont(Params.FONT);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(330, 20, 400, 150);
        frame.add(scrollPane);

        frame.setVisible(true);
    }

    public int getSelectedIndex() {
        return table.getSelectedRow();
    }

    public void setTable(String[][] data) {
        table.setModel(new DefaultTableModel(data, new String[]{"Пациент", "Дата рождения"}));
    }

    private JTextField createTextfield(int yOffset) {
        JTextField textField = new JTextField();
        textField.setBounds(140, yOffset, 180, 30);
        textField.setFont(Params.FONT);
        textField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                patientSelectorController.handleButtonRelease();
            }
        });
        return textField;
    }

    private void createLabel(String text, int yOffset) {
        JLabel label = new JLabel(text);
        label.setBounds(20, yOffset, 120, 30);
        label.setFont(Params.FONT);
        frame.add(label);
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

    public String getBirthday() {
        return birthdayField.getText();
    }

    public Sex getSex() {
        return Sex.values()[sexComboBox.getSelectedIndex()];
    }

    public void setSex(Sex sex) {
        if (sex == Sex.NONE) {
            sexComboBox.setSelectedIndex(0);
        }
        if (sex == Sex.MALE) {
            sexComboBox.setSelectedIndex(1);
        }
        if (sex == Sex.FEMALE) {
            sexComboBox.setSelectedIndex(2);
        }
    }

    public void close() {
        frame.dispose();
    }
}
