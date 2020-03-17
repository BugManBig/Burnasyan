package com.company;

public class AddController {
    private AddView addView;

    public void setAddView(AddView addView) {
        this.addView = addView;
    }

    public void start() {
        addView.create();
    }
}
