package ru.academits.zhuravlev_ea.vector_main;

import ru.academits.zhuravlev_ea.vector.Vector;

public class Main {
    public static void main(String[] args) {
        Vector vector1 = new Vector(2, new double[]{4, 7});
        Vector vector2 = new Vector(new double[]{10, 9, -5, 4});

        vector1.getSum(vector2);
        System.out.println("Сложение " + vector1);

        vector1.getDifference(vector2);
        System.out.println("Вычитание " + vector1);

        double scalar = 2.7;
        vector2.multiplyByScalar(scalar);
        System.out.println("Умножение вектора на скаляр " + vector2);

        vector1.reverse();
        System.out.println("Разворот вектора " + vector1);

        double vectorLength = vector2.getLength();
        System.out.printf("Длина вектора %.2f%n", vectorLength);

        int index = 2;
        double component = -7.5;
        vector2.setComponent(index, component);
        System.out.println("Вектор с замененной компонентой " + vector2);

        Vector vector3 = Vector.getSum(vector1, vector2);
        System.out.println("Статическое сложение " + vector3);

        vector3 = Vector.getDifference(vector1, vector2);
        System.out.println("Статическое вычитание " + vector3);

        double product = Vector.getScalarProduct(vector1, vector2);
        System.out.println("Статическое умножение " + product);
    }
}