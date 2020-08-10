package com.company;

import javax.swing.*;

public class LiverVenyView {
    private LiverVenyController liverVenyController;

    private JFrame frame;
    private JComboBox<String> comboBox;
    private JTextField speedField;

    public void setLiverVenyController(LiverVenyController liverVenyController) {
        this.liverVenyController = liverVenyController;
    }

    public void create() {
        frame = Params.createFrame();

        createLabel("Печёночные вены", 200, 20);
        createLabel("Тип кровотока:", 20, 60);
        createLabel("Скорость:", 20, 100);

        comboBox = new JComboBox<>(new String[]{"HV0", "HV1", "HV2"});
        comboBox.setBounds(160, 60, 100, 30);
        comboBox.setFont(Params.FONT);
        frame.add(comboBox);

        speedField = new JTextField();
        speedField.setBounds(160, 100, 100, 30);
        speedField.setFont(Params.FONT);
        frame.add(speedField);

        JButton nextButton = new JButton("Далее");
        nextButton.addActionListener(e -> liverVenyController.handleNextButtonClick());
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

    public String getType() {
        return (String) comboBox.getSelectedItem();
    }

    public String getSpeed() {
        return speedField.getText();
    }

    public void close() {
        frame.dispose();
    }
}
