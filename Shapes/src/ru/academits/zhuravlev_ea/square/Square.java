package ru.academits.zhuravlev_ea.square;

import ru.academits.zhuravlev_ea.shape.Shape;

public class Square implements Shape {
    private double side;

    public Square(double side) {
        this.side = side;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    @Override
    public double getWidth() {
        return side;
    }

    @Override
    public double getHeight() {
        return side;
    }

    @Override
    public double getArea() {
        return Math.pow(side, 2);
    }

    @Override
    public double getPerimeter() {
        return side + side;
    }

    @Override
    public String toString() {
        return "квадрат";
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        if (o == null || o.getClass() != getClass()) {
            return false;
        }

        Square square = (Square) o;
        return side == square.side;
    }

    @Override
    public int hashCode() {
        final int PRIME = 37;
        int hash = 1;
        hash = PRIME * hash + Double.hashCode(side);
        return hash;
    }
}