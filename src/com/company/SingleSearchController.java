package com.company;

public class SingleSearchController {
    private SingleSearchView singleSearchView;

    public void setSingleSearchView(SingleSearchView singleSearchView) {
        this.singleSearchView = singleSearchView;
    }

    public void start() {
        singleSearchView.create();
    }
}
