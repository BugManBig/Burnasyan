package com.company;

import javax.swing.*;
import java.awt.*;

public class ElastoView {
    private ElastoController elastoController;

    private JFrame frame;
    private JTextField elast3mmField;
    private JTextField elast10mmField;
    private JTextField elastPqField;
    private JTextField elastSelezField;
    private JTextField inaccuracyField1;
    private JTextField inaccuracyField2;
    private JTextField inaccuracyField3;
    private JTextField inaccuracyField4;

    public void setElastoController(ElastoController elastoController) {
        this.elastoController = elastoController;
    }

    public void create() {
        frame = Params.createFrame();

        JButton nextButton = new JButton("Далее");
        nextButton.addActionListener(e -> elastoController.handleNextButtonClick());
        nextButton.setBounds(450, 300, 100, 30);
        frame.add(nextButton);

        createLabel("Эластометрия", 200, 20);
        createLabel("Печени:", 20, 60);
        createLabel("ElastQ 3mm:", 20, 100);
        createLabel("ElastQ 10mm:", 20, 140);
        createLabel("ElastPQ:", 20, 180);
        createLabel("Селезёнки:", 20, 230);
        createLabel("ElastQ 3mm:", 20, 270);
        createLabel("Погрешность:", 320, 60);

        createLabel("кПа", 250, 100);
        createLabel("кПа", 250, 140);
        createLabel("кПа", 250, 180);
        createLabel("кПа", 250, 270);

        createLabel("%", 380, 100);
        createLabel("%", 380, 140);
        createLabel("%", 380, 180);
        createLabel("%", 380, 270);

        elast3mmField = new JTextField();
        elast3mmField.setBounds(140, 100, 100, 30);
        elast3mmField.setFont(Params.FONT);
        frame.add(elast3mmField);

        elast10mmField = new JTextField();
        elast10mmField.setBounds(140, 140, 100, 30);
        elast10mmField.setFont(Params.FONT);
        frame.add(elast10mmField);

        elastPqField = new JTextField();
        elastPqField.setBounds(140, 180, 100, 30);
        elastPqField.setFont(Params.FONT);
        frame.add(elastPqField);

        elastSelezField = new JTextField();
        elastSelezField.setBounds(140, 270, 100, 30);
        elastSelezField.setFont(Params.FONT);
        frame.add(elastSelezField);

        inaccuracyField1 = new JTextField();
        inaccuracyField1.setBounds(320, 100, 50, 30);
        inaccuracyField1.setFont(Params.FONT);
        frame.add(inaccuracyField1);

        inaccuracyField2 = new JTextField();
        inaccuracyField2.setBounds(320, 140, 50, 30);
        inaccuracyField2.setFont(Params.FONT);
        frame.add(inaccuracyField2);

        inaccuracyField3 = new JTextField();
        inaccuracyField3.setBounds(320, 180, 50, 30);
        inaccuracyField3.setFont(Params.FONT);
        frame.add(inaccuracyField3);

        inaccuracyField4 = new JTextField();
        inaccuracyField4.setBounds(320, 270, 50, 30);
        inaccuracyField4.setFont(Params.FONT);
        frame.add(inaccuracyField4);


        JPanel panel = new JPanel();
        panel.setBounds(10, 60, 420, 160);
        panel.setBackground(Color.decode("0xCCCCCC"));
        frame.add(panel);

        panel = new JPanel();
        panel.setBounds(10, 230, 420, 80);
        panel.setBackground(Color.decode("0xCCCCCC"));
        frame.add(panel);


        frame.setVisible(true);
    }

    private void createLabel(String text, int x, int y) {
        JLabel label = new JLabel(text);
        label.setBounds(x, y, text.length() < 4 ? 50 : 120, 30);
        label.setFont(Params.FONT);
        frame.add(label);
    }

    public String getElast3() {
        return elast3mmField.getText();
    }

    public String getElast10() {
        return elast10mmField.getText();
    }

    public String getElastPq() {
        return elastPqField.getText();
    }

    public String getElastSelez() {
        return elastSelezField.getText();
    }

    public String getInaccuracy1() {
        return inaccuracyField1.getText();
    }

    public String getInaccuracy2() {
        return inaccuracyField2.getText();
    }

    public String getInaccuracy3() {
        return inaccuracyField3.getText();
    }

    public String getInaccuracy4() {
        return inaccuracyField4.getText();
    }

    public void close() {
        frame.dispose();
    }
}
