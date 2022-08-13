package ru.academits.zhuravlev_ea.shape_main;

import ru.academits.zhuravlev_ea.circle.Circle;
import ru.academits.zhuravlev_ea.rectangle.Rectangle;
import ru.academits.zhuravlev_ea.shape.Shape;
import ru.academits.zhuravlev_ea.square.Square;
import ru.academits.zhuravlev_ea.triangle.Triangle;

import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[]{new Square(20.8), new Triangle(21.5, 56, 48.4, 25.8, 87.1, 97.8),
                new Rectangle(48.9, 34.7), new Circle(20.5), new Square(84.6), new Rectangle(74.1, 58.6),
                new Circle(67.8)};

        Shape maxArea = getMaxArea(shapes);
        Shape perimeter = getPerimeter(shapes);

        System.out.printf("Максимальна площадь из всех фигур, %s с площадью %.2f.\n", maxArea, maxArea.getArea());
        System.out.printf("Второй по величине периметр у фигуры %s равный %.2f.\n", perimeter, perimeter.getPerimeter());
    }

    private static Shape getMaxArea(Shape[] shapes) {
        Arrays.sort(shapes, getAreaComparator);
        return shapes[shapes.length - 1];
    }

    private static Shape getPerimeter(Shape[] shapes) {
        Arrays.sort(shapes, getPerimeterComparator);
        return shapes[shapes.length - 2];
    }

    public static Comparator<Shape> getAreaComparator = new Comparator<Shape>() {
        @Override
        public int compare(Shape o1, Shape o2) {
            return (int) (o1.getArea() - o2.getArea());
        }
    };

    public static Comparator<Shape> getPerimeterComparator = new Comparator<Shape>() {
        @Override
        public int compare(Shape o1, Shape o2) {
            return (int) (o1.getPerimeter() - o2.getPerimeter());
        }
    };
}
