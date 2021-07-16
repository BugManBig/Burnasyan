package com.company;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class SelezenkaView {
    private SelezenkaController selezenkaController;

    private JFrame frame;
    private JTextField sizesField;
    private JTextField squareField;
    private JTextField diameterField;
    private JTextField speedField;

    public void setSelezenkaController(SelezenkaController selezenkaController) {
        this.selezenkaController = selezenkaController;
    }

    public void create() {
        frame = Params.createFrame();

        createLabel("Селезёнка", 250, 20);
        createLabel("Размеры:", 20, 60);
        createLabel("Площадь:", 20, 100);
        createLabel("Диаметр селезёночной", 20, 140);
        createLabel("вены в воротах:", 20, 160);
        createLabel("Скорость в воротах", 20, 200);
        createLabel("селезёнки:", 20, 220);
        createLabel("мм", 310, 60);
        createLabel("см^2", 310, 100);
        createLabel("мм", 310, 160);
        createLabel("см/c", 310, 220);

        sizesField = new JTextField();
        sizesField.setBounds(200, 60, 100, 30);
        sizesField.setFont(Params.FONT);
        frame.add(sizesField);

        squareField = new JTextField();
        squareField.setBounds(200, 100, 100, 30);
        squareField.setFont(Params.FONT);
        frame.add(squareField);

        diameterField = new JTextField();
        diameterField.setBounds(200, 160, 100, 30);
        diameterField.setFont(Params.FONT);
        frame.add(diameterField);

        speedField = new JTextField();
        speedField.setBounds(200, 220, 100, 30);
        speedField.setFont(Params.FONT);
        frame.add(speedField);

        JButton nextButton = new JButton("Далее");
        nextButton.addActionListener(e -> selezenkaController.handleNextButtonClick());
        nextButton.setBounds(450, 300, 100, 30);
        frame.add(nextButton);

        frame.setVisible(true);
    }

    private void createLabel(String text, int x, int y) {
        JLabel label = new JLabel(text);
        label.setBounds(x, y, 180, 30);
        label.setFont(Params.FONT);
        frame.add(label);
    }

    public String getSizes() {
        return sizesField.getText();
    }

    public String getSquare() {
        return squareField.getText();
    }

    public String getDiameter() {
        return diameterField.getText();
    }

    public String getSpeed() {
        return speedField.getText();
    }

    public void setSquare(int square) {
        squareField.setText(String.valueOf(square));
    }

    public void close() {
        frame.dispose();
    }
}
