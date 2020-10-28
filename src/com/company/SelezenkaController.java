package com.company;

public class SelezenkaController {
    private SelezenkaView selezenkaView;

    public void setSelezenkaView(SelezenkaView selezenkaView) {
        this.selezenkaView = selezenkaView;
    }

    public void start() {
        selezenkaView.create();
    }

    public void handleNextButtonClick() {
        Task task = ModelSingleton.getModel().getTask();
        task.selezenkaSizes = selezenkaView.getSizes();
        task.selezenkaSquare = selezenkaView.getSquare();
        task.selezenkaDiameter = selezenkaView.getDiameter();
        task.selezenkaSpeed = selezenkaView.getSpeed();

        LiquidView liquidView = new LiquidView();
        LiquidController liquidController = new LiquidController();
        liquidView.setLiquidController(liquidController);
        liquidController.setLiquidView(liquidView);
        liquidController.start();

        selezenkaView.close();
    }
}
