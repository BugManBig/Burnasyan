package com.company;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class TotalView {
    public void create(String[][] data) {
        JFrame frame = Params.createFrame(800, 500);
        JTable table = new JTable();
        DefaultTableModel dataModel = new DefaultTableModel(data, new String[]{"Тип", "Значение"});
        table.setModel(dataModel);
        table.getColumn("Тип").setCellRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component superRenderer = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                superRenderer.setFont(new Font("Arial", Font.BOLD, 16));
                return superRenderer;
            }
        });
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(10, 10, 750, 400);
        table.setFont(Params.FONT);
        frame.add(scrollPane);

        JButton closeButton = new JButton("Закрыть");
        closeButton.setBounds(650, 420, 100, 30);
        closeButton.addActionListener(e -> frame.dispose());
        frame.add(closeButton);

        frame.setVisible(true);
    }
}
