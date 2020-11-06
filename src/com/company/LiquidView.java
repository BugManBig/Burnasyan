package com.company;

import javax.swing.*;

public class LiquidView {
    private LiquidController liquidController;

    private JFrame frame;
    private JComboBox<String> liquidComboBox;
    private JTextArea commentArea;
    private JComboBox<String> dividingComboBox;

    public void setLiquidController(LiquidController liquidController) {
        this.liquidController = liquidController;
    }

    public void create() {
        frame = Params.createFrame();

        createLabel("Свободная жидкость:", 200, 20);
        createLabel("Жидкость:", 20, 60);
        createLabel("Комментарий:", 20, 100);
        createLabel("Расщепление", 20, 250);
        createLabel("листков брюшины:", 20, 270);

        liquidComboBox = new JComboBox<>(new String[]{"---", "Да", "Нет"});
        liquidComboBox.setBounds(180, 60, 100, 30);
        liquidComboBox.setFont(Params.FONT);
        frame.add(liquidComboBox);

        commentArea = new JTextArea();
        commentArea.setBounds(180, 100, 300, 150);
        commentArea.setFont(Params.FONT);
        commentArea.setLineWrap(true);
        commentArea.setWrapStyleWord(true);
        frame.add(commentArea);

        dividingComboBox = new JComboBox<>(new String[]{"---", "Да", "Нет"});
        dividingComboBox.setBounds(180, 270, 100, 30);
        dividingComboBox.setFont(Params.FONT);
        frame.add(dividingComboBox);

        JButton nextButton = new JButton("Далее");
        nextButton.addActionListener(e -> liquidController.handleNextButtonClick());
        nextButton.setBounds(450, 300, 100, 30);
        frame.add(nextButton);

        frame.setVisible(true);
    }

    private void createLabel(String text, int x, int y) {
        JLabel label = new JLabel(text);
        label.setBounds(x, y, 160, 30);
        label.setFont(Params.FONT);
        frame.add(label);
    }

    public String getLiquid() {
        return (String) liquidComboBox.getSelectedItem();
    }

    public String getComment() {
        return commentArea.getText().replaceAll("\n", "$");
    }

    public String getDividing() {
        return (String) dividingComboBox.getSelectedItem();
    }

    public void close() {
        frame.dispose();
    }
}
