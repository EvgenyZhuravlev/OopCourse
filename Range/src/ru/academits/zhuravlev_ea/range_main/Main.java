package ru.academits.zhuravlev_ea.range_main;

import ru.academits.zhuravlev_ea.range.Range;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double from, to;

        for (;;) {
            System.out.println("Введите два вещественных числа от и до для первого диапазона.");
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

        Range range1 = new Range(from, to);

        for (;;) {
            System.out.println("Введите два вещественных числа от и до для второго диапазона.");
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

        Range range2 = new Range(from, to);

        Range result = range1.getIntersectionsTwoRange(range2);

        System.out.println(result.getFrom() + " и " + result.getTo());

        /* double length = Math.abs(range1.getLength());
        System.out.printf("Длина диапазона = %.2f%n", length);

        System.out.print("Введите любое вещественное число - ");
        double number = scanner.nextDouble();

        if (range1.isInside(number)) {
            System.out.println("Данное число находится в диапазоне введённых чисел.");
        } else {
            System.out.println("Данное число не находится в диапазоне введённых чисел.");
        }

        System.out.printf("Вы ввели числа от %.2f до %.2f%n", range1.getFrom(), range1.getTo());

        range1.setFrom(0);
        range1.setTo(0);
        System.out.printf("При завершении программы значения обнулились и приняли значения от %.2f до %.2f.",
                range1.getFrom(), range1.getTo());*/
    }
}