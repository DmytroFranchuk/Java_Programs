package de.dzLogger;

import java.nio.file.Path;

public class Main {
    public static void main(String[] args) {

        Property property = new Property();

        Logger logger = new Logger(Path.of("E:\\dzJava\\dz_23_11_2023\\logger.txt"));
        logger.debug("Debug text message");
        logger.info("Info text message");
        logger.warning("Warning text message");
        logger.error("Error text message");

        Logger loggerSystem = new Logger(Path.of("E:\\dzJava\\dz_23_11_2023\\logSystemParam.txt"));
        LogEnvironmentVariables log = new LogEnvironmentVariables(loggerSystem);
        log.systemProperties();
        log.environmentVariables();
    }
}
