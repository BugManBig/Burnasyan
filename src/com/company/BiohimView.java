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

        createLabel(Params.getRange(BiohimType.OBSHIJ).toString(), 250, 50);
        createLabel(Params.getRange(BiohimType.PRYAMOJ).toString(), 250, 90);
        createLabel(Params.getRange(BiohimType.ALT).toString(), 250, 130);
        createLabel(Params.getRange(BiohimType.AST).toString(), 250, 170);
        createLabel(Params.getRange(BiohimType.GGT).toString(), 250, 210);
        createLabel(Params.getRange(BiohimType.SCHF).toString(), 250, 250);
        createLabel(Params.getRange(BiohimType.SRB).toString(), 250, 290);

        createLabel("(мкмоль/л)", 310, 50);
        createLabel("(мкмоль/л)", 310, 90);
        createLabel("(Е/л)", 310, 130);
        createLabel("(Е/л)", 310, 170);
        createLabel("(Е/л)", 310, 210);
        createLabel("(Е/л)", 310, 250);
        createLabel("(мг/л)", 310, 290);

        obshijField = createTextfield(50, BiohimType.OBSHIJ);
        pryamojTextfield = createTextfield(90, BiohimType.PRYAMOJ);
        altField = createTextfield(130, BiohimType.ALT);
        astField = createTextfield(170, BiohimType.AST);
        ggtField = createTextfield(210, BiohimType.GGT);
        schfField = createTextfield(250, BiohimType.SCHF);
        srbField = createTextfield(290, BiohimType.SRB);

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

    private JTextField createTextfield(int yOffset, BiohimType type) {
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
                    textField.setBackground(Color.WHITE);
                    return;
                }
                Range range = Params.getRange(type);
                if (value < range.getFrom() || value > range.getTo()) {
                    textField.setBackground(Params.NOT_IN_RANGE_COLOR);
                } else {
                    textField.setBackground(Color.WHITE);
                }
            }
        });
        frame.add(textField);
        return textField;
    }

    public void close() {
        frame.dispose();
    }
}
