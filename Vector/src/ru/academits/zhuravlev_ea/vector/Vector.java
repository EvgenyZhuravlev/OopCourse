package ru.academits.zhuravlev_ea.vector;

import java.util.Arrays;


public class Vector {
    private int size;
    private double[] components;

    public Vector(int size) {
        this.size = size;
        components = new double[size];
    }

    public Vector(Vector components) {
        this.size = components.getSize();
        this.components = components.getComponents();
    }

    public Vector(double[] components) {
        this.components = components;
        this.size = components.length;
    }

    public Vector(int size, double[] components) {
        this.size = size;
        this.components = Arrays.copyOf(components, size);
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public double[] getComponents() {
        return components;
    }

    public void setComponents(double[] components) {
        this.components = components;
    }

    public int getSize(Vector vector) {
        return vector.size;
    }

    @Override
    public String toString() {
        StringBuilder vectorStringBuilder = new StringBuilder("{");
        int iMax = components.length - 1;

        for (int i = 0;;i++){
            vectorStringBuilder.append(components[i]);

            if (i == iMax) {
                return vectorStringBuilder.append("}").toString();
            }

            vectorStringBuilder.append(", ");
        }
    }

    public double[] addition(Vector vector) {
        double[] vectorSum;

        if (size > vector.size) {
            double[] vector2 = Arrays.copyOf(vector.components, size);
            vectorSum = new double[size];

            for (int i = 0; i < this.components.length; i++) {
                vectorSum[i] = this.components[i] + vector2[i];
            }
        } else {
            double[] vector1 = Arrays.copyOf(this.components, vector.size);
            vectorSum = new double[vector.size];

            for (int i = 0; i < vector.components.length; i++) {
                vectorSum[i] = vector1[i] + vector.components[i];
            }
        }
        return vectorSum;
    }

    public double[] subtraction(Vector vector) {
        double[] vectorDifference;

        if (size > vector.size) {
            double[] vector2 = Arrays.copyOf(vector.components, size);
            vectorDifference = new double[size];

            for (int i = 0; i < this.components.length; i++) {
                vectorDifference[i] = this.components[i] - vector2[i];
            }
        } else {
            double[] vector1 = Arrays.copyOf(this.components, vector.size);
            vectorDifference = new double[vector.size];

            for (int i = 0; i < vector.components.length; i++) {
                vectorDifference[i] = vector1[i] - vector.components[i];
            }
        }
        return vectorDifference;
    }

    public double[] multiplicationByScalar(double scalar) {
        for (int i = 0; i < components.length; i++) {
            components[i] = components[i] * scalar;
        }
        return components;
    }

    public double[] reverse() {
        int multiplier = -1;

        for (int i = 0; i < components.length; i++) {
            components[i] = components[i] * multiplier;
        }
        return components;
    }

    public double getLength() {
        double vectorLength = 0;

        for (double component: components) {
            vectorLength += component * component;
        }

        vectorLength = Math.sqrt(vectorLength);
        return vectorLength;
    }

    public double[] replacement( int index, double component){
        components[index] = component;
        return components;
    }

    public static Vector addition(Vector vector1, Vector vector2) {
        if (vector1.size > vector2.size) {
        vector2 = new Vector(Arrays.copyOf(vector2.components, vector1.size));
        } else {
            vector1 = new Vector(Arrays.copyOf(vector1.components, vector2.size));
        }

        Vector vector3 = new Vector(vector1.size);

        for (int i = 0; i < vector1.components.length; i++) {
            vector3.components[i] = vector1.components[i] + vector2.components[i];
        }

        return vector3;
    }

    public static Vector subtraction(Vector vector1, Vector vector2) {
        if (vector1.size > vector2.size) {
            vector2 = new Vector(Arrays.copyOf(vector2.components, vector1.size));
        } else {
            vector1 = new Vector(Arrays.copyOf(vector1.components, vector2.size));
        }

        Vector vector3 = new Vector(vector1.size);

        for (int i = 0; i < vector1.components.length; i++) {
            vector3.components[i] = vector1.components[i] - vector2.components[i];
        }

        return vector3;
    }

    public static double multiplication(Vector vector1, Vector vector2) {
        if (vector1.size > vector2.size) {
            vector2 = new Vector(Arrays.copyOf(vector2.components, vector1.size));
        } else {
            vector1 = new Vector(Arrays.copyOf(vector1.components, vector2.size));
        }

        for (int i = 0; i < vector1.components.length; i++) {
            vector1.components[i] = vector1.components[i] * vector2.components[i];
        }

        double multiplication = 0;

        for (double e :vector1.components) {
            multiplication += e;
        }

        return multiplication;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Vector vector1 = (Vector) o;

        if (size != vector1.size) {
            return false;
        }

        return Arrays.equals(components, vector1.components);
    }

    @Override
    public int hashCode() {
        final int PRIME = 37;
        int hash = 1;
        hash = PRIME * hash + Arrays.hashCode(components);
        return hash;
    }
}