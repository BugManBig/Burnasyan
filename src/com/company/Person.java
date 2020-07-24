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
        return LocalDate.parse(date, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
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
