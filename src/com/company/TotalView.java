package com.company;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class TotalView {
    private TotalController totalController;
    private JTable table;
    private JFrame frame;

    public void setTotalController(TotalController totalController) {
        this.totalController = totalController;
    }

    public void create(String[][] data) {
        frame = Params.createFrame(800, 500);
        table = new JTable();
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
        table.getColumn("Значение").setCellRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component superRenderer = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                if (row < 41 || row > 47 || ((String) value).length() == 0) {
                    superRenderer.setBackground(Color.WHITE);
                    return superRenderer;
                }
                String valStr = (String) value;
                double doubleValue = Double.parseDouble(valStr);
                superRenderer.setBackground(Params.isInRange(BiohimType.values()[row - 41], doubleValue)
                        ? Color.WHITE : Params.NOT_IN_RANGE_COLOR);
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

        JButton saveButton = new JButton("Сохранить");
        saveButton.setBounds(10, 420, 100, 30);
        saveButton.addActionListener(e -> totalController.handleSaveButtonClick());
        frame.add(saveButton);

        table.addPropertyChangeListener(evt -> saveButton.setEnabled(!table.isEditing()));

        frame.setVisible(true);
    }

    public String getTableValue(int row) {
        return (String) table.getValueAt(row, 1);
    }

    public void close() {
        frame.dispose();
    }
}
