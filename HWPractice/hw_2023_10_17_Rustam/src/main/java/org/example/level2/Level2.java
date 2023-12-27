package org.example.level2;

import java.io.*;


public class Level2 {
    public static void main(String[] args) {
        try {
            File file = new File("result.txt");
            System.out.println("Count signs in the file: "+ countSigns(file));
            writeToFile(file);
            readBuffer(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    // Возьмите файл из предыдущей домашки с результатами матчей, посчитайте сколько символов , встретилось в этом файле
    private static int countSigns(File file) throws IOException {
        FileInputStream inputStream = new FileInputStream(file);
        int date = inputStream.read();
        int count = 0;
        while (date != -1){
            date = inputStream.read();
            if (date != 10) count++;
        }
        inputStream.close();
        return count;
    }

    //Возьмите файл из предыдущей домашки и начните считывать его с 100 символа и считайте 200 символов, запишите это в
    //отдельный файл
    private static void writeToFile(File file) throws IOException {
        FileInputStream inputStream = new FileInputStream(file);
        FileOutputStream outputStream = new FileOutputStream(new File("result100_200.txt"));
        int date=inputStream.read();
        int count = 1;
        while (date != -1){
            date = inputStream.read();
            if (date != 10) count++;
            if (count>=100 && count<=200)
                outputStream.write((char)date);
        }
        inputStream.close();
        outputStream.close();
    }

    //Считайте дынные из файла в массив байтов(считывайте с помощью read, который считывает не по одному элементу,
    //а сразу пачку данных, распечатайте в консоль результат)
    private static void readBuffer(File file) throws IOException {
        BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(file),300);
        int i;
        while ((i = inputStream.read()) != -1){
            System.out.print((char)i);
        }
    }
}
