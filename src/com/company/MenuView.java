package com.company;

import javax.swing.*;

public class MenuView {
    private MenuController menuController;

    public void setMenuController(MenuController menuController) {
        this.menuController = menuController;
    }

    public void create() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setVisible(true);

        JButton button = new JButton("Add");
        button.setBounds(90, 30, 100, 30);
        button.addActionListener(e -> menuController.handleAddButtonClick());
        frame.add(button);

        frame.repaint();
    }
}
