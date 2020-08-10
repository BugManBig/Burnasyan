package com.company;

public class ElastoController {
    private ElastoView elastoView;

    public void setElastoView(ElastoView elastoView) {
        this.elastoView = elastoView;
    }

    public void start() {
        elastoView.create();
    }

    public void handleNextButtonClick() {


        elastoView.close();
    }
}
