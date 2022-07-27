package ru.academits.zhuravlev_ea.range_main;

import ru.academits.zhuravlev_ea.range.Range;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double from, to;

        for (; ; ) {
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

        for (; ; ) {
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

        Range result1 = range1.getIntersectionsTwoRanges(range2);

        if (result1 == null) {
            System.out.println("Пересечение между двумя заданными диапазонами отсутствует.");
        } else {
            System.out.println("Диапазон пересечения двух указанных Вами диапазонов будет равен " + result1);
        }

        Range[] result2 = range1.getCombiningTwoRanges(range2);

        StringBuilder sb = new StringBuilder("Новый объединённый диапазон из двух указанных Вами диапазонов будет равен ");

        for (int i = 0; i < result2.length; i++) {
            sb.append(result2[i]);
            if (i < result2.length - 1) {
                sb.append(" и ");
            } else {
                sb.append(".");
            }
        }

        System.out.println(sb);

        Range[] result3 = range1.getDifferenceTwoRanges(range2);

        if (result3 == null) {
            System.out.println("Разность двух заданных диапазонов равна 0.");
        } else {
            sb = new StringBuilder("Разность двух указанных Вами диапазонов будет равна ");

            for (int i = 0; i < result3.length; i++) {
                sb.append(result3[i]);
                if (i < result3.length - 1) {
                    sb.append(" и ");
                } else {
                    sb.append(".");
                }
            }

            System.out.println(sb);
        }
    }
}