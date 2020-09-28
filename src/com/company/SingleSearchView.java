package com.company;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.ParseException;

public class SingleSearchView {
    private JTextField nameField;
    private JTextField surnameField;
    private JTextField patronymicField;
    private JTextField birthdayField;
    private JComboBox<String> sexComboBox;
    private JFrame frame;
    private JTable table;
    private String[] sexTypes = {"---", "Мужской", "Женский"};

    private SingleSearchController singleSearchController;

    public void setSingleSearchController(SingleSearchController singleSearchController) {
        this.singleSearchController = singleSearchController;
    }

    public void create() {
        frame = Params.createFrame(770, 800);

        surnameField = createTextfield(20);
        frame.add(surnameField);
        nameField = createTextfield(60);
        frame.add(nameField);
        patronymicField = createTextfield(100);
        frame.add(patronymicField);

        createLabel("Фамилия:", 20);
        createLabel("Имя:", 60);
        createLabel("Отчество:", 100);

        JButton selectButton = new JButton("Выбрать");
        selectButton.setBounds(220, 140, 100, 30);
        selectButton.addActionListener(e -> singleSearchController.handleSelectButtonClick());
        frame.add(selectButton);

        table = new JTable();
        table.setFont(Params.FONT);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(330, 20, 400, 150);
        frame.add(scrollPane);

        frame.setVisible(true);
    }

    private JTextField createTextfield(int yOffset) {
        JTextField textField = new JTextField();
        textField.setBounds(140, yOffset, 180, 30);
        textField.setFont(Params.FONT);
        textField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                singleSearchController.handleButtonRelease();
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

    public void setTable(String[][] data) {
        table.setModel(new DefaultTableModel(data, new String[]{"Пациент", "Дата рождения"}));
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

    public int getSelectedIndex() {
        return table.getSelectedRow();
    }
}
