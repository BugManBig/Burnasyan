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

        JButton addButton = new JButton("Добавить исследование");
        addButton.setBounds(50, 30, 180, 30);
        addButton.addActionListener(e -> menuController.handleAddButtonClick());
        frame.add(addButton);

        JButton searchButton = new JButton("Поиск");
        searchButton.setBounds(50, 70, 180, 30);
        searchButton.addActionListener(e -> menuController.handleSearchButtonClick());
        frame.add(searchButton);

        JButton exportButton = new JButton("Экспорт");
        exportButton.setBounds(50, 110, 180, 30);
        exportButton.addActionListener(e -> menuController.handleExportButtonClick());
        frame.add(exportButton);

        frame.setVisible(true);
    }

    public void close() {
        frame.dispose();
    }
}
