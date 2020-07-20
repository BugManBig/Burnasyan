package com.company;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AddController {
    private AddView addView;
    private Model model = ModelSingleton.getModel();

    public void setAddView(AddView addView) {
        this.addView = addView;
    }

    public void start() {
        addView.create();
        LocalDateTime now = LocalDateTime.now();
        addView.setDateField(now.format(DateTimeFormatter.ofPattern("dd.MM.yyyy")));
    }

    public void setPatient(int id) {
        addView.setPatientLabel(model.getPatient(id).getFio());
    }

    public void handleSelectPatientButtonClick() {
        PatientSelectorView patientSelectorView = new PatientSelectorView();
        PatientSelectorController patientSelectorController = new PatientSelectorController();
        patientSelectorView.setPatientSelectorController(patientSelectorController);
        patientSelectorController.setPatientSelectorView(patientSelectorView);
        patientSelectorController.setAddController(this);
        patientSelectorController.start();
    }

    public void handleSelectDoctorButtonClick() {
        DoctorSelectorView doctorSelectorView = new DoctorSelectorView();
        DoctorSelectorController doctorSelectorController = new DoctorSelectorController();
        doctorSelectorView.setDoctorSelectorController(doctorSelectorController);
        doctorSelectorController.setDoctorSelectorView(doctorSelectorView);
        doctorSelectorController.setAddController(this);
        doctorSelectorController.start();
    }

    public void setDoctor(int id) {
        addView.setDoctorNameLabel(model.getDoctor(id).getFio());
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
