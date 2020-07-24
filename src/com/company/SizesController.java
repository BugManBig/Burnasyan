package com.company;

public class SizesController {
    private Model model = ModelSingleton.getModel();
    private SizesView sizesView;

    public void setSizesView(SizesView sizesView) {
        this.sizesView = sizesView;
    }

    public void start() {
        sizesView.create();
    }

    public void handleNextButtonClick() {
        model.getTask().sizes = sizesView.getSizes();
    }
}