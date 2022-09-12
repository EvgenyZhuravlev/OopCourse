package ru.academits.zhuravlev_ea.vector;

import java.util.Arrays;

public class Vector {
    private double[] components;

    public Vector(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("Размерность вектора должна быть больше 0!");
        }

        components = new double[size];
    }

    public Vector(Vector vector) {
        if (vector.components.length <= 0) {
            throw new IllegalArgumentException("Размерность вектора должна быть больше 0!");
        }

        components = Arrays.copyOf(vector.components, vector.components.length);
    }

    public Vector(double[] components) {
        if (components.length <= 0) {
            throw new IllegalArgumentException("Размерность вектора должна быть больше 0!");
        }

        this.components = Arrays.copyOf(components, components.length);
    }

    public Vector(int size, double[] components) {
        if (size <= 0) {
            throw new IllegalArgumentException("Размерность вектора должна быть больше 0!");
        }

        this.components = Arrays.copyOf(components, size);
    }

    public int getSize() {
        return components.length;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("{");

        for (double component : components) {
            stringBuilder.append(component);
            stringBuilder.append(", ");
        }

        stringBuilder.setLength(stringBuilder.length() - 2);

        return stringBuilder.append("}").toString();
    }

    public void getSum(Vector vector) {
        if (components.length > vector.components.length) {
            vector.components = Arrays.copyOf(vector.components, components.length);
        } else {
            components = Arrays.copyOf(components, vector.components.length);
        }

        for (int i = 0; i < components.length; i++) {
            components[i] += vector.components[i];
        }
    }

    public void getDifference(Vector vector) {
        if (components.length > vector.components.length) {
            vector.components = Arrays.copyOf(vector.components, components.length);
        } else {
            components = Arrays.copyOf(components, vector.components.length);
        }

        for (int i = 0; i < components.length; i++) {
            components[i] = components[i] - vector.components[i];
        }
    }

    public void multiplyByScalar(double scalar) {
        for (int i = 0; i < components.length; i++) {
            components[i] = components[i] * scalar + 0.0;
        }
    }

    public void reverse() {
        int multiplier = -1;
        multiplyByScalar(multiplier);
    }

    public double getLength() {
        double sum = 0;

        for (double component : components) {
            sum += component * component;
        }

        return Math.sqrt(sum);
    }

    public double getComponent(int index, double component) {
        return components[index];
    }

    public void setComponent(int index, double component) {
        components[index] = component;
    }

    public static Vector getSum(Vector vector1, Vector vector2) {
        Vector resultVector = new Vector(vector1);
        resultVector.getSum(vector2);

        return resultVector;
    }

    public static Vector getDifference(Vector vector1, Vector vector2) {
        Vector resultVector = new Vector(vector1);
        resultVector.getDifference(vector2);

        return resultVector;
    }

    public static double getScalarProduct(Vector vector1, Vector vector2) {
        double sum = 0;

        for (int i = 0; i < Math.min(vector1.components.length, vector2.components.length); i++) {
            sum += vector1.components[i] * vector2.components[i];
        }

        return sum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Vector vector = (Vector) o;

        if (components.length != vector.components.length) {
            return false;
        }

        return Arrays.equals(components, vector.components);
    }

    @Override
    public int hashCode() {
        final int PRIME = 37;
        int hash = 1;
        hash = PRIME * hash + Arrays.hashCode(components);
        return hash;
    }
}