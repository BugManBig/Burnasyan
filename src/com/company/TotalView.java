package com.company;

import javax.swing.*;
import java.util.List;

public class TotalView {
    public void create(List<String> data) {
        JFrame frame = Params.createFrame(500, 500);
        JList<String> list = new JList<>();
        String[] strings = data.toArray(new String[0]);
        list.setListData(strings);
        JScrollPane scrollPane = new JScrollPane(list);
        scrollPane.setBounds(10, 10, 450, 450);
        list.setFont(Params.FONT);
        frame.add(scrollPane);

        JButton closeButton = new JButton("Закрыть");
        closeButton.setBounds(200, 820, 100, 30);
        closeButton.addActionListener(e -> frame.dispose());
        frame.add(closeButton);

        frame.setVisible(true);
    }
}
