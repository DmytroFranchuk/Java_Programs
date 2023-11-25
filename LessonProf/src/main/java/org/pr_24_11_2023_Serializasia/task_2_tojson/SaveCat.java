package org.pr_24_11_2023_Serializasia.task_2_tojson;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;

public class SaveCat {

    public static void main(String[] args) {

        try {

            File file = new File("cat.json");
            file.createNewFile();
            Cat cat = new Cat(3, "Black", 4.56);

            ObjectMapper mapper = new ObjectMapper();
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            mapper.writeValue(file, cat);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
