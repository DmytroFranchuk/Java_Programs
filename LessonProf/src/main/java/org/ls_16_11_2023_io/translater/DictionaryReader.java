package org.ls_16_11_2023_io.translater;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DictionaryReader {
    private DictionaryReader() {
    }

    public static Map<String, String> read(String pathStr) throws IOException {
        Path path = Path.of(pathStr);
        if (path.toFile().isDirectory() || !path.toFile().exists()) throw
                new IllegalArgumentException("Путь не верный");
        List<String> lines = Files.readAllLines(path);
        return parse(lines);
    }

    public static Map<String, String> parse(List<String> lines) {
        Map<String, String> result  = new HashMap<>();
        for (String s : lines) {
            String key = s.substring(0, s.indexOf(" "));
            String value = s.substring(s.lastIndexOf(" ") + 1);
            result.put(key, value);
        }
        return result;
    }
}
