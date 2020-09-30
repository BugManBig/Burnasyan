package com.company;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SingleSearchView {
    private JTextField nameField;
    private JTextField surnameField;
    private JTextField patronymicField;
    private JFrame frame;
    private JTable patientsTable;
    private JList<String> researchList;

    private SingleSearchController singleSearchController;
    private JButton selectPatientButton;

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

        selectPatientButton = new JButton("Выбрать");
        selectPatientButton.setBounds(220, 140, 100, 30);
        selectPatientButton.addActionListener(e -> singleSearchController.handleSelectPatientButtonClick());
        frame.add(selectPatientButton);

        JButton selectResearchButton = new JButton("Выбрать");
        selectResearchButton.setBounds(20, 710, 100, 30);
        selectResearchButton.addActionListener(e -> singleSearchController.handleSelectResearchButtonClick());
        frame.add(selectResearchButton);

        patientsTable = new JTable();
        patientsTable.setFont(Params.FONT);
        JScrollPane scrollPane = new JScrollPane(patientsTable);
        scrollPane.setBounds(330, 20, 400, 150);
        patientsTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                singleSearchController.handleListClick();
            }
        });
        frame.add(scrollPane);

        researchList = new JList<>();
        researchList.setFont(Params.FONT);
        JScrollPane scrollPane2 = new JScrollPane(researchList);
        scrollPane2.setBounds(20, 180, 710, 520);
        frame.add(scrollPane2);

        frame.setVisible(true);
    }

    public void setPatientButtonEnabled(boolean b) {
        selectPatientButton.setEnabled(b);
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

    public void setPatientsTable(String[][] data) {
        patientsTable.setModel(new DefaultTableModel(data, new String[]{"Пациент", "Дата рождения"}));
    }

    public void setResearchList(String[] data) {
        researchList.setListData(data);
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

    public int getSelectedPatientIndex() {
        return patientsTable.getSelectedRow();
    }

    public int getSelectedResearchIndex() {
        return researchList.getSelectedIndex();
    }
}
