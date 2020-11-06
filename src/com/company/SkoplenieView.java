package com.company;

import javax.swing.*;

public class SkoplenieView {
    private SkoplenieController skoplenieController;

    private JFrame frame;
    private JComboBox<String> comboBox;
    private JTextArea commentArea;

    public void setSkoplenieController(SkoplenieController skoplenieController) {
        this.skoplenieController = skoplenieController;
    }

    public void create() {
        frame = Params.createFrame();

        createLabel("Ограниченное скопление:", 200, 20);
        createLabel("Присутствует:", 20, 60);
        createLabel("Комментарий:", 20, 100);

        comboBox = new JComboBox<>(new String[]{"---", "Да", "Нет"});
        comboBox.setBounds(140, 60, 100, 30);
        comboBox.setFont(Params.FONT);
        frame.add(comboBox);

        commentArea = new JTextArea();
        commentArea.setBounds(140, 100, 300, 150);
        commentArea.setFont(Params.FONT);
        commentArea.setLineWrap(true);
        commentArea.setWrapStyleWord(true);
        frame.add(commentArea);

        JButton nextButton = new JButton("Далее");
        nextButton.addActionListener(e -> skoplenieController.handleNextButtonClick());
        nextButton.setBounds(450, 300, 100, 30);
        frame.add(nextButton);

        frame.setVisible(true);
    }

    private void createLabel(String text, int x, int y) {
        JLabel label = new JLabel(text);
        label.setBounds(x, y, text.length() < 10 ? 120 : 200, 30);
        label.setFont(Params.FONT);
        frame.add(label);
    }

    public String getComboBox() {
        return (String) comboBox.getSelectedItem();
    }

    public String getComment() {
        return commentArea.getText().replaceAll("\n", "\\$");
    }

    public void close() {
        frame.dispose();
    }
}
