package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class BiohimView {
    private BiohimController biohimController;

    private JFrame frame;
    private JTextField obshijField;
    private JTextField pryamojTextfield;
    private JTextField altField;
    private JTextField astField;
    private JTextField ggtField;
    private JTextField schfField;
    private JTextField srbField;

    public String getObshij() {
        return obshijField.getText();
    }

    public String getPryamoj() {
        return pryamojTextfield.getText();
    }

    public String getAlt() {
        return altField.getText();
    }

    public String getAst() {
        return astField.getText();
    }

    public String getGgt() {
        return ggtField.getText();
    }

    public String getSchf() {
        return schfField.getText();
    }

    public String getSrb() {
        return srbField.getText();
    }

    public void setBiohimController(BiohimController biohimController) {
        this.biohimController = biohimController;
    }

    public void create() {
        frame = Params.createFrame();

        createLabel("Биохимический анализ крови", 150, 10);
        createLabel("Билирубин", 10, 70);
        createLabel("Общий:", 100, 50);
        createLabel("Прямой:", 100, 90);
        createLabel("АЛТ:", 100, 130);
        createLabel("АСТ:", 100, 170);
        createLabel("ГГТ:", 100, 210);
        createLabel("ЩФ:", 100, 250);
        createLabel("С-РБ:", 100, 290);

        createLabel("5-21", 250, 50);
        createLabel("0-5.1", 250, 90);
        createLabel("5-33", 250, 130);
        createLabel("5-32", 250, 170);
        createLabel("6-40", 250, 210);
        createLabel("30-120", 250, 250);
        createLabel("0-5", 250, 290);

        createLabel("(мкмоль/л)", 310, 50);
        createLabel("(мкмоль/л)", 310, 90);
        createLabel("(Е/л)", 310, 130);
        createLabel("(Е/л)", 310, 170);
        createLabel("(Е/л)", 310, 210);
        createLabel("(Е/л)", 310, 250);
        createLabel("(мг/л)", 310, 290);

        obshijField = createTextfield(50, 5, 21);
        pryamojTextfield = createTextfield(90, 0, 5);
        altField = createTextfield(130, 5, 33);
        astField = createTextfield(170, 5, 32);
        ggtField = createTextfield(210, 6, 40);
        schfField = createTextfield(250, 30, 120);
        srbField = createTextfield(290, 0, 5);

        JButton nextButton = new JButton("Далее");
        nextButton.setBounds(450, 300, 100, 30);
        nextButton.addActionListener(e -> biohimController.handleNextButtonClick());
        frame.add(nextButton);

        frame.setVisible(true);
    }

    private void createLabel(String text, int x, int y) {
        JLabel label = new JLabel(text);
        label.setBounds(x, y, text.length() > 20 ? 300 : 80, 30);
        label.setFont(Params.FONT);
        frame.add(label);
    }

    private JTextField createTextfield(int yOffset, int from, int to) {
        JTextField textField = new JTextField();
        textField.setBounds(180, yOffset, 60, 30);
        textField.setFont(Params.FONT);
        textField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                double value;
                try {
                    value = Double.parseDouble(textField.getText().replace(',', '.'));
                } catch (NumberFormatException ignored) {
                    value = from;
                }
                textField.setBackground(value < from || value > to ? new Color(0xFF9D8F) : Color.WHITE);
            }
        });
        frame.add(textField);
        return textField;
    }

    public void close() {
        frame.dispose();
    }
}
