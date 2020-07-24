package com.company;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class PatientSelectorView {
    private PatientSelectorController patientSelectorController;

    private JTextField nameField;
    private JTextField surnameField;
    private JTextField patronymicField;
    private JTextField birthdayField;
    private JComboBox<String> sexComboBox;
    private JFrame frame;
    private JTable table;
    private String[] sexTypes = {"---", "Male", "Female"};

    public void setPatientSelectorController(PatientSelectorController patientSelectorController) {
        this.patientSelectorController = patientSelectorController;
    }

    public void create() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(800, 300);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setVisible(true);

        surnameField = createTextfield(20);
        frame.add(surnameField);
        nameField = createTextfield(60);
        frame.add(nameField);
        patronymicField = createTextfield(100);
        frame.add(patronymicField);
        birthdayField = createTextfield(140);
        frame.add(birthdayField);

        sexComboBox = new JComboBox<>(sexTypes);
        sexComboBox.setBounds(120, 180, 100, 30);
        sexComboBox.setFont(Params.FONT);
        frame.add(sexComboBox);

        createLabel("Surname:", 20);
        createLabel("Name:", 60);
        createLabel("Patronymic:", 100);
        createLabel("Birthday:", 140);
        createLabel("Sex:", 180);

        JButton createButton = new JButton("Create");
        createButton.setBounds(120, 220, 100, 30);
        createButton.addActionListener(e -> patientSelectorController.handleCreateButtonClick());
        frame.add(createButton);

        JButton selectButton = new JButton("Select");
        selectButton.setBounds(330, 180, 100, 30);
        selectButton.addActionListener(e -> patientSelectorController.handleSelectButtonClick());
        frame.add(selectButton);

        table = new JTable();
        table.setFont(Params.FONT);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(330, 20, 400, 150);
        frame.add(scrollPane);

        frame.repaint();
    }

    public int getSelectedIndex() {
        return table.getSelectedRow();
    }

    public void setTable(String[][] data) {
        table.setModel(new DefaultTableModel(data, new String[]{"Patient", "Birthday"}));
    }

    private JTextField createTextfield(int yOffset) {
        JTextField textField = new JTextField();
        textField.setBounds(120, yOffset, 200, 30);
        textField.setFont(Params.FONT);
        textField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                patientSelectorController.handleButtonRelease();
            }
        });
        return textField;
    }

    private void createLabel(String text, int yOffset) {
        JLabel label = new JLabel(text);
        label.setBounds(20, yOffset, 100, 30);
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
