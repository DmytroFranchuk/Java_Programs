package org.example.level2;

import java.io.*;
import java.nio.file.Path;
import java.util.Arrays;

public class Task4 {
    public static void main(String[] args) throws IOException {
        try {
            Path path = Path.of("Hello.txt");
            Path path1 = Path.of("Hello1.txt");
            FileWriter writer = new FileWriter(String.valueOf(path));
            writer.write("Привет мир");
            writer.close();

            FileInputStream inputStream = new FileInputStream(String.valueOf(path));
            byte[] bytes = inputStream.readAllBytes();
            inputStream.close();

            ByteArrayInputStream inputStream1 = new ByteArrayInputStream(bytes);

            FileOutputStream outputStream = new FileOutputStream(String.valueOf(path1));
            for (int i = 0; i < bytes.length; i++) {
                outputStream.write(bytes[i]);
            }

            inputStream1.close();
            outputStream.close();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
    //Создайте файл и запишите туда строку Привет мир с помощью FileInputStream и метода readAllBytes считайте все
    //байты в массив байтов
    //- возьмите ByteArrayInputStream и считайте все байты из массива, запишите результат в другой файл
}
