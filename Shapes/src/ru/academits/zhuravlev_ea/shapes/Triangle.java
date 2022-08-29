package ru.academits.zhuravlev_ea.shapes;

public class Triangle implements Shape {
    private double x1;
    private double x2;
    private double x3;
    private double y1;
    private double y2;
    private double y3;

    public double getX1() {
        return x1;
    }

    public void setX1(double x1) {
        this.x1 = x1;
    }

    public double getX2() {
        return x2;
    }

    public void setX2(double x2) {
        this.x2 = x2;
    }

    public double getX3() {
        return x3;
    }

    public void setX3(double x3) {
        this.x3 = x3;
    }

    public double getY1() {
        return y1;
    }

    public void setY1(double y1) {
        this.y1 = y1;
    }

    public double getY2() {
        return y2;
    }

    public void setY2(double y2) {
        this.y2 = y2;
    }

    public double getY3() {
        return y3;
    }

    public void setY3(double y3) {
        this.y3 = y3;
    }

    public Triangle(double x1, double y1, double x2, double y2, double x3, double y3) {
        this.x1 = x1;
        this.x2 = x2;
        this.x3 = x3;
        this.y1 = y1;
        this.y2 = y2;
        this.y3 = y3;
    }

    @Override
    public double getWidth() {
        return Math.max(Math.max(x1, x2), x3) - Math.min(Math.min(x1, x2), x3);
    }

    @Override
    public double getHeight() {
        return Math.max(Math.max(y1, y2), y3) - Math.min(Math.min(y1, y2), y3);
    }

    @Override
    public double getArea() {
        double semiperimeter = getPerimeter() / 2;
        return Math.sqrt(semiperimeter * (semiperimeter - getSegmentLength(x1, x2, y1, y2))
                * (semiperimeter - getSegmentLength(x2, x3, y2, y3))
                * (semiperimeter - getSegmentLength(x1, x3, y1, y3)));
    }

    @Override
    public double getPerimeter() {
        double segment1Length = getSegmentLength(x1, x2, y1, y2);
        double segment2Length = getSegmentLength(x2, x3, y2, y3);
        double segment3Length = getSegmentLength(x1, x3, y1, y3);

        return segment1Length + segment2Length + segment3Length;
    }

    private static double getSegmentLength(double x1, double x2, double y1, double y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("треуголник с координатами ");
        sb.append("x1:");
        sb.append(x1);
        sb.append(", ");
        sb.append("y1:");
        sb.append(y1);
        sb.append(", ");
        sb.append("x2:");
        sb.append(x2);
        sb.append(", ");
        sb.append("y2:");
        sb.append(y2);
        sb.append(", ");
        sb.append("x3:");
        sb.append(x3);
        sb.append(", ");
        sb.append("y3:");
        sb.append(y3);
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        if (o == null || o.getClass() != getClass()) {
            return false;
        }

        Triangle triangle = (Triangle) o;
        return x1 == triangle.x1 && x2 == triangle.x2 && x3 == triangle.x3
                && y1 == triangle.y1 && y2 == triangle.y2 && y3 == triangle.y3;
    }

    @Override
    public int hashCode() {
        final int PRIME = 37;
        int hash = 1;
        hash = PRIME * hash + Double.hashCode(x1);
        hash = PRIME * hash + Double.hashCode(x2);
        hash = PRIME * hash + Double.hashCode(x3);
        hash = PRIME * hash + Double.hashCode(y1);
        hash = PRIME * hash + Double.hashCode(y2);
        hash = PRIME * hash + Double.hashCode(y3);
        return hash;
    }
}