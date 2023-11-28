package org.pr_2023_11_24_Serializasia.task_1_serializ;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class LoadCat {

    public static void main(String[] args) {

        File file = new File("cat.txt");

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {

            Object cat1 = in.readObject();
            Cat cat2 = (Cat) in.readObject();

            System.out.println("Прочитанные из файла коты:");
            System.out.println(cat1);
            System.out.println(cat2);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
