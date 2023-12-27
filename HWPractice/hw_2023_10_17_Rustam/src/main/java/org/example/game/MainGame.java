package org.example.game;

import org.apache.commons.io.input.ReversedLinesFileReader;

import java.io.*;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class MainGame {
    public static void main(String[] args) {
        File file = new File("result.txt");
        try {
            if (file.createNewFile()) {
                Scanner scanner = new Scanner(System.in);
                System.out.print("Enter your name ");
                String name = scanner.nextLine();
                GameSaveResult gameSaveResult = new GameSaveResult(name);
                playGame(file, gameSaveResult);
            } else {
                String str = readStrFromFile(file);
                GameSaveResult gameSaveResult = parseStr(str);
                playGame(file, gameSaveResult);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void playGame(File file, GameSaveResult gameSaveResult) {
        boolean isWin = ThreadLocalRandom.current().nextBoolean();
        if (isWin) gameSaveResult.setWinCounter(gameSaveResult.getWinCounter() + 1);
        else gameSaveResult.setLoseCounter(gameSaveResult.getLoseCounter() + 1);
        writeToFile(file, gameSaveResult);
    }

    private static void writeToFile(File file, GameSaveResult gameSaveResult) {
        try {
            FileWriter writer = new FileWriter(file, true);
            writer.write(gameSaveResult.getName() + ";" + gameSaveResult.getWinCounter() +
                    ";" + gameSaveResult.getLoseCounter()+"\n");
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String readStrFromFile(File file) {
        String result = null;
        try {
            ReversedLinesFileReader reader = new ReversedLinesFileReader(file);
            result = reader.readLine();
            reader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public static GameSaveResult parseStr(String str) {
        String[] date = str.split(";");
        GameSaveResult gameSaveResult = new GameSaveResult(date[0]);
        gameSaveResult.setWinCounter(Integer.parseInt(date[1]));
        gameSaveResult.setLoseCounter(Integer.parseInt(date[2]));
        return gameSaveResult;
    }

}
//- Программа в самом начале пытается посмотреть предыдущий результат в файле result.txt
//- если файла нет, то создает его и создает новый объект GameSaveResult с пустым каунтером и просит пользователя
//ввести имя с консоли
//- если файл существует, то считывает GameSaveResult из файла дальше с помощью рандома генерируется результат isWin:
//true - выигрыш
//false - проигрыш
//- увеличивается нужный каунтер и сохраняется в этот же файл
//- запустите программу несколько раз