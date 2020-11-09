package com.company;

public class Range {
    private double from;
    private double to;

    public Range(double from, double to) {
        this.from = from;
        this.to = to;
    }

    public boolean isInRange(double value) {
        return from <= value && value <= to;
    }

    public double getFrom() {
        return from;
    }

    public double getTo() {
        return to;
    }

    @Override
    public String toString() {
        String strFrom = (from * 10) % 10 == 0 ? String.valueOf((int) from) : String.valueOf(from);
        String strTo = (to * 10) % 10 == 0 ? String.valueOf((int) to) : String.valueOf(to);
        return strFrom + "-" + strTo;
    }
}
