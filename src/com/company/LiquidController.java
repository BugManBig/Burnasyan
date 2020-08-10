package com.company;

public class LiquidController {
    private LiquidView liquidView;

    public void setLiquidView(LiquidView liquidView) {
        this.liquidView = liquidView;
    }

    public void start() {
        liquidView.create();
    }

    public void handleNextButtonClick() {
        Task task = ModelSingleton.getModel().getTask();
        task.liquidIs = liquidView.getLiquid();
        task.liquidComment = liquidView.getComment();
        task.liquidDividing = liquidView.getDividing();

        SkoplenieView skoplenieView = new SkoplenieView();
        SkoplenieController skoplenieController = new SkoplenieController();
        skoplenieView.setSkoplenieController(skoplenieController);
        skoplenieController.setSkoplenieView(skoplenieView);
        skoplenieController.start();

        liquidView.close();
    }
}
