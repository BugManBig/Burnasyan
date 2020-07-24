package com.company;

import javax.swing.*;

public class DiagnosisView {
    private JFrame frame;
    private JLabel diagnosisLabel;

    public void create() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setVisible(true);

        JLabel diagnosisTitleLabel = new JLabel("Diagnosis:");
        diagnosisTitleLabel.setBounds(20, 20, 80, 30);
        diagnosisTitleLabel.setFont(Params.FONT);
        frame.add(diagnosisTitleLabel);

        diagnosisLabel = new JLabel();
        diagnosisLabel.setBounds(100, 20, 400, 30);
        diagnosisLabel.setFont(Params.FONT);
        frame.add(diagnosisLabel);

        JButton nextButton = new JButton("Next");
        //nextButton.addActionListener(e -> sizesController.handleNextButtonClick());
        nextButton.setBounds(450, 300, 100, 30);
        frame.add(nextButton);

        frame.repaint();
    }
}
