package com.company;

import javax.swing.*;
import java.awt.*;

public class ElastoView {
    private ElastoController elastoController;

    private JFrame frame;

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
        createLabel("Погрешность:", 20, 320);

        createLabel("кПа", 250, 100);
        createLabel("кПа", 250, 140);
        createLabel("кПа", 250, 180);
        createLabel("кПа", 250, 270);
        createLabel("%", 250, 320);

        JTextField elast3mmField = new JTextField();
        elast3mmField.setBounds(140, 100, 100, 30);
        elast3mmField.setFont(Params.FONT);
        frame.add(elast3mmField);

        JTextField elast10mmField = new JTextField();
        elast10mmField.setBounds(140, 140, 100, 30);
        elast10mmField.setFont(Params.FONT);
        frame.add(elast10mmField);

        JTextField elastPqField = new JTextField();
        elastPqField.setBounds(140, 180, 100, 30);
        elastPqField.setFont(Params.FONT);
        frame.add(elastPqField);

        JTextField elastSelezField = new JTextField();
        elastSelezField.setBounds(140, 270, 100, 30);
        elastSelezField.setFont(Params.FONT);
        frame.add(elastSelezField);

        JTextField inaccuracyField = new JTextField();
        inaccuracyField.setBounds(140, 320, 100, 30);
        inaccuracyField.setFont(Params.FONT);
        frame.add(inaccuracyField);

        /*
        JPanel panel = new JPanel();
        panel.setBounds(10, 60, 280, 160);
        panel.setBackground(Color.decode("0xCCCCCC"));
        frame.add(panel);

        panel = new JPanel();
        panel.setBounds(10, 230, 280, 130);
        panel.setBackground(Color.decode("0xCCCCCC"));
        frame.add(panel);

         */

        frame.setVisible(true);
    }

    private void createLabel(String text, int x, int y) {
        JLabel label = new JLabel(text);
        label.setBounds(x, y, 120, 30);
        label.setFont(Params.FONT);
        frame.add(label);
    }

    public void close() {
        frame.dispose();
    }
}
