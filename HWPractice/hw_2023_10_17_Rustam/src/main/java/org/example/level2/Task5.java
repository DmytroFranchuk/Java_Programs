package org.example.level2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Task5 {
    public static void main(String[] args) throws IOException {
        Map<Character, Integer> map = new HashMap<>();
        FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream(new File("result.txt"));
            int date = inputStream.read();
            char key = (char)date;
            map.put(key, 1);
            while (date != -1){
                 date = inputStream.read();
                 if (date != 10){
                 key = (char)date;
                 if (map.get(key) != null)  map.put(key, map.get(key)+1);
                 else map.put(key,1);}
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        System.out.println(map);
    }
}
//посчитайте сколько раз каждая символ встречался в файле (используйте Map для хранения промежуточного результата),
//финальный результат запишите в файл