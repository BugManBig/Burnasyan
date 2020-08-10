package com.company;

public class SkoplenieController {
    private SkoplenieView skoplenieView;

    public void setSkoplenieView(SkoplenieView skoplenieView) {
        this.skoplenieView = skoplenieView;
    }

    public void start() {
        skoplenieView.create();
    }

    public void handleNextButtonClick() {
        Task task = ModelSingleton.getModel().getTask();
        task.skoplenieIs = skoplenieView.getComboBox();
        task.skoplenieComment = skoplenieView.getComment();



        skoplenieView.close();
    }
}
