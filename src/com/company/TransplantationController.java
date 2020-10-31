package com.company;

import java.time.LocalDate;
import java.time.Period;

public class TransplantationController {
    private TransplantationView transplantationView;

    public void setTransplantationView(TransplantationView transplantationView) {
        this.transplantationView = transplantationView;
    }

    public void start() {
        transplantationView.create();
        handleComboBoxChange();
        Model model = ModelSingleton.getModel();
        String transplantationDate = model.getTransplantationDate(model.getTask().patientId);
        if (transplantationDate != null) {
            transplantationView.setDate(transplantationDate);
        }
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
        Task task = ModelSingleton.getModel().getTask();
        task.transplantationType = transplantationView.getTypeString();
        task.transplantationDate = transplantationView.getDateString();
        task.transplantationRd = transplantationView.getRdString();
        task.transplantationLd = transplantationView.getLdString();
        task.transplantationHd = transplantationView.getHdString();
        task.transplantationEcho = transplantationView.getEchoType();
        task.transplantationComment = transplantationView.getComment();

        HoledohView holedohView = new HoledohView();
        HoledohController holedohController = new HoledohController();
        holedohView.setHoledohController(holedohController);
        holedohController.setHoledohView(holedohView);
        holedohController.start();

        transplantationView.close();
    }
}
