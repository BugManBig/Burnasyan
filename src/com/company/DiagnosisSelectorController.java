package com.company;

import javax.swing.*;
import java.io.File;
import java.nio.file.Files;
import java.util.List;

public class DiagnosisSelectorController {
    private Model model = ModelSingleton.getModel();
    private DiagnosisSelectorView diagnosisSelectorView;
    private DiagnosisController diagnosisController;
    private List<String> diagnosesList;

    public void setDiagnosisController(DiagnosisController diagnosisController) {
        this.diagnosisController = diagnosisController;
    }

    public void setDiagnosisSelectorView(DiagnosisSelectorView diagnosisSelectorView) {
        this.diagnosisSelectorView = diagnosisSelectorView;
    }

    public void start() {
        diagnosisSelectorView.create();
        update();
    }

    private void update() {
        model.readDiagnosis();
        diagnosesList = model.getDiagnosis();
        diagnosisSelectorView.setListData(diagnosesList.toArray(new String[0]));
    }

    public void handleSelectButtonClick() {
        diagnosisController.setDiagnosis(diagnosesList.get(diagnosisSelectorView.getSelectedIndex()));
        diagnosisSelectorView.close();
    }

    public void handleAddButtonClick() {
        String diagnosis = JOptionPane.showInputDialog("Enter new diagnosis");
        if (diagnosis == null) {
            return;
        }
        model.addDiagnosis(diagnosis);
        update();
    }
}
