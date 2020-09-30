package com.company;

import javax.swing.*;
import java.util.List;

public class TotalView {
    public void create(List<String> data) {
        JFrame frame = Params.createFrame(500, 900);
        for (int i = 0; i < data.size(); i++) {
            JLabel label = new JLabel(data.get(i));
            label.setBounds(10, i * 20, 500, 20);
            label.setFont(Params.FONT);
            frame.add(label);
        }

        JButton closeButton = new JButton("Закрыть");
        closeButton.setBounds(200, 820, 100, 30);
        closeButton.addActionListener(e -> frame.dispose());
        frame.add(closeButton);

        frame.setVisible(true);
    }
}
