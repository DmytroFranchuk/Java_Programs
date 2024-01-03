package org.example.level2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task4 {
    public static void main(String[] args) throws IOException {
        List<String> types  = new ArrayList<>();
        List<String> id = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("test-data.xml"));
            Pattern p1 = Pattern.compile("(sf:type)");
            Pattern p2 = Pattern.compile("(PermissionSetAssignment)");
            while (reader.ready()){
                String str = reader.readLine().trim();
                Matcher m1 = p1.matcher(str);
                if (m1.find()) {
                    types.add(str.substring(9, str.length()-10));
                }
                Matcher m2 = p2.matcher(str);
                if (m2.find()) {
                    String nextStr = reader.readLine().trim();
                    id.add(nextStr.substring(7, nextStr.length()-8));
                }
            }
            reader.close();
            System.out.println(types);
            System.out.println(id);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
//Дан файл (похоже на реальный пример данных, который отправляет сторонний сервис), с помощью регулярных выражений нужно получить:
//- Название всех типов(sf:type)
//- Id всех PermissionSetAssignment