package com.company;

import javax.swing.*;

public class HoledohView {
    private HoledohController holedohController;

    private JFrame frame;
    private JComboBox<String> comboBox;
    private JTextField sizesField;

    public void setHoledohController(HoledohController holedohController) {
        this.holedohController = holedohController;
    }

    public void create() {
        frame = Params.createFrame();

        createLabel("Холедох", 250, 20);
        createLabel("Визуализируется:", 20, 60);
        createLabel("Размеры:", 20, 100);
        createLabel("мм", 290, 100);

        comboBox = new JComboBox<>(new String[]{"---", "Да", "Нет"});
        comboBox.setBounds(160, 60, 120, 30);
        comboBox.setFont(Params.FONT);
        frame.add(comboBox);

        sizesField = new JTextField();
        sizesField.setBounds(160, 100, 120, 30);
        sizesField.setFont(Params.FONT);
        frame.add(sizesField);

        JButton nextButton = new JButton("Далее");
        nextButton.addActionListener(e -> holedohController.handleNextButtonClick());
        nextButton.setBounds(450, 300, 100, 30);
        frame.add(nextButton);

        frame.setVisible(true);
    }

    private void createLabel(String text, int x, int y) {
        JLabel label = new JLabel(text);
        label.setBounds(x, y, 140, 30);
        label.setFont(Params.FONT);
        frame.add(label);
    }

    public String getComboBoxText() {
        return (String) comboBox.getSelectedItem();
    }

    public String getSizes() {
        return sizesField.getText();
    }

    public void close() {
        frame.dispose();
    }
}
