package ru.academits.zhuravlev_ea.reader;

import java.io.*;

public class Reader {
    private BufferedReader bufferedReader;


    public Reader(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        InputStream inputStream = new FileInputStream(file);
        bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
    }
}
