package de.dzJava.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import de.dzJava.modelTask2.Car;
import de.dzJava.modelTask2.Engine;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TestTask2 {
    private List<Car> cars = new ArrayList<>();

    public TestTask2() {
        cars.add(new Car("Toyota", 2022, 25000.50, new Engine("V8", 300)));
        cars.add(new Car("Ford", 2023, 27000.75, new Engine("V6", 250)));
        cars.add(new Car("Honda", 2021, 22000.30, new Engine("V12", 350)));
        cars.add(new Car("BMW", 2024, 30000.80, new Engine("V10", 320)));
    }

    public void toJsonFile(String path) {

        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        try {
            mapper.writeValue(new File(path), cars);
            System.out.println("File " + path + " created.");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
