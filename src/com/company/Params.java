package com.company;

import javax.swing.*;
import java.awt.*;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class Params {
    public static final Font FONT = new Font("Arial", Font.PLAIN, 16);

    public static final Color NOT_IN_RANGE_COLOR = new Color(0xFF7D7D);

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
            "Шкала METAVIR",
            "Биохимия - билирубин общий",
            "Биохимия - билирубин прямой",
            "Биохимия - АЛТ",
            "Биохимия - АСТ",
            "Биохимия - ГГТ",
            "Биохимия - ЩФ",
            "Биохимия - С-РБ",
            "Комментарий",
    };
    private static final Map<BiohimType, Range> map = new HashMap<>();

    static {
        map.put(BiohimType.OBSHIJ, new Range(5, 21));
        map.put(BiohimType.PRYAMOJ, new Range(0, 5.1));
        map.put(BiohimType.ALT, new Range(5, 33));
        map.put(BiohimType.AST, new Range(5, 32));
        map.put(BiohimType.GGT, new Range(6, 40));
        map.put(BiohimType.SCHF, new Range(30, 120));
        map.put(BiohimType.SRB, new Range(0, 5));
    }

    public static Range getRange(BiohimType type) {
        return map.get(type);
    }

    public static JFrame createFrame(int width, int height) {
        JFrame frame = new JFrame("Трансплантация");
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

    public static boolean isInRange(BiohimType type, double value) {
        return map.get(type).isInRange(value);
    }
}
