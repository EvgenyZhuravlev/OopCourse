package ru.academits.zhuravlev_ea.vector_main;

import ru.academits.zhuravlev_ea.vector.Vector;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Vector vector1 = new Vector(2, new double[]{4, 7});
        Vector vector2 = new Vector(new double[]{10, 9, -5, 4});
        Vector vector3 = vector2;

        System.out.println(vector2.equals(vector3));

        double[] vectorSum = vector1.getAddition(vector2);
        vector3 = new Vector(vectorSum);
        System.out.println(Arrays.toString(vectorSum));
        System.out.println("Сложение " + vector3);

        double[] vectorDifference = vector2.getSubtraction(vector1);
        vector3 = new Vector(vectorDifference);
        System.out.println("Вычитание " + vector3);

        double scalar = 2.7;
        double[] vectorProduct = vector2.getMultiplication(scalar);
        vector3 = new Vector(vectorProduct);
        System.out.println("Умножение вектора на скаляр " + vector3);

        double[] vectorReverse = vector1.getReverse();
        vector3 = new Vector(vectorReverse);
        System.out.println("Разворот вектора " + vector3);

        double vectorLength = vector2.getLength();
        System.out.printf("Длина вектора %.2f%n", vectorLength);

        int index = 2;
        double component = -7.5;
        double[] replacedVector = vector2.replacement(index, component);
        vector3 = new Vector(replacedVector);
        System.out.println("Вектор с замененной компонентой " + vector3);
    }
}
