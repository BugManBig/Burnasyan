package com.company;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class Task {
    public int doctorId;
    public int patientId;
    public String date;

    public String diagnosis;

    public String transplantationType;
    public String transplantationDate;
    public String transplantationRd;
    public String transplantationLd;
    public String transplantationHd;
    public String transplantationEcho;
    public String transplantationComment;

    public String holedohVis;
    public String holedohSizes;

    public String vorotnayaSizeBefore;
    public String vorotnayaSizeAfter;
    public String vorotnayaSpeedBefore;
    public String vorotnayaSpeedAfter;
    public String vorotnayaComment;

    public String arteryVis;
    public String arterySpeed;
    public String arteryIr;

    public String liverType;
    public String liverSpeed;

    public String selezenkaSizes;
    public String selezenkaSquare;
    public String selezenkaDiameter;
    public String selezenkaSpeed;

    public String liquidIs;
    public String liquidComment;
    public String liquidDividing;

    public String skoplenieIs;
    public String skoplenieComment;

    public String elastoQ3;
    public String elastoQ10;
    public String elastoPq;
    public String elastoSQ3;
    public String inaccuracy1;
    public String inaccuracy2;
    public String inaccuracy3;
    public String inaccuracy4;

    public String biohimObshij;
    public String biohimPryamoj;
    public String biohimAlt;
    public String biohimAst;
    public String biohimGgt;
    public String biohimSchf;
    public String biohimSrb;

    public String comment;

    public List<String> getData() {
        List<String> data = new ArrayList<>();
        Field[] declaredFields = Task.class.getDeclaredFields();
        for (Field field : declaredFields) {
            try {
                data.add(field.getName() + "=" + field.get(this));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return data;
    }

    public static String[] getFieldNames() {
        Field[] declaredFields = Task.class.getDeclaredFields();
        String[] data = new String[declaredFields.length];
        for (int i = 0; i < declaredFields.length; i++) {
            data[i] = declaredFields[i].getName();
        }
        return data;
    }
}
