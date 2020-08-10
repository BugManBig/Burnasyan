package com.company;

public class LiverVenyController {
    private LiverVenyView liverVenyView;

    public void setLiverVenyView(LiverVenyView liverVenyView) {
        this.liverVenyView = liverVenyView;
    }

    public void start() {
        liverVenyView.create();
    }

    public void handleNextButtonClick() {
        Task task = ModelSingleton.getModel().getTask();
        task.liverType = liverVenyView.getType();
        task.liverSpeed = liverVenyView.getSpeed();

        SelezenkaView selezenkaView = new SelezenkaView();
        SelezenkaController selezenkaController = new SelezenkaController();
        selezenkaView.setSelezenkaController(selezenkaController);
        selezenkaController.setSelezenkaView(selezenkaView);
        selezenkaController.start();

        liverVenyView.close();
    }
}
