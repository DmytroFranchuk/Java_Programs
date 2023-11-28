package org.pr_2023_11_24_Serializasia.task_1_serializ;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class SaveCat {

    public static void main(String[] args) {

        File file = new File("cat.txt");

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file, true))) {

            file.createNewFile();

            Cat cat1 = new Cat(3, "Black", 4.56);
            Cat cat2 = new Cat(5, "White", 7.65);
            System.out.println("Созданные коты:");
            System.out.println(cat1);
            System.out.println(cat2);

            out.writeObject(cat1);
            out.writeObject(cat2);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}