package org.example.task1_2;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MainReadWrite {
    public static void main(String[] args) {
        Path path = Paths.get("testFile.txt");
        try {
            System.out.println(readOneStrFromFile(path));
            writeOneStrToFile(path, "Напишите метод, который будет записывать строку в файл\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //Напишите метод, который будет считывать с файла строку,
    // подумайте что лучше использовать в этом случае (IS vs Reader)
    public static String readOneStrFromFile(Path path) throws FileNotFoundException {
        String result = null;
        File file = new File(String.valueOf(path));
        BufferedReader reader = new BufferedReader(new FileReader(file));
        try {
            if (reader.ready()){
                result = reader.readLine();
                reader.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    //Напишите метод, который будет записывать строку в файл, подумайте что лучше использовать в этом случае
    // (OS vs Writer)
    public static void writeOneStrToFile(Path path, String str) throws IOException {
        FileWriter writer = new FileWriter(String.valueOf(path), true);
        writer.write(str);
        writer.close();
    }
}