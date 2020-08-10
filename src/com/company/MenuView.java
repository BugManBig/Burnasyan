package com.company;

import javax.swing.*;

public class MenuView {
    private MenuController menuController;
    private JFrame frame;

    public void setMenuController(MenuController menuController) {
        this.menuController = menuController;
    }

    public void create() {
        frame = Params.createFrame(300, 300);

        JButton button = new JButton("Добавить исследование");
        button.setBounds(50, 30, 180, 30);
        button.addActionListener(e -> menuController.handleAddButtonClick());
        frame.add(button);

        frame.setVisible(true);
    }

    public void close() {
        frame.dispose();
    }
}
