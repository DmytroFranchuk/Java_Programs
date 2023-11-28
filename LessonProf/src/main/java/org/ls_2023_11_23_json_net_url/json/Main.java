package org.ls_2023_11_23_json_net_url.json;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {
    /*
    *
    * 1 Конвертировать данные из Json в объект:
      2 Создать объект с 3-4 полями разных типов (в т.ч. ссылочных) и записать объект в файл в виде Json.
      3 Конвертировать объект из одного класса в другой с помощью метода convertValue класса ObjectMapper.
    * Классы не должны быть связаны общей иерархией, но имеют одинаковый набор полей.*/
    public static void main(String[] args) throws IOException {
        ObjectMapper om = new ObjectMapper();
        String windowStr = Files.readString(Path.of("Example0.json"));
        System.out.println(windowStr);
        Window window = om.readValue(windowStr, Window.class);
        System.out.println(window);

        Person person = new Person("John", 30, new Address("123 Main St", "City"));
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(new File("person.json"), person);
            System.out.println("Объект Person записан в файл 'person.json'");
        } catch (IOException e) {
            e.printStackTrace();
        }

        ObjectMapper objectMapper = new ObjectMapper();
        PersonDTO personDTO = mapper.convertValue(person, PersonDTO.class);
        System.out.println("Конвертированный объект Person в PersonDTO: ");
        System.out.println(personDTO);

    }
}
