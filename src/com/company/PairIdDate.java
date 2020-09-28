package com.company;

import java.time.LocalDate;

public class PairIdDate {
    public int id;
    public String date;

    public PairIdDate(int id, String date) {
        this.id = id;
        this.date = date;
    }

    @Override
    public String toString() {
        return "PairIdDate{" +
                "id=" + id +
                ", date='" + date + '\'' +
                '}';
    }
}
