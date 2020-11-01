package com.company;

import javax.swing.*;
import java.awt.*;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Params {
    public static final Font FONT = new Font("Arial", Font.PLAIN, 16);

    public static String[] types = {
            "Доктор",
            "Пациент",
            "Дата исследования",
            "Диагноз",
            "Тип трансплантанта",
            "Дата трансплантации",
            "ПД",
            "ЛД",
            "ХД",
            "Эхогенность",
            "Доп. образования",
            "Холедох визуализируется",
            "Холедох размеры",
            "ВВ - диаметр до анастомоза",
            "ВВ - диаметр после анастомоза",
            "ВВ - скорость до анастомоза",
            "ВВ - скорость после анастомоза",
            "ВВ - комментарий",
            "Собственная артерия печени - визуализируется",
            "Собственная артерия печени - Vps",
            "Собственная артерия печени - Vd",
            "Собственная артерия печени - IR",
            "Печёночные вены - тип кровотока",
            "Печёночные вены - скорость",
            "Селезёнка - размеры",
            "Селезёнка - площадь",
            "Селезёнка - диаметр селезёночной вены в воротах",
            "Селезёнка - скорость в воротах селезёнки",
            "Свободная жидкость",
            "Свободная жидкость - комментарий",
            "Свободная жидкость - расщепление листков брюшины",
            "Ограниченное скопление",
            "Ограниченное скопление - комментарий",
            "Эластометрия - ElastQ 3mm",
            "Эластометрия - погрешность ElastQ 3mm",
            "Эластометрия - ElastQ 10mm",
            "Эластометрия - погрешность ElastQ 10mm",
            "Эластометрия - ElastPQ",
            "Эластометрия - погрешность ElastPQ",
            "Эластометрия - Селезёнка, 3mm",
            "Эластометрия - погрешность Селезёнка, 3mm",
            "Биохимия - билирубин общий",
            "Биохимия - билирубин прямой",
            "Биохимия - АЛТ",
            "Биохимия - АСТ",
            "Биохимия - ГГТ",
            "Биохимия - ЩФ",
            "Биохимия - С-РБ",
            "Комментарий",
    };

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
