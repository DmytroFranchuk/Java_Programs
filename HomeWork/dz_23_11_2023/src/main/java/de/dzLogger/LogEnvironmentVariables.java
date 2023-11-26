package de.dzLogger;

import java.util.Map;

public class LogEnvironmentVariables {
    Logger logger;

    public LogEnvironmentVariables(Logger logger) {
        this.logger = logger;
    }

    public void systemProperties() {
        String str = "\n";
        for (Map.Entry<Object, Object> property : System.getProperties().entrySet()) {
            str += ((property.getKey() + " = " + property.getValue())) + "\n";
        }
        logger.info("System properties: " + str);
    }

    public void environmentVariables() {
        String str = "\n";
        Map<String, String> envVariables = System.getenv();
        for (Map.Entry<String, String> entry : envVariables.entrySet()) {
            str += (entry.getKey() + " = " + entry.getValue()) + "\n";
        }
        logger.info("Environment variables:" + str);

    }






}
