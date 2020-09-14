package com.company;

public class VorotnayaVenaController {
    private VorotnayaVenaView vorotnayaVenaView;

    public void setVorotnayaVenaView(VorotnayaVenaView vorotnayaVenaView) {
        this.vorotnayaVenaView = vorotnayaVenaView;
    }

    public void start() {
        vorotnayaVenaView.create();
    }

    public void handleNextButtonClick() {
        Task task = ModelSingleton.getModel().getTask();
        task.vorotnayaSizeBefore = vorotnayaVenaView.getSizeBefore();
        task.vorotnayaSizeAfter = vorotnayaVenaView.getSizeAfter();
        task.vorotnayaSpeedBefore = vorotnayaVenaView.getSpeedBefore();
        task.vorotnayaSpeedAfter = vorotnayaVenaView.getSpeedAfter();
        task.vorotnayaComment = vorotnayaVenaView.getComment();

        ArteryView arteryView = new ArteryView();
        ArteryController arteryController = new ArteryController();
        arteryView.setArteryController(arteryController);
        arteryController.setArteryView(arteryView);
        arteryController.start();

        vorotnayaVenaView.close();
    }
}
