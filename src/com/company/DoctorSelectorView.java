package com.company;

import javax.swing.*;

public class DoctorSelectorView {
    private DoctorSelectorController doctorSelectorController;

    private JTextField nameField;
    private JTextField surnameField;
    private JTextField patronymicField;
    private JFrame frame;
    private JList<String> list;

    public void setDoctorSelectorController(DoctorSelectorController doctorSelectorController) {
        this.doctorSelectorController = doctorSelectorController;
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

        createLabel("Surname:", 20);
        createLabel("Name:", 60);
        createLabel("Patronymic:", 100);

        JButton createButton = new JButton("Create");
        createButton.setBounds(120, 180, 100, 30);
        createButton.addActionListener(e -> doctorSelectorController.handleCreateButtonClick());
        frame.add(createButton);

        JButton selectButton = new JButton("Select");
        selectButton.setBounds(330, 180, 100, 30);
        selectButton.addActionListener(e -> doctorSelectorController.handleSelectButtonClick());
        frame.add(selectButton);

        list = new JList<>();
        list.setFont(Params.FONT);
        JScrollPane scrollPane = new JScrollPane(list);
        scrollPane.setBounds(330, 20, 400, 150);
        frame.add(scrollPane);

        frame.repaint();
    }

    public int getSelectedIndex() {
        return list.getSelectedIndex();
    }

    public void setListData(String[] data) {
        list.setListData(data);
    }

    private JTextField createTextfield(int yOffset) {
        JTextField textField = new JTextField();
        textField.setBounds(120, yOffset, 200, 30);
        textField.setFont(Params.FONT);
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

    public void close() {
        frame.dispose();
    }
}
