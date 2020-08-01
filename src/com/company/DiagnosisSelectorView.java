package com.company;

import javax.swing.*;

public class DiagnosisSelectorView {
    private JFrame frame;
    private JList<String> list;
    private DiagnosisSelectorController diagnosisSelectorController;

    public void setDiagnosisSelectorController(DiagnosisSelectorController diagnosisSelectorController) {
        this.diagnosisSelectorController = diagnosisSelectorController;
    }

    public void create() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setVisible(true);

        list = new JList<>();
        list.setBounds(10, 10, 300, 300);
        list.setFont(Params.FONT);
        frame.add(list);

        JButton selectButton = new JButton("Select");
        selectButton.setBounds(10, 320, 100, 30);
        selectButton.addActionListener(e -> diagnosisSelectorController.handleSelectButtonClick());
        frame.add(selectButton);

        JButton addButton = new JButton("Add");
        addButton.setBounds(120, 320, 100, 30);
        addButton.addActionListener(e -> diagnosisSelectorController.handleAddButtonClick());
        frame.add(addButton);
    }

    public void setListData(String[] data) {
        list.setListData(data);
    }

    public int getSelectedIndex() {
        return list.getSelectedIndex();
    }

    public void close() {
        frame.dispose();
    }
}
