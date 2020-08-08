package com.company;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class AddController {
    private AddView addView;
    private Model model = ModelSingleton.getModel();

    public void setAddView(AddView addView) {
        this.addView = addView;
    }

    public void start() {
        addView.create();
        LocalDate now = LocalDate.now();
        addView.setDateField(now.format(DateTimeFormatter.ofPattern("dd.MM.yyyy")));
        model.createTask();
    }

    public void handleSelectDoctorButtonClick() {
        DoctorSelectorView doctorSelectorView = new DoctorSelectorView();
        DoctorSelectorController doctorSelectorController = new DoctorSelectorController();
        doctorSelectorView.setDoctorSelectorController(doctorSelectorController);
        doctorSelectorController.setDoctorSelectorView(doctorSelectorView);
        doctorSelectorController.setAddController(this);
        doctorSelectorController.start();
    }

    public void handleSelectPatientButtonClick() {
        PatientSelectorView patientSelectorView = new PatientSelectorView();
        PatientSelectorController patientSelectorController = new PatientSelectorController();
        patientSelectorView.setPatientSelectorController(patientSelectorController);
        patientSelectorController.setPatientSelectorView(patientSelectorView);
        patientSelectorController.setAddController(this);
        patientSelectorController.start();
    }

    public void setDoctor(int id) {
        model.getTask().doctorId = id;
        addView.setDoctorNameLabel(model.getDoctor(id).getFio());
    }

    public void updatePatientField() {
        Person patient = model.getPatient(model.getTask().patientId);
        int age = Period.between(patient.getBirthday(), addView.getDate()).getYears();
        addView.setPatientFioLabel(patient.getFio() + " (" + age + " years old)");
    }

    public void handleNextButtonClick() {
        model.getTask().date = addView.getDateString();
        DiagnosisView diagnosisView = new DiagnosisView();
        DiagnosisController diagnosisController = new DiagnosisController();
        diagnosisView.setDiagnosisController(diagnosisController);
        diagnosisController.setDiagnosisView(diagnosisView);
        diagnosisController.start();
        addView.close();
    }

    public void handleKeyRelease() {
        if (addView.getDate() == null) {
            return;
        }
        updatePatientField();
    }
}
