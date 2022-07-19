package ru.academits.zhuravlev_ea.range;

public class Range {
    private double from;
    private double to;

    public Range(double from, double to) {
        this.from = from;
        this.to = to;
    }

    public void setFrom(double userFrom) {
        from = userFrom;
    }

    public double getFrom() {
        return from;
    }

    public void setTo(double userTo) {
        to = userTo;
    }

    public double getTo() {
        return to;
    }

    public double getLength () {
        return to - from;
    }

    public boolean isInside (double number) {
        return number >= from && number <= to;
    }
}
