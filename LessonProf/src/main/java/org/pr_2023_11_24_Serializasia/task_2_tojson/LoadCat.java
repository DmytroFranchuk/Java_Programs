package org.pr_2023_11_24_Serializasia.task_2_tojson;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

public class LoadCat {

    public static void main(String[] args) {

        try {
            File file = new File("cat.json");
            ObjectMapper mapper = new ObjectMapper();
            Cat cat = mapper.readValue(file, Cat.class);
            System.out.println(cat);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
