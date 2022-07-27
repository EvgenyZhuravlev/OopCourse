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

    public Range getIntersectionsTwoRanges(Range range) {
        if (this.to < range.from || range.to < this.from) {
            return null;
        }

        double from, to;

        if (this.from == range.from) {
            from = this.from;
        } else {
            from = Math.max(this.from, range.from);
        }

        if (this.to == range.to) {
            to = this.to;
        } else {
            to = Math.min(this.to, range.to);
        }

        if (from == to) {
            return null;
        }

        return new Range(from, to);
    }

    public Range[] getCombiningTwoRanges(Range range) {
        if (this.to < range.from) {
            return new Range[]{new Range(this.from, this.to), new Range(range.from, range.to)};
        }

        if (range.to < this.from) {
            return new Range[]{new Range(range.from, range.to), new Range(this.from, this.to)};
        }

        double from, to;

        if (this.from == range.from) {
            from = this.from;
        } else {
            from = Math.min(this.from, range.from);
        }

        if (this.to == range.to) {
            to = this.to;
        } else {
            to = Math.max(this.to, range.to);
        }

        return new Range[]{new Range(from, to)};
    }

    public Range[] getDifferenceTwoRanges(Range range) {
        if (this.to == range.from || range.to == this.from || this.to < range.from || range.to < this.from) {
            return null;
        }

        if (this.from < range.from && this.to < range.to) {
            return new Range[]{new Range(this.from, range.from)};
        }

        if (this.from < range.from && this.to > range.to) {
            return new Range[]{new Range(this.from, range.from), new Range(range.to, this.to)};
        }

        if (range.from < this.from && range.to < this.to) {
            return new Range[]{new Range(range.to, this.to)};
        }

        if (this.from > range.from && this.to < range.to) {
            return new Range[]{new Range(range.from, this.from), new Range(this.to, range.to)};
        }

        if (this.from == range.from && this.to > range.to) {
            return new Range[]{new Range(range.to, this.to)};
        }

        return new Range[]{new Range(this.from, range.from)};
    }

    @Override
    public String toString() {
        return "от " + from + " до " + to;
    }
}