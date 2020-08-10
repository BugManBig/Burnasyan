package com.company;

import javax.swing.*;

public class ArteryView {
    private ArteryController arteryController;

    private JFrame frame;

    private JTextField speedField;
    private JTextField irField;
    private JComboBox<String> comboBox;

    public void setArteryController(ArteryController arteryController) {
        this.arteryController = arteryController;
    }

    public void create() {
        frame = Params.createFrame();

        createLabel("Собственная артерия печени", 180, 20);
        createLabel("Визуализируется:", 20, 60);
        createLabel("Скорость:", 20, 100);
        createLabel("IR:", 20, 140);

        comboBox = new JComboBox<>(new String[]{"---", "Да", "Нет"});
        comboBox.setBounds(160, 60, 100, 30);
        comboBox.setFont(Params.FONT);
        frame.add(comboBox);

        speedField = new JTextField();
        speedField.setBounds(160, 100, 100, 30);
        speedField.setFont(Params.FONT);
        frame.add(speedField);

        irField = new JTextField();
        irField.setBounds(160, 140, 100, 30);
        irField.setFont(Params.FONT);
        frame.add(irField);

        JButton nextButton = new JButton("Далее");
        nextButton.addActionListener(e -> arteryController.handleNextButtonClick());
        nextButton.setBounds(450, 300, 100, 30);
        frame.add(nextButton);

        frame.setVisible(true);
    }

    public String getComboBox() {
        return (String) comboBox.getSelectedItem();
    }

    public String getSpeedField() {
        return speedField.getText();
    }

    public String getIrField() {
        return irField.getText();
    }

    private void createLabel(String text, int x, int y) {
        JLabel label = new JLabel(text);
        label.setBounds(x, y, text.length() > 15 ? 220 : 140, 30);
        label.setFont(Params.FONT);
        frame.add(label);
    }

    public void close() {
        frame.dispose();
    }
}
