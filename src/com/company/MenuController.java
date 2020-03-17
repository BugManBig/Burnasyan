package com.company;

public class MenuController {
    private MenuView menuView;

    public void setMenuView(MenuView menuView) {
        this.menuView = menuView;
    }

    public void start() {
        menuView.create();
    }

    public void handleAddButtonClick() {

    }
}
