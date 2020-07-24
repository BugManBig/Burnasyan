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

    public void setPatient(int id) {
        model.getTask().patientId = id;
        addView.setPatientLabel(model.getPatient(id).getFio());
    }

    public void handleNextButtonClick() {
        model.getTask().date = addView.getDate();
        SizesView sizesView = new SizesView();
        SizesController sizesController = new SizesController();
        sizesView.setSizesController(sizesController);
        sizesController.setSizesView(sizesView);
        sizesController.start();
        addView.close();
    }
}
