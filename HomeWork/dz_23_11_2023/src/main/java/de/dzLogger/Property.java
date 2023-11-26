package de.dzLogger;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Properties;

public class Property {
    private Logger logger;

    public Property() {
        if ((getPropertyFile().getProperty("log.filepath")).isBlank()) {
            this.logger = new Logger();
        } else {
            this.logger = new Logger(Path.of((String) getPropertyFile().getProperty("log.filepath")));
        }
        loggingMode();
    }

    private void loggingMode() {
        switch (getPropertyFile().getProperty("log.level")) {
            case "debug" -> {
                logger.debug("логировать всё");
                break;
            }
            case "info" -> {
                logger.debug("логировать info, warning и error сообщения");
                break;
            }
            case "warning" -> {
                logger.debug("логировать warning и error сообщения");
                break;
            }
            case "error" -> {
                logger.debug("логировать только error сообщения");
                break;
            }
            default -> {break;}


        }


    }


    public static Properties getPropertyFile() {
        Properties properties = new Properties();
        String resourcesPath = Main.class.getClassLoader().getResource("logging.properties").getPath();
        try (FileInputStream input = new FileInputStream(resourcesPath)) {
            properties.load(input);
            return properties;
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
