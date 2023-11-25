package de.dzJava.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.dzJava.modelTask1.ExData;

import java.io.File;
import java.io.IOException;

public class TestTask1 {

    public static ExData toExData(String path) {
        try {
            return new ObjectMapper().readValue(new File(path), ExData.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
