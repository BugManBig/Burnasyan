package com.company;

import javax.swing.*;

public class DiagnosisView {
    private JFrame frame;
    private JLabel diagnosisLabel;
    private DiagnosisController diagnosisController;

    public void setDiagnosisController(DiagnosisController diagnosisController) {
        this.diagnosisController = diagnosisController;
    }

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

        JButton selectButton = new JButton("Select");
        selectButton.setBounds(20, 60, 100, 30);
        selectButton.addActionListener(e -> diagnosisController.handleSelectButtonClick());
        frame.add(selectButton);

        JButton nextButton = new JButton("Next");
        nextButton.addActionListener(e -> diagnosisController.handleNextButtonClick());
        nextButton.setBounds(450, 300, 100, 30);
        frame.add(nextButton);

        frame.repaint();
    }

    public void setDiagnosisLabel(String text) {
        diagnosisLabel.setText(text);
    }

    public String getDiagnosis() {
        return diagnosisLabel.getText();
    }

    public void close() {
        frame.dispose();
    }
}
