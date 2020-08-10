package com.company;

public class SelezenkaController {
    private SelezenkaView selezenkaView;

    public void setSelezenkaView(SelezenkaView selezenkaView) {
        this.selezenkaView = selezenkaView;
    }

    public void start() {
        selezenkaView.create();
    }

    public void handleKeyReleased() {
        String sizes = selezenkaView.getSizes();
        int separatorPos = -1;
        for (int i = 0; i < sizes.length(); i++) {
            if (sizes.charAt(i) < 48 || sizes.charAt(i) > 57) {
                separatorPos = i;
            }
        }
        if (separatorPos == -1) {
            return;
        }
        int first;
        try {
            first = Integer.parseInt(sizes.substring(0, separatorPos));
        } catch (NumberFormatException e) {
            return;
        }
        int second;
        try {
            second = Integer.parseInt(sizes.substring(separatorPos + 1));
        } catch (NumberFormatException e) {
            return;
        }
        selezenkaView.setSquare(first * second);
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
