package com.company;

public class HoledohController {
    private HoledohView holedohView;

    public void setHoledohView(HoledohView holedohView) {
        this.holedohView = holedohView;
    }

    public void start() {
        holedohView.create();
    }

    public void handleNextButtonClick() {
        Task task = ModelSingleton.getModel().getTask();
        task.holedohVis = holedohView.getComboBoxText();
        task.holedohSizes = holedohView.getSizes();
        task.info();
        holedohView.close();
    }
}
