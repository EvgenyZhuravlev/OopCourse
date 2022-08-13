package ru.academits.zhuravlev_ea.csv_main;


import java.io.*;

public class csv_main {
    public static void main(String[] args){
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("input.csv"))) {
            String s;

            while ((s = bufferedReader.readLine()) != null) {
                System.out.print(s);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}