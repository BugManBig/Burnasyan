package com.company;

import javax.swing.*;

public class SizesView {
    private JFrame frame;
    private JTextField sizesField;
    private SizesController sizesController;

    public void setSizesController(SizesController sizesController) {
        this.sizesController = sizesController;
    }

    public void create() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setVisible(true);

        JLabel sizesTitleLabel = new JLabel("Sizes:");
        sizesTitleLabel.setBounds(20, 20, 50, 30);
        sizesTitleLabel.setFont(Params.FONT);
        frame.add(sizesTitleLabel);

        sizesField = new JTextField();
        sizesField.setBounds(80, 20, 100, 30);
        sizesField.setFont(Params.FONT);
        frame.add(sizesField);

        JButton nextButton = new JButton("Next");
        nextButton.addActionListener(e -> sizesController.handleNextButtonClick());
        nextButton.setBounds(450, 300, 100, 30);
        frame.add(nextButton);

        frame.repaint();
    }

    public String getSizes() {
        return sizesField.getText();
    }

    public void close() {
        frame.dispose();
    }
}
