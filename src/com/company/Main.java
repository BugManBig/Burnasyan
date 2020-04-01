package com.company;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        MenuView menuView = new MenuView();
        MenuController menuController = new MenuController();
        menuView.setMenuController(menuController);
        menuController.setMenuView(menuView);
        menuController.start();
    }
}
