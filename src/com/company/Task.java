package com.company;

import java.lang.reflect.Field;

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

    public String arteryVis;
    public String arterySpeed;
    public String arteryIr;

    public String liverType;
    public String liverSpeed;

    public String selezenkaSizes;
    public String selezenkaSquare;
    public String selezenkaDiameter;
    public String selezenkaSpeed;

    public void info() {
        Field[] declaredFields = Task.class.getDeclaredFields();
        for (Field field : declaredFields) {
            try {
                System.out.println(field.getName() + ": " + field.get(this));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }
}
