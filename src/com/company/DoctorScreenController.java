package com.company;

public class DoctorScreenController {
    private Model model = ModelSingleton.getModel();
    private DoctorScreenView doctorScreenView;

    public void setDoctorScreenView(DoctorScreenView doctorScreenView) {
        this.doctorScreenView = doctorScreenView;
    }

    public void handleSelectDoctorButtonClick() {
        DoctorSelectorView doctorSelectorView = new DoctorSelectorView();
        DoctorSelectorController doctorSelectorController = new DoctorSelectorController();
        doctorSelectorView.setDoctorSelectorController(doctorSelectorController);
        doctorSelectorController.setDoctorSelectorView(doctorSelectorView);
        //doctorSelectorController.setAddController(this);
        doctorSelectorController.start();
    }

    public void setDoctor(int id) {
        doctorScreenView.setDoctorLabel(model.getDoctor(id).getFio());
    }

    public void start() {
        doctorScreenView.create();
    }
}
