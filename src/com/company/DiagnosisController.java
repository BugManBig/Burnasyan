package com.company;

public class DiagnosisController {
    private Model model = ModelSingleton.getModel();
    private DiagnosisView diagnosisView;

    public void setDiagnosisView(DiagnosisView diagnosisView) {
        this.diagnosisView = diagnosisView;
    }

    public void start() {
        diagnosisView.create();
    }

    public void handleSelectButtonClick() {
        DiagnosisSelectorView diagnosisSelectorView = new DiagnosisSelectorView();
        DiagnosisSelectorController diagnosisSelectorController = new DiagnosisSelectorController();
        diagnosisSelectorController.setDiagnosisSelectorView(diagnosisSelectorView);
        diagnosisSelectorController.setDiagnosisController(this);
        diagnosisSelectorView.setDiagnosisSelectorController(diagnosisSelectorController);
        diagnosisSelectorController.start();
    }

    public void setDiagnosis(String text) {
        diagnosisView.setDiagnosisLabel(text);
    }

    public void handleNextButtonClick() {
        model.getTask().diagnosis = diagnosisView.getDiagnosis();

        diagnosisView.close();
    }
}
