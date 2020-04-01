package com.company;

public class AddController {
    private AddView addView;

    public void setAddView(AddView addView) {
        this.addView = addView;
    }

    public void start() {
        addView.create();
    }

    public void setPatient(int id) {

    }

    public void handleSelectPatientButtonClick() {
        PatientView patientView = new PatientView();
        PatientController patientController = new PatientController();
        patientView.setPatientController(patientController);
        patientController.setPatientView(patientView);
        patientController.start();
    }
}
