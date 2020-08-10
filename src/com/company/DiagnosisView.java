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
        frame = Params.createFrame();

        JLabel diagnosisTitleLabel = new JLabel("Диагноз:");
        diagnosisTitleLabel.setBounds(20, 20, 80, 30);
        diagnosisTitleLabel.setFont(Params.FONT);
        frame.add(diagnosisTitleLabel);

        diagnosisLabel = new JLabel();
        diagnosisLabel.setBounds(100, 20, 400, 30);
        diagnosisLabel.setFont(Params.FONT);
        frame.add(diagnosisLabel);

        JButton selectButton = new JButton("Выбрать");
        selectButton.setBounds(20, 60, 100, 30);
        selectButton.addActionListener(e -> diagnosisController.handleSelectButtonClick());
        frame.add(selectButton);

        JButton nextButton = new JButton("Далее");
        nextButton.addActionListener(e -> diagnosisController.handleNextButtonClick());
        nextButton.setBounds(450, 300, 100, 30);
        frame.add(nextButton);

        frame.setVisible(true);
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
