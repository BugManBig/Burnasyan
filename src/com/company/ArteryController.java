package com.company;

public class ArteryController {
    private ArteryView arteryView;

    public void setArteryView(ArteryView arteryView) {
        this.arteryView = arteryView;
    }

    public void start() {
        arteryView.create();
    }

    public void handleNextButtonClick() {
        Task task = ModelSingleton.getModel().getTask();
        task.arteryVis = arteryView.getComboBox();
        task.arterySpeed = arteryView.getSpeedField();
        task.arteryIr = arteryView.getIrField();

        LiverVenyView liverVenyView = new LiverVenyView();
        LiverVenyController liverVenyController = new LiverVenyController();
        liverVenyView.setLiverVenyController(liverVenyController);
        liverVenyController.setLiverVenyView(liverVenyView);
        liverVenyController.start();

        arteryView.close();
    }
}
