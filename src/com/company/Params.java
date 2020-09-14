package com.company;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

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

    public static String get(String key) {
        Properties properties = new Properties();
        try {
            properties.load(new FileReader("config.ini"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties.getProperty(key);
    }
}
