package ru.academits.zhuravlev_ea.range_main;

import ru.academits.zhuravlev_ea.range.Range;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Range range1 = inputRange("Введите два вещественных числа от и до для первого диапазона.");
        Range range2 = inputRange("Введите два вещественных числа от и до для второго диапазона.");

        Range intersection = range1.getIntersection(range2);

        if (intersection == null) {
            System.out.println("Пересечение между двумя заданными диапазонами отсутствует.");
        } else {
            System.out.println("Диапазон пересечения двух указанных Вами диапазонов будет равен " + intersection + ".");
        }

        Range[] union = range1.getUnion(range2);
        printArray("Новый объединённый диапазон из двух указанных Вами диапазонов будет равен ", union);

        Range[] difference = range1.getDifference(range2);
        printArray("Разность двух указанных Вами диапазонов будет равна ", difference);
    }

    private static Range inputRange(String description) {
        Scanner scanner = new Scanner(System.in);
        double from;
        double to;

        for (; ; ) {
            System.out.println(description);
            System.out.print("От: ");
            from = scanner.nextDouble();

            System.out.print("До: ");
            to = scanner.nextDouble();

            if (from > to) {
                System.out.println("Вы ввели некорректный диапазон. Значение \"От\" больше значения \"До\"");
            } else {
                break;
            }
        }

        return new Range(from, to);
    }

    private static void printArray(String description, Range[] array) {
        System.out.println(description + Arrays.toString(array) + ".");
    }
}