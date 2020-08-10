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
        frame = Params.createFrame();

        list = new JList<>();
        list.setBounds(10, 10, 300, 300);
        list.setFont(Params.FONT);
        frame.add(list);

        JButton selectButton = new JButton("Выбрать");
        selectButton.setBounds(210, 320, 100, 30);
        selectButton.addActionListener(e -> diagnosisSelectorController.handleSelectButtonClick());
        frame.add(selectButton);

        JButton addButton = new JButton("+");
        addButton.setBounds(10, 320, 50, 30);
        addButton.setFont(Params.FONT);
        addButton.addActionListener(e -> diagnosisSelectorController.handleAddButtonClick());
        frame.add(addButton);

        frame.setVisible(true);
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
