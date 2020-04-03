package com.company;

public class AddController {
    private AddView addView;
    private Model model = ModelSingleton.getModel();

    public void setAddView(AddView addView) {
        this.addView = addView;
    }

    public void start() {
        addView.create();
    }

    public void setPatient(int id) {
        addView.setPatientLabel(model.getPatient(id).getFio());
    }

    public void handleSelectPatientButtonClick() {
        PatientView patientView = new PatientView();
        PatientController patientController = new PatientController();
        patientView.setPatientController(patientController);
        patientController.setPatientView(patientView);
        patientController.setAddController(this);
        patientController.start();
    }

    public void handleNextButtonClick() {
        DoctorScreenView doctorScreenView = new DoctorScreenView();
        DoctorScreenController doctorScreenController = new DoctorScreenController();
        doctorScreenView.setDoctorScreenController(doctorScreenController);
        doctorScreenController.setDoctorScreenView(doctorScreenView);
        doctorScreenController.start();
        addView.close();
    }
}
