package com.company;

import java.time.LocalDate;
import java.time.Period;

public class TransplantationController {
    private Model model = ModelSingleton.getModel();
    private TransplantationView transplantationView;

    public void setTransplantationView(TransplantationView transplantationView) {
        this.transplantationView = transplantationView;
    }

    public void start() {
        transplantationView.create();
        handleComboBoxChange();
    }

    public void handleKeyRelease() {
        LocalDate transplantationDate = transplantationView.getDate();
        if (transplantationDate == null) {
            return;
        }
        Period period = Period.between(transplantationDate, LocalDate.now());
        String years = "";
        String months = "";
        String days = "";
        int yearsNumber = period.getYears();
        if (yearsNumber > 0) {
            years = getCorrectPhrase(yearsNumber, "год", "года", "лет");
        }
        int monthsNumber = period.getMonths();
        if (monthsNumber > 0) {
            months = getCorrectPhrase(monthsNumber, "месяц", "месяца", "месяцев");
        }
        days = getCorrectPhrase(period.getDays(), "день", "дня", "дней");
        transplantationView.setRangeLabel(years + months + days + "назад");
    }

    private String getCorrectPhrase(int number, String one, String twoFour, String many) {
        String ans = null;
        if (number % 10 == 1) {
            ans = one;
        }
        if (number % 10 >= 2 && number % 10 <= 4) {
            ans = twoFour;
        }
        if (ans == null || number >= 11 && number <= 14) {
            ans = many;
        }
        return number + " " + ans + " ";
    }

    public void handleComboBoxChange() {
        transplantationView.setFieldsEnabled(transplantationView.getTypeString().equals("Трупный"));
    }

    public void handleNextButtonClick() {
        model.getTask().transplantationType = transplantationView.getTypeString();
        model.getTask().transplantationDate = transplantationView.getDateString();
        transplantationView.close();
    }
}
