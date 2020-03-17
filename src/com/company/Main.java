package com.company;

public class Main {
    public static void main(String[] args) {
        MenuView menuView = new MenuView();
        MenuController menuController = new MenuController();
        menuController.setMenuView(menuView);
        menuController.start();
    }
}
