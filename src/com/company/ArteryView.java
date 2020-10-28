package com.company;

import javax.swing.*;

public class ArteryView {
    private ArteryController arteryController;

    private JFrame frame;

    private JTextField vpsField;
    private JTextField vdField;
    private JTextField irField;
    private JComboBox<String> comboBox;

    public void setArteryController(ArteryController arteryController) {
        this.arteryController = arteryController;
    }

    public void create() {
        frame = Params.createFrame();

        createLabel("Собственная артерия печени", 180, 20);
        createLabel("Визуализируется:", 20, 60);
        createLabel("Vps:", 20, 100);
        createLabel("Vd:", 20, 140);
        createLabel("IR:", 20, 180);

        comboBox = new JComboBox<>(new String[]{"---", "Да", "Нет"});
        comboBox.setBounds(160, 60, 100, 30);
        comboBox.setFont(Params.FONT);
        frame.add(comboBox);

        vpsField = new JTextField();
        vpsField.setBounds(160, 100, 100, 30);
        vpsField.setFont(Params.FONT);
        frame.add(vpsField);

        vdField = new JTextField();
        vdField.setBounds(160, 140, 100, 30);
        vdField.setFont(Params.FONT);
        frame.add(vdField);

        irField = new JTextField();
        irField.setBounds(160, 180, 100, 30);
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

    public String getVpsField() {
        return vpsField.getText();
    }

    public String getVdField() {
        return vdField.getText();
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
