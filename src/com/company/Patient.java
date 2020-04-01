package com.company;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Patient {
    private int id;
    private String surname;
    private String name;
    private String patronymic;
    private LocalDateTime birthday;

    public Patient(int id, String surname, String name, String patronymic, String birthday) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.birthday = parseDate(birthday);
    }

    public int getId() {
        return id;
    }

    private LocalDateTime parseDate(String date) {
        return LocalDateTime.of(
                getNumberFromDateString(2, date),
                getNumberFromDateString(1, date),
                getNumberFromDateString(0, date),
                0, 0);
    }

    private int getNumberFromDateString(int id, String date) {
        int start = -1;
        for (int count = 0; count < id; count++) {
            start = date.indexOf(".", start + 1);
        }
        int end = date.indexOf(".", start + 1);
        if (end == -1) {
            end = date.length();
        }
        return Integer.parseInt(date.substring(start + 1, end));
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public String getFio() {
        return surname + " " + name + " " + patronymic;
    }

    public String getBirthdayString() {
        return birthday.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", birthday='" + birthday + '\'' +
                '}';
    }
}
