package ru.academits.zhuravlev_ea.range_main;

import ru.academits.zhuravlev_ea.range.Range;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Введите два вещественных числа от и до для первого диапазона.");
        Range range1 = inputRange();

        System.out.println("Введите два вещественных числа от и до для второго диапазона.");
        Range range2 = inputRange();

        Range intersection = range1.getIntersection(range2);

        if (intersection == null) {
            System.out.println("Пересечение между двумя заданными диапазонами отсутствует.");
        } else {
            System.out.println("Диапазон пересечения двух указанных Вами диапазонов будет равен " + intersection + ".");
        }

        Range[] union = range1.getUnion(range2);
        Main.printArray("Новый объединённый диапазон из двух указанных Вами диапазонов будет равен ", union);


        Range[] difference = range1.getDifference(range2);
        Main.printArray("Разность двух указанных Вами диапазонов будет равна ", difference);
    }

    private static Range inputRange() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("От: ");
        double from = scanner.nextDouble();

        System.out.print("До: ");
        double to = scanner.nextDouble();

        if (from > to) {
            System.out.println("Вы ввели некорректный диапазон. Значение \"От\" больше значения \"До\"");
            return inputRange();
        } else {
            return new Range(from, to);
        }
    }

    private static void printArray(String description, Range[] array) {
        System.out.println(description + Arrays.toString(array) + ".");
    }
}