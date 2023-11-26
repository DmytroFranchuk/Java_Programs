package de.dzJava.service;

import com.jayway.jsonpath.JsonPath;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

import static java.nio.file.Paths.*;

public class TestTask3 {

    public static void printAgeFromJsonFile(String path) {
        try {
//            String json = new String(Files.readAllBytes(get("Example1.json")));
            List<Integer> ages = JsonPath.read(new File(path), "$..age");
            for (int age : ages) {
                System.out.println("Значение поля age: " + age);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
