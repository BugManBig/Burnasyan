package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

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
    private JLabel metavirPqLabel;
    private JLabel metavir10Label;
    private JLabel metavir3Label;
    private JComboBox<String> metavirCombo;

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
        createLabel("Шкала METAVIR", 450, 60);

        createLabel("кПа", 250, 100);
        createLabel("кПа", 250, 140);
        createLabel("кПа", 250, 180);
        createLabel("кПа", 250, 270);

        createLabel("%", 380, 100);
        createLabel("%", 380, 140);
        createLabel("%", 380, 180);
        createLabel("%", 380, 270);


        KeyAdapter keyAdapter = new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                elastoController.handleKeyRelease();
            }
        };

        elast3mmField = new JTextField();
        elast3mmField.setBounds(140, 100, 100, 30);
        elast3mmField.setFont(Params.FONT);
        elast3mmField.addKeyListener(keyAdapter);
        frame.add(elast3mmField);

        elast10mmField = new JTextField();
        elast10mmField.setBounds(140, 140, 100, 30);
        elast10mmField.setFont(Params.FONT);
        elast10mmField.addKeyListener(keyAdapter);
        frame.add(elast10mmField);

        elastPqField = new JTextField();
        elastPqField.setBounds(140, 180, 100, 30);
        elastPqField.setFont(Params.FONT);
        elastPqField.addKeyListener(keyAdapter);
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

        metavir3Label = new JLabel();
        metavir3Label.setBounds(450, 100, 50, 30);
        metavir3Label.setFont(Params.FONT);
        frame.add(metavir3Label);

        metavir10Label = new JLabel();
        metavir10Label.setBounds(450, 140, 50, 30);
        metavir10Label.setFont(Params.FONT);
        frame.add(metavir10Label);

        metavirPqLabel = new JLabel();
        metavirPqLabel.setBounds(450, 180, 50, 30);
        metavirPqLabel.setFont(Params.FONT);
        frame.add(metavirPqLabel);

        metavirCombo = new JComboBox<>(new String[]{"F0-F1", "F2", "F3", "F4", "F1-F2", "F2-F3", "F3-F4"});
        metavirCombo.setBounds(450, 220, 100, 30);
        metavirCombo.setFont(Params.FONT);
        frame.add(metavirCombo);


        JPanel panel = new JPanel();
        panel.setBounds(10, 60, 565, 160);
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

    public void setMetavir3Label(String text) {
        metavir3Label.setText(text);
    }

    public void setMetavir10Label(String text) {
        metavir10Label.setText(text);
    }

    public void setMetavirPqLabel(String text) {
        metavirPqLabel.setText(text);
    }

    public void setSelectedMetavir(int id) {
        metavirCombo.setSelectedIndex(id);
    }

    public String getMetavir() {
        return (String) metavirCombo.getSelectedItem();
    }

    public void close() {
        frame.dispose();
    }
}
