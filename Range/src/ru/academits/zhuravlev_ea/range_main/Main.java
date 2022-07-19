package ru.academits.zhuravlev_ea.range_main;

import ru.academits.zhuravlev_ea.range.Range;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите два вещественных числа от и до.");
        System.out.print("От: ");
        double from = scanner.nextDouble();

        System.out.print("До: ");
        double to = scanner.nextDouble();

        Range range = new Range(from, to);

        double length = Math.abs(range.getLength());
        System.out.printf("Длина диапазона = %.2f%n", length);

        System.out.print("Введите любое вещественное число - ");
        double number = scanner.nextDouble();

        if (range.isInside(number)) {
            System.out.println("Данное число находится в диапазоне введённых чисел.");
        } else {
            System.out.println("Данное число не находится в диапазоне введённых чисел.");
        }

        System.out.printf("Вы ввели числа от %.2f до %.2f%n", range.getFrom(), range.getTo());

        range.setFrom(0);
        range.setTo(0);
        System.out.printf("При завершении программы значения обнулились и приняли значения от %.2f до %.2f.",
                range.getFrom(), range.getTo());
    }
}