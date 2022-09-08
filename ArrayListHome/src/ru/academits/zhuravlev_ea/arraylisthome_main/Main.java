package ru.academits.zhuravlev_ea.arraylisthome_main;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;


public class Main {
    public static void main(String[] args) {
        try {
            ArrayList<String> lines = new ArrayList<>(Files.readAllLines(Paths.get("input.txt")));

            for (String line : lines) {
                System.out.println(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        ArrayList<Integer> integers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 7, 7, 8, 9, 2, 4, 3));
        Iterator<Integer> integerIterator = integers.iterator();

        while (integerIterator.hasNext()) {
            if (integerIterator.next()%2==0) {
                integerIterator.remove();
            }
        }

        System.out.println();
        System.out.println(integers);

        ArrayList<Integer> integersWithDuplicates = new ArrayList<>(Arrays.asList(1, 2, 2, 4, 5, 7, 7, 5, 9, 2, 4, 3));
        Set<Integer> set = new LinkedHashSet<>(integersWithDuplicates);
        ArrayList<Integer> integersWithoutDuplicates = new ArrayList<>(set);
        System.out.println();
        System.out.println(integersWithoutDuplicates);
    }
}