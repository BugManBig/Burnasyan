package com.company;

import java.lang.reflect.Field;

public class Task {
    public int doctorId;
    public int patientId;
    public String date;
    public String sizes;
    public String diagnosis;
    public String transplantationType;
    public String transplantationDate;
    public String transplantationRd;
    public String transplantationLd;
    public String transplantationHd;
    public String transplantationEcho;
    public String transplantationComment;

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
