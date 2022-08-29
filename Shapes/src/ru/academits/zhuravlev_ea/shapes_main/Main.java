package ru.academits.zhuravlev_ea.shapes_main;

import ru.academits.zhuravlev_ea.shapes.Circle;
import ru.academits.zhuravlev_ea.shapes.Rectangle;
import ru.academits.zhuravlev_ea.shapes.Shape;
import ru.academits.zhuravlev_ea.shapes.Square;
import ru.academits.zhuravlev_ea.shapes.Triangle;
import ru.academits.zhuravlev_ea.shapes_comparators.AreaComparator;
import ru.academits.zhuravlev_ea.shapes_comparators.PerimeterComparator;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Shape[] shapes = {
                new Square(20.8),
                new Triangle(21.5, 56, 48.4, 25.8, 87.1, 97.8),
                new Rectangle(48.9, 34.7),
                new Circle(20.5),
                new Square(84.6),
                new Rectangle(74.1, 58.6),
                new Circle(67.8)
        };

        Shape maxAreaShape = getMaxAreaShape(shapes);
        Shape secondShapeByPerimeter = getSecondShapeByPerimeter(shapes);
        System.out.printf("Максимальная площадь %.2f у фигуры %s.%n", maxAreaShape.getArea(), maxAreaShape);
        System.out.printf("Второй по величине периметр %.2f у фигуры %s.%n",
                secondShapeByPerimeter.getPerimeter(), secondShapeByPerimeter);
    }

    private static Shape getMaxAreaShape(Shape[] shapes) {
        if (shapes == null) {
            throw new NullPointerException("Массив фигур пуст.");
        }

        if (shapes.length < 1) {
            throw new IllegalArgumentException("Для сравнения площадей не задано ни одной фигуры!");
        }

        Arrays.sort(shapes, new AreaComparator());
        return shapes[shapes.length - 1];
    }

    private static Shape getSecondShapeByPerimeter(Shape[] shapes) {
        if (shapes == null) {
            throw new NullPointerException("Массив фигур пуст.");
        }

        if (shapes.length < 2) {
            throw new IllegalArgumentException("Для сравнения периметров не задано ни одной фигуры или задана лишь одна фигура!");
        }

        Arrays.sort(shapes, new PerimeterComparator());
        return shapes[shapes.length - 2];
    }
}