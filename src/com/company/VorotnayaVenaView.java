package com.company;

import javax.swing.*;

public class VorotnayaVenaView {
    private VorotnayaVenaController vorotnayaVenaController;

    private JFrame frame;

    private JTextField sizeBeforeField;
    private JTextField sizeAfterField;
    private JTextField speedBeforeField;
    private JTextField speedAfterField;
    private JTextArea commentArea;

    public void setVorotnayaVenaController(VorotnayaVenaController vorotnayaVenaController) {
        this.vorotnayaVenaController = vorotnayaVenaController;
    }

    public void create() {
        frame = Params.createFrame();

        createLabel("Воротная вена", 250, 20);
        createLabel("Диаметр:", 120, 60);
        createLabel("До анастомоза:", 20, 100);
        createLabel("После анастомоза:", 20, 140);
        createLabel("Скорость:", 120, 190);
        createLabel("До анастомоза:", 20, 230);
        createLabel("После анастомоза:", 20, 270);
        createLabel("Комментарий:", 310, 60);
        createLabel("мм", 280, 100);
        createLabel("мм", 280, 140);
        createLabel("см/с", 280, 230);
        createLabel("см/с", 280, 270);

        sizeBeforeField = new JTextField();
        sizeBeforeField.setBounds(170, 100, 100, 30);
        sizeBeforeField.setFont(Params.FONT);
        frame.add(sizeBeforeField);

        sizeAfterField = new JTextField();
        sizeAfterField.setBounds(170, 140, 100, 30);
        sizeAfterField.setFont(Params.FONT);
        frame.add(sizeAfterField);

        speedBeforeField = new JTextField();
        speedBeforeField.setBounds(170, 230, 100, 30);
        speedBeforeField.setFont(Params.FONT);
        frame.add(speedBeforeField);

        speedAfterField = new JTextField();
        speedAfterField.setBounds(170, 270, 100, 30);
        speedAfterField.setFont(Params.FONT);
        frame.add(speedAfterField);

        commentArea = new JTextArea();
        commentArea.setBounds(310, 100, 200, 100);
        commentArea.setFont(Params.FONT);
        commentArea.setLineWrap(true);
        commentArea.setWrapStyleWord(true);
        frame.add(commentArea);


        JButton nextButton = new JButton("Далее");
        nextButton.addActionListener(e -> vorotnayaVenaController.handleNextButtonClick());
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

    public String getSizeBefore() {
        return sizeBeforeField.getText();
    }

    public String getSizeAfter() {
        return sizeAfterField.getText();
    }

    public String getSpeedBefore() {
        return speedBeforeField.getText();
    }

    public String getSpeedAfter() {
        return speedAfterField.getText();
    }

    public String getComment() {
        return commentArea.getText().replaceAll("\n", "\\$");
    }

    public void close() {
        frame.dispose();
    }
}
