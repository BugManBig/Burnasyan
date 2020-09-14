package com.company;

import javax.swing.*;

public class SingleSearchView {
    public JFrame frame;
    private JTextField searchField;

    private SingleSearchController singleSearchController;

    public void setSingleSearchController(SingleSearchController singleSearchController) {
        this.singleSearchController = singleSearchController;
    }

    public void create() {
        frame = Params.createFrame();

        searchField = new JTextField();
        searchField.setBounds(10, 10, 100, 30);
        searchField.setFont(Params.FONT);
        frame.add(searchField);

        frame.setVisible(true);
    }

    public String getSearchField() {
        return searchField.getText();
    }
}
