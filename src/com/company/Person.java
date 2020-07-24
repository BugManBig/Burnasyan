package com.company;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Person {
    private int id;
    private String surname;
    private String name;
    private String patronymic;
    private LocalDate birthday;
    private Sex sex;

    public Person(int id, String surname, String name, String patronymic, String birthday, Sex sex) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.birthday = parseDate(birthday);
        this.sex = sex;
    }

    public Person(int id, String surname, String name, String patronymic) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
    }

    public int getId() {
        return id;
    }

    private LocalDate parseDate(String date) {
        return LocalDate.of(
                getNumberFromDateString(2, date),
                getNumberFromDateString(1, date),
                getNumberFromDateString(0, date));
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

    public LocalDate getBirthday() {
        return birthday;
    }

    public String getBirthdayString() {
        return birthday.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

    public Sex getSex() {
        return sex;
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
