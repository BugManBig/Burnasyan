package com.company;

import javax.swing.*;
import java.awt.*;

public class Params {
    public static final Font FONT = new Font("Arial", Font.PLAIN, 16);

    public static JFrame createFrame(int width, int height) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(width, height);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        return frame;
    }

    public static JFrame createFrame() {
        return createFrame(600, 400);
    }
}
