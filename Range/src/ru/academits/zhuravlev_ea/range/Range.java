package ru.academits.zhuravlev_ea.range;

public class Range {
    private double from;
    private double to;

    public Range(double from, double to) {
            this.from = from;
            this.to = to;
    }

    public double getFrom() {
        return from;
    }

    public void setFrom(double from) {
        this.from = from;
    }

    public double getTo() {
        return to;
    }

    public void setTo(double to) {
        this.to = to;
    }

    public double getLength() {
        return to - from;
    }

    public boolean isInside(double number) {
        return number >= from && number <= to;
    }

    public Range getIntersectionsTwoRange(Range range) {
        if (this.to < range.from || range.to < this.from) {
            return null;
        }
        if (this.from >= from) {
            from = this.from;
        } else {
            this.from = from;
        }
        if (this.to >= to) {
            to = this.to;
        } else {
            this.to = to;
        }

        return range;
    }
}